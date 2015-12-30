




public class Bataille {
	private static int valeur[]={1,2,3,4,5,6,7,8,9,10,11,12,13};
	private static String couleur[]={"Picque", "Trefle", "Carreau", "Coeur"};
	
	

	public static void main(String args[]) {
		Carte[] table_carte = new Carte[52];
		int i, j, indice=0;
		/*initialser un paquet de carte*/
		for(i=0; i<13; i++){
			for(j=0; j<4; j++){
				Carte c = new Carte(valeur[i], couleur[j]);
				table_carte[indice] = c;
			}
		}
		Carte[] c1 = new Carte[26];
		Carte[] c2 = new Carte[26];
		int compteur1 = 0;
		int compteur2 = 0;
		Joueur j1 = new Joueur(c1, compteur1);
		Joueur j2 = new Joueur(c2, compteur2);
		int indice1, indice2;
		int leftNumber = 26;//le nommbre de carte reste
		int valeur;
		int flagBataille = 0;
		/*partager le paquet de carte*/
		//for(i=0; i<26; i++)
		i = 0;
		while(leftNumber > 0)
		{
			if(table_carte[i] == null){
				System.out.println("chaque case est null");
				break;
			}
			indice1 = (int) (Math.random()*52);
			
			/*distribuer les carte pour deux joueurs*/
			
			/*joueur 1*/
			while(table_carte[indice1] == null){/*vérifier si la case est dèjà prise par joueur 1*/
				System.out.println("indice1: "+indice1);	
				indice1 = (int) (Math.random()*52);
			}
			j1.carte[i] = table_carte[indice1];
			table_carte[indice1] = null;//mets un flag de pris
			
			/*joueur2, idem que le joueur 1*/
			indice2 = (int) (Math.random()*52);
			while(table_carte[indice2] == null){
				System.out.println("indice2 "+indice2);
				/*vérifier si la case est dèjà prise par joueur 1*/
				indice2 = (int) (Math.random()*52);
				
			}
			j2.carte[i] = table_carte[indice2];
			table_carte[indice2] = null; 
			
			/*comparer*/
			valeur = j1.carte[i].comparateur(j1.carte[i].getValeurCarte(), j2.carte[i].getValeurCarte());
			if(valeur == 1){
				j1.compteur = j1.compteur + 2 +flagBataille;
				leftNumber--;
				flagBataille = 0;//remets le flag à 0 pour la prochaîne fois
			} else if( valeur == -1){
				j2.compteur = j2.compteur + 2 +flagBataille;
				leftNumber--;
				flagBataille = 0;
			} else if(valeur == 0){/*le cas de la bataille*/
				/*distribue une autre carte cachée pour chacun*/
				i++;
				indice1 = (int) Math.random()*26;
				while(table_carte[indice1] == null){
					System.out.println("test3");
					/*vérifier si la case est dèjà prise par joueur 1*/
					indice1 = (int) Math.random()*26;
				}
				j1.carte[i] = table_carte[indice1];
				table_carte[indice1] = null;
				indice2 = (int) Math.random()*26;
				while(table_carte[indice2] == null){
					System.out.println("test4");
					/*vérifier si la case est dèjà prise par joueur 1*/
					indice2 = (int) Math.random()*26;
				}
				j2.carte[i] = table_carte[indice2];
				table_carte[indice2] = null; 
				flagBataille +=2;/*flag pour le cas de bataille*/
				leftNumber -= 2;
			}
			i++;
		}
		
		
		/*affichage du résultat*/
		valeur = j1.carte[i].comparateur(j1.carte[i].getValeurCarte(), j2.carte[i].getValeurCarte());
		if(valeur == 1){
			System.out.println("Joueur 1 a gagné");
		}else if(valeur == 0){
			System.out.println("Joueur 1 et J 2 ");
		}else if(valeur == -1){
			System.out.println("Joueur 2 a gagné");
		}
	}

}
