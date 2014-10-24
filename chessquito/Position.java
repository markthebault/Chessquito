package chessquito;

/**
 * classe permettant la creation et la manipulation des positions des pieces du
 * jeu de stratego.
 */
public class Position {
    /**
     * valeur de la premiere composante
     */
    private int x;
    /**
     * valeur de la seconde composante
     */
    private int y;

    /**
     * construit une position
     * 
     * @param l
     *            premiere composante de la position
     * @param c
     *            seconde composante de la position
     */
    public Position(int l, int c) 
    {
        this.x = l;
        this.y = c;
    }

    /**
     * construit une composante nulle
     */
    public Position() 
    {
        this(0, 0);
    }

    /**
     * retourne la valeur de la premiere composante
     * 
     * @return premiere composante de la position
     */
    public int valX() 
    {
        return (this.x);
    }
    
    /**
    * Renvoi une position qui est la somme de la position actuelle plus une position passé en paramètre
    * @param Position a ajouter
    * @return nouvelle position
    */
    public Position ajouter(Position p)
    {
    	return new Position( (this.valX() + p.valX()), (this.valY() + p.valY()) );
    }

    /**
     * retourne la valeur de la deuxieme composante
     * 
     * @return seconde composante de la position
     */
    public int valY() 
    {
        return (this.y);
    }

    /**
     * teste l'egalite de deux positions
     * 
     * @param position
     *            objet a comparer a la position courante
     * @return VRAI si les deux positions sont identiques
     */
    public boolean equals(Object position) 
    {
        boolean resultat;
        if (position instanceof Position) 
        {
            Position c = (Position) position;
            resultat = ((this.x == c.x) && (this.y == c.y));
        } 
        else 
        {
            resultat = false;
        }
        return resultat;
    }

    /**
     * retourne une version unicode d'une position
     * 
     * @return chaine correspondant a la position
     */
    public String toString() 
    {
        return ("(" + this.x + ", " + this.y + ")");
    }
}
