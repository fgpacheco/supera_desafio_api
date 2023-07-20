package br.com.banco.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class DataUtils {

    private static final DateTimeFormatter FORMATO_DATA_HORA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public static String formatarDataHora(LocalDateTime ldt) {
        return ldt.format(FORMATO_DATA_HORA);
    }

    public static LocalDateTime obterLocalDateTime(String dataHora) {
        return LocalDateTime.parse(dataHora, FORMATO_DATA_HORA);
    }

    private DataUtils() {
    }

}
