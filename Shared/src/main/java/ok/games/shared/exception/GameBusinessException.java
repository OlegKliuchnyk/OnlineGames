package ok.games.shared.exception;

public class GameBusinessException extends GameException {
    public GameBusinessException(String message) {
        super(message);
    }

    public GameBusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
