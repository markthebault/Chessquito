package chessquito;

import java.util.ArrayList;

/**
 * classe permettant la creation et la manipulation d'un cavalier
 */

public class Cavalier extends Piece
{
    /**
     * construit un cavalier
     * 
     * @param couleur
     *            couleur du cavalier
     */
    public Cavalier(Couleur couleur)
    {
        // A COMPLETER (fait)
        super("Cavalier", couleur, 3, false);
    }

    /**
     * fournit les vecteurs unitaires de deplacement du cavalier
     * 
     * @return liste des vecteurs de deplacement
     */
    public ArrayList<Position> getVecteursDeplacement()
    {
        // A COMPLETER (fait)
        ArrayList<Position> l = new ArrayList<Position>();
        
        l.add(new Position(1,2) );
        l.add(new Position(-1,2) );
        l.add(new Position(2,1) );
        l.add(new Position(2,-1) );
        l.add(new Position(-2,1) );
        l.add(new Position(-2,-1) );
        l.add(new Position(1,-2) );
        l.add(new Position(-1,-2) );
        
        return l;
    }
}

