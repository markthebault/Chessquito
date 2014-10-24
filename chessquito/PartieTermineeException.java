package chessquito;

/**
 * exception declenchee lorsque la partie est deja terminee
 */

public class PartieTermineeException extends ChessquitoException {
    private static final long serialVersionUID = 1L;

    /**
     * construit une exception Partie Terminee
     */
    public PartieTermineeException() {
        super("La partie est terminee");
    }
}
