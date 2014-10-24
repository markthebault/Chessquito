package chessquito;

import java.util.ArrayList;

/**
 * classe permettant la creation et la manipulation d'un fou
 */

class Fou extends Piece
{
    /**
     * construit un fou
     * 
     * @param couleur
     *            couleur du fou
     */
    public Fou(Couleur couleur)
    {
        // A COMPLETER (fait)
        super("Fou", couleur, 2, true);
    }

    /**
     * fournit les vecteurs unitaires de deplacement du fou
     * 
     * @return liste des vecteurs de deplacement
     */
    public ArrayList<Position> getVecteursDeplacement()
    {
        // A COMPLETER (fait)
        ArrayList<Position> l = new ArrayList<Position>();
        
        l.add(new Position(1,1) );
        
        l.add(new Position(-1,-1) );
        
        l.add(new Position(-1,1) );
        
        l.add(new Position(1,-1) );

        
        return l;
    }
}
