package chessquito;

import java.util.ArrayList;
import java.util.List;

/**
 * classe abstraite permettant la creation et la manipulation d'une piece
 * 
 * @see Echiquier
 * @see Position
 */

abstract public class Piece 
{
    /**
     * couleur de la piece
     */
    private Couleur couleur;

    /**
     * nom de la piece
     */
    private String nom;

    /**
     * position de la piece sur l'echiquier
     */
    private Position position;

    /**
     * valeur de la piece
     */
    private int valeur;

    /**
     * indique si la piece peut enchainer plusieurs deplacements
     */
    private boolean deplacementMultiple;

    /**
     * construit une piece
     * 
     * @param nom
     *            nom de la piece de nom
     * @param couleur
     *            couleur de la piece
     * @param valeur
     *            valeur de la piece
     */
    public Piece(String nom, Couleur couleur, int valeur,
            boolean deplacementMultiple) 
    {
        // A COMPLETER (fait)
        this.nom = nom;
        this.couleur = couleur;
        this.valeur = valeur;
        
        this.position = new Position();
        this.deplacementMultiple = deplacementMultiple;
    }

    /**
     * fournit les vecteurs unitaires de deplacement de la piece
     * 
     * @return ensemble des positions accessibles par la piece
     */
    public abstract ArrayList<Position> getVecteursDeplacement();

    /**
     * fournit le nom de la piece
     * 
     * @return le nom de la piece
     */
    public String getNom()
    {
        return this.nom;
    }

    /**
     * fournit la couleur de la piece
     * 
     * @return couleur de la piece
     */
    public Couleur getCouleur()
    {
        return this.couleur;
    }

    /**
     * retourne la position de la piece sur l'echiquier
     * 
     * @return position de la piece
     */
    public Position getPosition()
    {
        return this.position;
    }

    /**
     * fournit la valeur de la piece
     * 
     * @return la valeur de la piece
     */
    public int getValeur()
    {
        return this.valeur;
    }

    /**
     * positionne la piece a une position donnee
     * 
     * @param position
     *            position de la piece
     */
    public void setPosition(Position position)
    {
        this.position = position;
    }

    /**
     * retourne l'initiale de la piece (majuscule si noir, minuscule si blanc)
     * 
     * @return initiale de la piece
     */
    public char initiale()
    {
        if (this.couleur == Couleur.NOIR) 
        {
            return (this.nom.toUpperCase().charAt(0));
        } 
        else 
        {
            return (this.nom.toLowerCase().charAt(0));
        }
    }

    /**
     * recherche toutes les positions accessibles par la piece
     * 
     * @param echiquier
     *            echiquier ou se trouvent les pieces
     * @return liste des positions accessibles par la piece
     */
    public List<Position> positionsAccessibles(Echiquier echiquier)
    {
        // A COMPLETER
        // recuperer les vecteurs de deplacement unitaires de la piece
        ArrayList<Position> listVecteurs = this.getVecteursDeplacement();
        
        // creer une liste vide des positions accessibles par la piece
        ArrayList<Position> listPositions = new ArrayList<Position>();
        boolean dejaAjoute = false;
        
        try
        {
		    // pour chaque vecteur de deplacement
		    for( Position p : listVecteurs)
		    {   
		    	Position pos = this.position;
				// tant que la piece peut progresser dans la direction du vecteur
				// ajouter le vecteur de deplacement a la position de la piece
				pos = pos.ajouter(p);
				 
				
				
				
				if(echiquier.estPositionValide(pos) && echiquier.estCaseVide(pos) && !this.deplacementMultiple)
				{
					listPositions.add(pos);
					dejaAjoute = true;
				}
				
				//si on peut se déplacer plusieurs fois
		    	while ( echiquier.estPositionValide(pos) && echiquier.estCaseVide(pos) && this.deplacementMultiple )
		    	{
		    		listPositions.add(pos);
		    	
		    		//passer a la case suivante
		    		pos = pos.ajouter(p);
		    	}
		    	
		    	//Si case est occupée par une pièce énemie on peut y acceder pour la manger !!!! (miam)
		    	if(echiquier.getPiece(pos) != null && echiquier.getPiece(pos).getCouleur() != this.couleur && !dejaAjoute)
		    	{
		    		listPositions.add(pos);
		    	}
		    	
        	}
        }
        catch(Exception e)
        {
            e.printStackTrace() ;
            System.out.println(e);
            System.exit(1);
        }
        // si la position est valide
        // examiner s'il y a une piece a cette position
        // si ce n'est pas le cas
        // ajouter la position a la liste des positions
        // accessibles
        // sinon ajouter la position si la piece n'est pas de la
        // meme couleur que le piece jouee et arreter la
        // progression sur le vecteur
    	return listPositions;
   	}
} 
