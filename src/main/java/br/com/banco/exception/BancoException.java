package br.com.banco.exception;

public class BancoException extends RuntimeException {

    private static final long serialVersionUID = -6322442248777453905L;

    public BancoException() {
    }

    public BancoException(String message) {
        super(message);
    }

    public BancoException(Throwable cause) {
        super(cause);
    }
}
