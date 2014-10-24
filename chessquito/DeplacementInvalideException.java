package chessquito;

/**
 * exception declenchee lorsqu'un deplacement ne peut pas etre effectue
 */

public class DeplacementInvalideException extends ChessquitoException {
    private static final long serialVersionUID = 1L;

    /**
     * construit une exception CaseVide
     */
    public DeplacementInvalideException() {
        super("le deplacement n'est pas valide");
    }
}
