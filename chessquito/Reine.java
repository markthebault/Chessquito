package chessquito;

import java.util.ArrayList;

/**
 * classe permettant la creation et la manipulation d'une reine
 */
class Reine extends Piece 
{
    /**
     * construit une reine
     * 
     * @param couleur
     *            couleur de la reine
     */
    public Reine(Couleur couleur) 
    {
        // A COMPLETER (fait)
        super("Reine", couleur, 5, true);
    }

    /**
     * fournit les vecteurs unitaires de deplacement de la reine
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


        l.add(new Position(1,0) );        
        l.add(new Position(-1,0) );        
        l.add(new Position(0,1) );        
        l.add(new Position(0,-1) );
        
        return l;
    }
}
