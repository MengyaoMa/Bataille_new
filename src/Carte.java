public class Carte {
	
	private int valeurCarte;
	private String couleurCarte;
	
	public Carte(int valeur, String couleur){
		this.valeurCarte = valeur;
		this.couleurCarte = couleur;
	}
		
	public int comparateur(int valeur1, int valeur2){
		if (valeur1 > valeur2 ){
			return 1;
		}else if (valeur1 == valeur2){
				return 0;
		}
		return -1;	
	}

	public int getValeurCarte() {
		return valeurCarte;
	}

	public void setValeurCarte(int valeurCarte) {
		this.valeurCarte = valeurCarte;
	}

	public String getCouleurCarte() {
		return couleurCarte;
	}

	public void setCouleurCarte(String couleurCarte) {
		this.couleurCarte = couleurCarte;
	}
}	


