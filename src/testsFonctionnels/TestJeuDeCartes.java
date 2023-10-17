package testsFonctionnels;

import cartes.*;

public class TestJeuDeCartes {

	public static void main(String[] args) {
		JeuDeCartes jeuDeCartes = new JeuDeCartes();
		for (int i = 0; i < jeuDeCartes.sizeListe(); i++) {
			System.out.println(jeuDeCartes.getListeI(i));
		}
		System.out.println("\n");

		System.out.println("Toutes les cartes sont dedans :" + jeuDeCartes.checkCount());
	}

}
