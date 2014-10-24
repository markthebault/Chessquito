package chessquito;

/**
 * exception declenchee lorsqu'une case contient deja une piece
 */

public class CaseNonVideException extends ChessquitoException {
    private static final long serialVersionUID = 1L;

    /**
     * construit une exception CaseNonVide
     */
    public CaseNonVideException() {
        super("Il n'y a pas de piece sur la case");
    }
}
