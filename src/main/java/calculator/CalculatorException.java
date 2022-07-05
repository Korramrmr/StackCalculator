package calculator;

public final class CalculatorException extends Exception{

    public CalculatorException(final String warningMessage) {
        super(warningMessage);
    }

    public CalculatorException(final String warningMessage, final Throwable cause) {
        super(warningMessage, cause);
    }

    public CalculatorException(final Throwable cause) {
        super(cause);
    }

    public CalculatorException(final String warningMessage, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(warningMessage, cause, enableSuppression, writableStackTrace);
    }

}
