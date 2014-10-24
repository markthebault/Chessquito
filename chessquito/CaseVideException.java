package chessquito;

/**
 * exception declenchee lorsqu'une case ne contient pas de piece
 */

public class CaseVideException extends ChessquitoException {
    private static final long serialVersionUID = 1L;

    /**
     * construit une exception CaseVide
     */
    public CaseVideException() {
        super("Il n'y a aucune piece sur la case");
    }
}
