package chessquito;

/**
 * exception declenchee lorsqu'une piece n'est pas de la couleur attendue
 */

public class CouleurPieceException extends ChessquitoException {
    private static final long serialVersionUID = 1L;

    /**
     * construit une exception CouleurPiece
     */
    public CouleurPieceException() {
        super("la piece jouee n'est pas de la bonne couleur");
    }
}
