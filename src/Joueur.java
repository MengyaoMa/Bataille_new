
public class Joueur {
	
	Carte [] carte = new Carte[26];
	int compteur;
	int indice = 0;
	
	
	public Joueur(Carte[] carte,int compteur){
		this.carte = carte;
		this.compteur=compteur;
		
	}
	
	public Carte tirCarte(int valeur, String couleur){
		Carte c = new Carte(valeur, couleur);
		return c;
	}
	
	public void ajoutCarte(Carte c){
		carte[indice] = c;
	}
	

}
