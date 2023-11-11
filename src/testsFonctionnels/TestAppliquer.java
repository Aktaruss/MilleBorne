package testsFonctionnels;

import cartes.*;
import cartes.Probleme.Type;
import jeu.*;

public class TestAppliquer {
	
	
	public static void main(String[] args) {
		Joueur j = new Joueur("J");
		Carte c1 = new Parade(0, Probleme.Type.FEU);
		System.out.println("appliquer " + c1 + ":" + c1.appliquer(j));
		System.out.println("appliquer " + c1 + ":" + c1.appliquer(j));
		Carte c2 = new Attaque(0, Probleme.Type.FEU);
		System.out.println("appliquer " + c2 + ":" + c2.appliquer(j));
		Carte c3 = new Borne(0, 100);
		System.out.println("appliquer " + c3 + ":" + c3.appliquer(j));
		Carte c4 = new Botte(0, Type.FEU);
		System.out.println("appliquer " + c4 + ":" + c4.appliquer(j));
		System.out.println("appliquer " + c3 + ":" + c3.appliquer(j));
		System.out.println("appliquer " + c3 + ":" + c3.appliquer(j));
		Carte c5 = new DebutLimite(0);
		System.out.println("appliquer " + c5 + ":" + c5.appliquer(j));
		Carte c6 = new Attaque(0, Type.ESSENCE);
		System.out.println("appliquer " + c6 + ":" + c6.appliquer(j));
		System.out.println("appliquer " + c3 + ":" + c3.appliquer(j));
		Carte c7 = new Parade(0, Type.ACCIDENT);
		System.out.println("appliquer " + c7 + ":" + c7.appliquer(j));
		Carte c8 = new Parade(0, Type.ESSENCE);
		System.out.println("appliquer " + c8 + ":" + c8.appliquer(j));
	}
}
