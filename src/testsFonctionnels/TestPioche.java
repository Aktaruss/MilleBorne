package testsFonctionnels;

import cartes.*;
import cartes.Probleme.Type;
import jeu.*;

public class TestPioche {

	public static void main(String[] args) {
		Attaque accident = new Attaque(3, Type.ACCIDENT);
		Parade reparation = new Parade(3, Type.ACCIDENT);
		Botte asDuVolant = new Botte(1, Type.ACCIDENT);
		Sabot sabot = new Sabot(100);

		sabot.ajouterFamilleCarte(accident, reparation, asDuVolant);
		for (int i = 0; i < 10; i++) {
			System.out.println("je pioche " + sabot.piocher().toString() + "\n");
		}

	}
}
