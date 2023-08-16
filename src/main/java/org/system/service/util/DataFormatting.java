package org.system.service.util;

public class DataFormatting {

    public static String formatarCpf(String cpf) {
        String numerosCpf = cpf.replaceAll("[^0-9]", "");

        if (numerosCpf.length() != 11) {
            throw new IllegalArgumentException("CPF inválido");
        }

        // Formata o CPF no padrão comum (XXX.XXX.XXX-XX)
        return String.format("%s.%s.%s-%s",
                numerosCpf.substring(0, 3),
                numerosCpf.substring(3, 6),
                numerosCpf.substring(6, 9),
                numerosCpf.substring(9));
    }
}
