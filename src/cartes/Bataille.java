package cartes;

import java.util.*;

import jeu.Joueur;

public abstract class Bataille extends Probleme {

	protected Bataille(int nombre, Type type) {
		super(nombre, type);
	}

	@Override
	public boolean appliquer(Joueur j) {
		List<Bataille> pileBat = j.getPileBataille();
		if (pileBat.isEmpty()) {
			j.ajouterBataille(this);
			return true;
		}
		return false;
	}
}
