package chessquito;

/**
 * classe permettant la creation et la manipulation d'une partie de chessquito
 */
public class Partie 
{
    /**
     * echiquier sur lequel les pieces sont positionnees
     */
    private Echiquier echiquier;
    
    /**
    * definie l'état de la partie
    */
    private EtatPartie etat;
    
    /**
    * joueur devant jouer
    */
    private Couleur couleurEnCours;
    
    /**
    * Nombre de coups sans prise
    */
    private int nbCoupsSansPrise;

    /**
     * constructeur d'une partie
     */
    public Partie() 
    {
        this.echiquier = new Echiquier();
        this.remplirEchiquier();
        this.etat = EtatPartie.PARTIE_EN_COURS;
        this.couleurEnCours = Couleur.BLANC;
        this.nbCoupsSansPrise = 0;
    }
	
	/**
	*	Informe si la partie est fini
	*	
	*	@return si oui ou non c'est fini
	*/
	public boolean estFinie()
	{
		if(this.etat == EtatPartie.PARTIE_NULLE || this.etat == EtatPartie.PARTIE_GAGNEE_BLANC || this.etat == EtatPartie.PARTIE_GAGNEE_NOIR)
        {
        	return true;        
        }
        else
        {
        	return false;
        }
     }

	/**
	*	Met a jour le nombre de coups sans prise
	*	en rajoutant 1 au nombre de coups sans prise
	*	
	*/
	 public void augmtNbCoupsSansPrise()
	 {
	 	this.nbCoupsSansPrise = this.nbCoupsSansPrise + 1;
	 }
	
	
	/**
	*	Met a jour le nombre de coups sans prise
	*	en le remettant à 0
	*	
	*/
	public void iniNBCoupsSansPrise()
	{
		this.nbCoupsSansPrise = 0;
	}
	
	
    /**
     * calcule les deplacements possibles d'une piece
     * 
     * @param depart
     *            : position ou se trouve la piece a deplacer
     * @exception PositionInvalideException
     *                si la position de départ n'est pas correcte
     * @exception CaseVideException
     *                s'il n'y a pas de piece en position depart
     */
    /*public void calculerDeplacements(Position depart)
            throws PositionInvalideException, CaseVideException    
    {
        // A COMPLETER (fait)
        // la position doit exister
        if (!this.echiquier.estPositionValide(depart))
        {
        	throw new PositionInvalideException();
        }
        
        // il doit y avoir une piece sur la case depart
        if(this.echiquier.estCaseVide(depart))
        {
        	throw (new CaseVideException());
        }
        // demander à l'échiquier de calculer et d'afficher
        // les deplacements possibles
        // de la piece situee en position depart
        this.echiquier.calculerDeplacements(depart);
    }*/
    
    
    /**
    * change la couleur du joueur à qui est le tour
    *
    * @param c
    *		: couleur du joueur qui doit jouer
    */
    public void changerCouleurEnCours ( )
    {
    	if ( this.getCouleurEnCours() == Couleur.BLANC)
    	{
    		this.couleurEnCours = Couleur.NOIR;
    	}
    	else
    	{
    		this.couleurEnCours = Couleur.BLANC;
    	}
    }
    
     /**
    * change l'etat de la partie
    *
    * @param etat
    *		: nouvel etat
    */
    public void setEtat ( EtatPartie etat)
    {
    	this.etat = etat;
    }
    
    /**
    * renvoie la couleur du joueur qui doit jouer
    *
    *	@return la couleur du joueur qui doit jouer
    */
    public Couleur getCouleurEnCours()
    {
    	return this.couleurEnCours;
    }
    
    
    
     /**
     * calcule les deplacements possibles d'une piece
     * 
     * @param depart
     *            : position ou se trouve la piece a deplacer
     * @exception PositionInvalideException
     *                si la position de départ n'est pas correcte
     * @exception CaseVideException
     *                s'il n'y a pas de piece en position depart
     */     
    public void jouer(Position depart, Position arriver)
            throws PartieTermineeException, PositionInvalideException, 
            CouleurPieceException, CaseVideException, DeplacementInvalideException

    {
    	Couleur couleurPasEnCours;
    	boolean possible = false;
        // A COMPLETER (fait)
        
        System.out.println("c'est au joueur " + this.getCouleurEnCours() +" de jouer\n");
        
        // la position doit exister
        if (!this.echiquier.estPositionValide(depart))
        {
        	throw new PositionInvalideException();
        }
              
        // il doit y avoir une piece sur la case depart
        if(this.echiquier.estCaseVide(depart))
        {
        	throw (new CaseVideException());
        }
        
        //La partie doit etre en cours
        if(this.estFinie())
        {
        	throw new PartieTermineeException();        
        }
        
        //la piece sélectionnee doit etre de la meme couleur que le joueur qui doit jouer
        if(this.echiquier.getPiece(depart).getCouleur() != this.getCouleurEnCours())
        {
        	throw new CouleurPieceException();
        }
                
        //la case d'arriver doit etre valide
        if(!this.echiquier.estPositionValide(arriver) )
        {
        	throw new DeplacementInvalideException();
        }
        
        
         // Si la case d arrivee est occupee, il faut qu'elle soit d'une autre couleur(la piece)
        if(!this.echiquier.estCaseVide(arriver) && this.echiquier.getPiece(arriver).getCouleur() == this.getCouleurEnCours())
        {
        	throw new DeplacementInvalideException();   
        }
        
        
        for(Position p : this.echiquier.getPiece(depart).positionsAccessibles(this.echiquier))
        {
        	if(p.equals(arriver))
        	{
        		possible = true;
        	}
        }
        
        if( possible )
        {
		    if( !this.echiquier.estCaseVide(arriver))
		    {
		    	//on supprime la piece mangee
		    	this.echiquier.supprimerPiece(this.echiquier.getPiece(arriver));
		    	//on remet a 0 le nombre de coups sans prise
		    	this.iniNBCoupsSansPrise();
		    }
		    else
		    {
		    	//sinon on augment le nombre de coups sans prise de 1
		    	this.augmtNbCoupsSansPrise();
		    }
		    
		    //deplace la piece
			this.echiquier.getPiece(depart).setPosition(arriver);	
		    
		    //on verifie si la partie est nulle
		    if ( this.nbCoupsSansPrise == 5 )
		    {
		    	this.setEtat(EtatPartie.PARTIE_NULLE);
		    }
		    
		    if(this.getCouleurEnCours() == Couleur.NOIR)
		    {
			    couleurPasEnCours = Couleur.BLANC;
			}
			else
			{
				couleurPasEnCours = Couleur.NOIR;
			}
		    //on verifie si le joueur en cour a gagne la partie
		    if( this.echiquier.points(couleurPasEnCours) == 0 )
		    {
		    	if(this.getCouleurEnCours() == Couleur.BLANC)
		    	{
		    		this.setEtat(EtatPartie.PARTIE_GAGNEE_BLANC);
				}
				else
				{
					this.setEtat(EtatPartie.PARTIE_GAGNEE_NOIR);
				}    
			}    
		
			//on change la couleur du joueur qui doit jouer
			this.changerCouleurEnCours();
		}
		else
		{
			System.out.println("La position d'arrivé n'est pas valide");
		}
		
        
    }

    /**
     * positionne les pieces sur le plateau
     */
    public void remplirEchiquier() 
    {
        try 
        {
            this.echiquier.setPiece(new Position(0, 0), new Tour(Couleur.NOIR));
            this.echiquier.setPiece(new Position(0, 1), new Cavalier(Couleur.NOIR));
            this.echiquier.setPiece(new Position(0, 2), new Fou(Couleur.NOIR));            
            this.echiquier.setPiece(new Position(0, Echiquier.NB_LIG_COL - 1),new Reine(Couleur.NOIR));
            
            this.echiquier.setPiece(new Position(Echiquier.NB_LIG_COL - 1, 0), new Tour(Couleur.BLANC));
            this.echiquier.setPiece(new Position(Echiquier.NB_LIG_COL - 1, 1), new Cavalier(Couleur.BLANC));
            this.echiquier.setPiece(new Position(Echiquier.NB_LIG_COL - 1, 2), new Fou(Couleur.BLANC));
            this.echiquier.setPiece(new Position(Echiquier.NB_LIG_COL - 1,Echiquier.NB_LIG_COL - 1), new Reine(Couleur.BLANC));
            
        }
        catch (ChessquitoException ex) 
        {
            System.out.println(ex);
            System.exit(1);
        }
    }

    /**
     * produit une version unicode de la partie
     */
    public String toString() 
    {
        return (this.echiquier.toString());
    }
}
