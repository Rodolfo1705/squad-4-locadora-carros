package org.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.system.entity.Motorista;
import org.system.repository.MotoristaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MotoristaServiceImpl implements MotoristaService{
    @Autowired
    private MotoristaRepository motoristaRepository;

    public List<Motorista> findAll() {
        return motoristaRepository.findAll();
    }

    @Transactional
    public void addMotorista(Motorista motorista) {
        motoristaRepository.saveAndFlush(motorista);
    }

    public Motorista save(Motorista motorista) {
        try {
            if (!isCPF(motorista.getCpf())){
                throw new IllegalArgumentException("CPF inválido");
            }

            if (!isCNH(motorista.getNumeroCNH())) {
                throw new IllegalArgumentException("CNH inválida");
            }

            motorista.setCpf(formatCPF(motorista.getCpf()));

            return motoristaRepository.save(motorista);
        } catch (Exception e) {
            throw new RuntimeException( e.getMessage());
        }
    }

    private boolean isCPF(String CPF) {
        try {
            String cpf = CPF.replace(".", "").replace("-", "");
            if (cpf.length() != 11) {
                return false;
            }

            Long.parseLong(cpf);

            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isCNH(String CNH) {
        try {
            String cnh = CNH.replace(".", "").replace("-", "");
            if (cnh.length() != 10) {
                return false;
            }

            Long.parseLong(cnh);

            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static String formatCPF(String CPF) {
        return(CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." +
                CPF.substring(6, 9) + "-" + CPF.substring(9, 11));
    }

    /*public Motorista findByEmail(@PathVariable String email){
        return motoristaRepository.findByEmail(email).get();
    }*/
}