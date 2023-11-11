package cartes;

import java.util.*;
import jeu.*;

public class Botte extends Probleme {

	public Botte(int nombre, Type type) {
		super(nombre, type);
	}

	@Override
	public String toString() {
		switch (this.getType()) {
		case FEU:
			return "Vehicule prioritaire";
		case ESSENCE:
			return "Citerne d essence";
		case CREVAISON:
			return "Increvable";
		default:
			return "As du volant";
		}
	}

	@Override
	public boolean appliquer(Joueur j) {
		if(j.aBotte(this.getType())) {
			return false;
		}
		j.ajouterBotte(this);
		List<Bataille> cartes = j.getPileBataille();
		int i = 0;
		for (Carte c : cartes) {
			if (c.equals(new Attaque(0, getType()))) {
				cartes.remove(i);
			}
			i++;
		}
		return true;
	}
}
