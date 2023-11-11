package cartes;

import java.util.List;

import jeu.Joueur;

public class Parade extends Bataille {

	public Parade(int nombre, Type type) {
		super(nombre, type);
	}

	@Override
	public String toString() {
		switch (this.getType()) {
		case FEU:
			return "Feu vert";
		case ESSENCE:
			return "Essence";
		case CREVAISON:
			return "Roue de secours";
		default:
			return "Reparations";
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
			if (c.getClass() != this.getClass() && getType()==c.getType()) {
				res = true;
				j.ajouterBataille(this);
			} else {
				res = false;
			}
		}
		return res;
	}

}
