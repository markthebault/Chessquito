package chessquito;

/**
 * exception declenchee lorsqu'une position ne correspond pas a une position de
 * l'echiquier
 */
public class PositionInvalideException extends ChessquitoException {
    private static final long serialVersionUID = 1L;

    /**
     * construit une exception PositionInvalide
     */
    public PositionInvalideException() {
        super("la position n'est pas valide");
    }
}
