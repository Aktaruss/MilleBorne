package cartes;

import cartes.Probleme.Type;
import jeu.Joueur;

public class DebutLimite extends Limite {

	public DebutLimite(int nombre) {
		super(nombre);
	}

	@Override
	public String toString() {
		return "Limite de vitesse";
	}

	public boolean equals(Object obj) {
		return obj instanceof DebutLimite;
	}

	@Override
	public boolean appliquer(Joueur j) {
		if(j.getLimite()==200 && !j.aBotte(Type.FEU)) {
			j.ajouterLimite(this);
			return true;
		}
		return false;
	}
}
