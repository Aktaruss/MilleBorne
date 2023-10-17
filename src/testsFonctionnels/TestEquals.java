package testsFonctionnels;

import cartes.*;
import cartes.Probleme.Type;

public class TestEquals {
	public static void main(String[] args) {
		Attaque accident = new Attaque(3, Type.ACCIDENT);
		Parade reparation = new Parade(3, Type.ACCIDENT);
		Attaque accident2 = new Attaque(1, Type.ACCIDENT);
		DebutLimite debutlimite = new DebutLimite(1);
		FinLimite finlimite = new FinLimite(1);
		Borne km75 = new Borne(1, 75);
		Borne km752 = new Borne(2, 75);
		Borne km25 = new Borne(2, 25);

		System.out.println("Accident et accident :" + accident.equals(accident2) + "\n");
		System.out.println("Accident et reparation :" + accident.equals(reparation) + "\n");
		System.out.println("Debut limite et fin limite :" + debutlimite.equals(finlimite) + "\n");
		System.out.println("Borne et Borne meme kilometre :" + km75.equals(km752) + "\n");
		System.out.println("Borne et Borne kilometre different :" + km75.equals(km25) + "\n");
	}
}
