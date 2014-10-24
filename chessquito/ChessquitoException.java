package chessquito;

/**
 * classe de base des exceptions du jeu de Chessquito
 */

public class ChessquitoException extends Exception {
    private static final long serialVersionUID = 1L;

    /**
     * construit une exception chessquito
     * 
     * @param message
     *            message lie a l'exception
     */
    public ChessquitoException(String message) {
        super(message);
    }
}
