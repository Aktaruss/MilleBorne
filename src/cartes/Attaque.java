package cartes;

import java.util.List;

import jeu.Joueur;

public class Attaque extends Bataille {

	public Attaque(int nombre, Type type) {
		super(nombre, type);
	}

	@Override
	public String toString() {
		switch (this.getType()) {
		case FEU:
			return "Feu rouge";
		case ESSENCE:
			return "Panne d essence";
		case CREVAISON:
			return "Crevaison";
		default:
			return "Accident";
		}
	}

	@Override
	public boolean appliquer(Joueur j) {
		boolean res;
		if (super.appliquer(j)) {
			res = true;
		} else {
			List<Bataille> pileBat = j.getPileBataille();
			Bataille c = pileBat.get(0);
			if (c.getClass() != this.getClass()) {
				res = true;
				j.ajouterBataille(this);
			} else {
				res = false;
			}
		}
		return res;
	}
}
