import chessquito.*;
import java.util.*;

public class Application
{
	static public void main(String [] params)
	{
		Scanner sc = new Scanner(System.in);

			Partie maSuperPartie = new Partie();
			int x, y, z, w;

			while ( !maSuperPartie.estFinie() )
			{
				System.out.println("c'est au joueur " + maSuperPartie.getCouleurEnCours() +" de jouer\n");
				System.out.println(maSuperPartie);
				System.out.println("Quelle piece voulez déplacer ?\nIndiquez x y");
						x = sc.nextInt();
						y = sc.nextInt();
		
				//System.out.println("Vous avez choisit le/ la "+ maSuperPartie.echiquier.getPiece(new Position(x,y)).getNom()+ " en ("+x+","+y+")");
				System.out.println("Ou voulez vous le/la deplacer ?\nIndiquez x y");
				z = sc.nextInt();
				w = sc.nextInt();
				try
				{
					maSuperPartie.jouer(new Position(x,y), new Position(z,w));
				}
				catch(Exception e)
				{
				    System.out.println(e);
				}


			}
		
		
		
		

		
	}
	
	


}



