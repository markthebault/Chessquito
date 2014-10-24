package chessquito;

import java.util.ArrayList;
import java.util.List;

/**
 * classe permettant la creation et la manipulation de l'echiquier sur lequel
 * les pieces des joueurs sont disposees
 */

public class Echiquier 
{
    /**
     * taille de la grille
     */
    public static final int NB_LIG_COL = 4;

    /**
     * liste des pieces presentes sur l'echiquier
     */
    private Collection<Piece> pieces;

    /**
     * construit un echiquier
     */
    public Echiquier() 
    {
        this.pieces = new ArrayList<Piece>();
    }


	/**
	*	suprime une piece donne de la liste des pieces
	*
	*	@param piece
	*
	*/
	public void supprimerPiece (Piece pi)
	{
		pieces.remove(pi);
	}

    /**
     * accede a une piece a partir de sa position
     * 
     * @param position
     *            position de la piece a acceder
     * @return la piece ou null s'il n'y a pas de piece a cette position
     */
    public Piece getPiece(Position position) 
    {
        // A COMPLETER (fait)
        // rechercher la piece dans la liste des pieces
        // et la retourner si on l'y trouve
        // sinon retourner null
        for(Piece p : this.pieces)
        {
        	if(p.getPosition().equals(position))
        	{
        		//on a trouvé la pièce
        		return p;
        	}    
        }
        
        return null;
    }

    /**
     * positionne une piece sur l'echiquier
     * 
     * @param position
     *            position ou la piece doit etre positionnee
     * @param piece
     *            piece a positionner
     * @exception PositionInvalideException
     *                si la position n'existe
     * @exception CaseNonVideException
     *                s'il y a deja une piece sur la case
     */
    public void setPiece(Position position, Piece piece)
            throws PositionInvalideException, CaseNonVideException 
    {
        // A COMPLETER (fait)
        // la position doit exister
        if(!this.estPositionValide(position))
        {
        	throw (new PositionInvalideException());
        }

        // il ne doit pas y avoir de piece a cette position
        if(!this.estCaseVide(position))
        {
        	throw (new CaseNonVideException());
        }
        
        // attribuer cette position à la piece
        piece.setPosition(position);
        
        // ajouter la piece a l'echiquier
        this.pieces.add(piece);
    }

    /**
     * verifie si une position correspond a une case de l'echiquier
     * 
     * @param position
     *            position a verifier
     * @return vrai si la position est valide
     */
    public boolean estPositionValide(Position position) 
    {
        int x = position.valX();
        int y = position.valY();
        return !(x < 0 || x >= Echiquier.NB_LIG_COL || y < 0 || y >= Echiquier.NB_LIG_COL);
    }

    /**
     * verifie qu'une case de l'echiquier n'est pas vide
     * 
     * @param position
     *            position de la case sur l'echiquier
     * @return vrai si la case est vide
     * @exception PositionInvalideException
     *                si la position n'est pas valide
     */
    public boolean estCaseVide(Position position)
            throws PositionInvalideException
    {
        return (this.getPiece(position) == null);
    }

    /**
     * renvoie le nombre de pieces sur l'echiquier
     * 
     * @return nombre de pieces
     */
    public int nombrePieces()
    {
        return this.pieces.size();
    }

    /**
     * nombre de points d'un joueur
     * 
     * @param couleur
     *            couleur du joueur
     * @return nombre de points
     */
    public int points(Couleur couleur) 
    {
        // A COMPLETER (fait)
        int valeur = 0;
        // ajouter toutes les valeurs des pieces de la couleur souhaitee
        // qui sont sur l'echiquier
        for(Piece p : this.pieces)
        {
        	if(p.getCouleur() == couleur)
        	{
        		valeur += p.getValeur();
        	}
        }
        
        return valeur;
    }

    /**
     * calcule et affiche les deplacements possibles d'une piece
     * 
     * @param depart
     *            position de la piece
     */
    public void calculerDeplacements(Position depart) 
    {
        // A COMPLETER (fait)
        Piece p;
        
        // recuperer la piece a deplacer
        p = this.getPiece(depart);
        
        // demander a la piece de calculer la liste des positions accessibles
        // afficher cette liste
        for(Position pos : p.positionsAccessibles(this))
        {
        	System.out.println("Une des possibilités de déplacement de la piece "+p+" est : "+pos);
        }

    }

    /**
     * retourne une version unicode de l'echiquier
     * 
     * @return echiquier converti en chaîne de caracteres
     */
    public String toString() 
    {
        String contenu;
        boolean estBlanc = false;
        String res = "";
        
        try 
        {
            res = res + "    0   1   2   3  \n";
            res = res + "  -----------------\n";
            for (int i = 0; i < Echiquier.NB_LIG_COL; i++) 
            {
                contenu = " " + (new Integer(i));
                contenu = contenu + " ";
                res = res + contenu + "|";
                for (int j = 0; j < Echiquier.NB_LIG_COL; j++) 
                {
                    if (this.getPiece(new Position(i, j)) == null) 
                    {
                        contenu = "   ";
                    } 
                    else 
                    {
                        contenu = " ";
                        contenu += this.getPiece(new Position(i, j)).initiale();
                        contenu += " ";
                    }
                   
                    if (estBlanc) 
                    {
                        // res = res + "\033[0m" + contenu + "|" ;
                        res = res + contenu + "|";
                    } 
                    else 
                    {
                        // res = res + "\033[7m" + contenu+ "\033[0m" + "|";
                        res = res + contenu + "|";
                    }
                    estBlanc = !estBlanc;
                }
                estBlanc = !estBlanc;
                contenu = (new Integer(i)).toString();
                res = res + contenu + "\n";
                res = res + "  -----------------\n";
            }
            res = res + "    0   1   2   3   \n";
        } 
        catch (Exception e) 
        {
        }
        
        return (res);
    }
}
