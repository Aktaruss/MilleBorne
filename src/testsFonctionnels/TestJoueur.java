package testsFonctionnels;

import cartes.*;
import cartes.Probleme.Type;
import jeu.*;

public class TestJoueur {
	public static void main(String[] args) {
		Joueur joueur = new Joueur("Joueur 1");

		Borne borne25 = new Borne(1, 25);
		Borne borne50 = new Borne(1, 50);
		Borne borne75 = new Borne(1, 75);

		joueur.ajouterBorne(borne25);
		joueur.ajouterBorne(borne50);
		joueur.ajouterBorne(borne75);

		int totalKM = joueur.getKM();
		boolean res = totalKM == 150;

		System.out.println(joueur.getNom() + " a parcouru " + totalKM + " km :" + res + "\n");

		System.out.println("\n\nTEST LIMITE");
		joueur.getcollecBorne().clear();

		// Test 1 : Limite sans fin de limite ni botte de feu
		Limite limite1 = new DebutLimite(1);
		Botte botteEssence = new Botte(1, Type.ESSENCE);
		joueur.ajouterLimite(limite1);
		joueur.ajouterBotte(botteEssence);
		int limiteVitesse1 = joueur.getLimite();
		System.out.println(
				"Test 1 : Limite sans fin de limite ni botte -> Limite de vitesse : " + limiteVitesse1 + " km/h");

		// Test 2 : Limite avec une fin de limite
		Limite limite2 = new DebutLimite(1);
		FinLimite finLimite = new FinLimite(1);
		joueur.ajouterLimite(limite2);
		joueur.ajouterLimite(finLimite);
		int limiteVitesse2 = joueur.getLimite();
		System.out.println("Test 2 : Limite avec une fin de limite -> Limite de vitesse : " + limiteVitesse2 + " km/h");

		// Test 3 : Botte de type FEU
		Botte botteFeu = new Botte(1, Type.FEU);
		joueur.ajouterBotte(botteFeu);
		joueur.ajouterLimite(limite1);
		int limiteVitesse3 = joueur.getLimite();
		System.out.println("Test 3 : Botte de type FEU -> Limite de vitesse : " + limiteVitesse3 + " km/h");

		System.out.println("\n\nTEST BLOQUER");

		joueur.getPileLimite().clear();
		joueur.getSetBote().clear();

		// Test 1 : Feu Rouge (true)
		joueur.ajouterBataille(new Attaque(1, Type.FEU));
		System.out.println("Test 1 : Est bloqué ? " + joueur.estBloque());

		// Test 2 : Véhicule Prioritaire (false)
		joueur.ajouterBotte(new Botte(1, Type.FEU));
		System.out.println("Test 2 : Est bloqué ? " + joueur.estBloque());

		// Test 3 : Accident (true)
		joueur.ajouterBataille(new Attaque(1, Type.ACCIDENT));
		System.out.println("Test 3 : Est bloqué ? " + joueur.estBloque());

		// Test 4 : As du Volant (false)
		joueur.ajouterBotte(new Botte(1, Type.ACCIDENT));
		System.out.println("Test 4 : Est bloqué ? " + joueur.estBloque());

		// Test 5 : Panne d'Essence (true)
		joueur.ajouterBataille(new Attaque(1, Type.ESSENCE));
		System.out.println("Test 5 : Est bloqué ? " + joueur.estBloque());

		// Test 6 : Essence (false)
		joueur.ajouterBotte(new Botte(1, Type.ESSENCE));
		System.out.println("Test 6 : Est bloqué ? " + joueur.estBloque());

		// Test 7 : Botte Effacer (true)
		joueur.getSetBote().clear();
		System.out.println("Test 7 : Est bloqué ? " + joueur.estBloque());

		// Test 8 : Feu Vert (false)
		joueur.ajouterBataille(new Parade(1, Type.FEU));
		System.out.println("Test 8 : Est bloqué ? " + joueur.estBloque());
	}
}
