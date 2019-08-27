package core.exceptions;

/**
 * This kind of exception occurs when the project itself is configured incorrectly or some operation is misused.
 * For example, if some file should exist in classpath, but it's removed or renamed.
 * Raising this exception usually is cause of an another exception.
 *
 * @author maris.salenieks
 * @version 1.0.
 * @since 1.0.
 */
public class BadSetupException extends RuntimeException {

    public BadSetupException(String message) {
        super(message);
    }

    public BadSetupException(String message, Object... msgFormatParams) {
        super(String.format(message, msgFormatParams));
    }

    public BadSetupException(Throwable throwable) {
        super(throwable);
    }

    public BadSetupException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
