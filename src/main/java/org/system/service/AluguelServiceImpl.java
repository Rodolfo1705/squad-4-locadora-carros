    package org.system.service;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;
    import org.system.entity.Aluguel;
    import org.system.repository.AluguelRepository;
    import org.system.service.interfaces.AluguelService;

    import java.util.List;

    @Service
    public class AluguelServiceImpl implements AluguelService {

        @Autowired
        private AluguelRepository aluguelRepository;
        public List<Aluguel> findAll() {
            return aluguelRepository.findAll();
        }

        public Aluguel save(Aluguel aluguel) {
            try {
                return aluguelRepository.save(aluguel);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }
