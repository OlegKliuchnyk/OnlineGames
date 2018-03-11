package ok.games.shared.exception;

public class IncorrectOperationException extends GameBusinessException {
    public IncorrectOperationException(String message) {
        super(message);
    }

    public IncorrectOperationException(String message, Throwable cause) {
        super(message, cause);
    }
}
