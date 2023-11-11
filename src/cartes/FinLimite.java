package cartes;

import jeu.Joueur;

public class FinLimite extends Limite {

	public FinLimite(int nombre) {
		super(nombre);
	}

	@Override
	public String toString() {
		return "Fin limite de vitesse";
	}

	public boolean equals(Object obj) {
		return obj instanceof FinLimite;
	}

	@Override
	public boolean appliquer(Joueur j) {
		if(j.getLimite()==50) {
			j.ajouterLimite(this);
			return true;
		}
		return false;
	}
}
