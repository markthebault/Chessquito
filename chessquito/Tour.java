package chessquito;

import java.util.ArrayList;

/**
 * classe permettant la creation et la manipulation d'une tour
 */

class Tour extends Piece
{
    /**
     * construit une tour
     * 
     * @param couleur
     *            couleur de la tour
     */
    public Tour(Couleur couleur)
    {
        // A COMPLETER (fait)
        super("Tour", couleur, 4, true);
    }

    /**
     * fournit les vecteurs unitaires de deplacement de la tour
     * 
     * @return liste des vecteurs unitaires
     */
    public ArrayList<Position> getVecteursDeplacement()
    {
        // A COMPLETER (fait)
        ArrayList<Position> l = new ArrayList<Position>();
        
        l.add(new Position(1,0));
        
        l.add(new Position(-1,0) );
        
        l.add(new Position(0,1) );
        
        l.add(new Position(0,-1) );

        
        return l;
    }
}
