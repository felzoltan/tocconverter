package hu.sonrisa.tocconverter;

public class BusinesException extends RuntimeException {
    private final int errorCode;

    public BusinesException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
}
