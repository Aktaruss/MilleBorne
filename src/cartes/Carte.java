package cartes;

import jeu.*;
import cartes.Probleme.Type;

public abstract class Carte {
	private int nombre;
	public static final Bataille FEU_ROUGE = new Attaque(0, Type.FEU);
	public static final Bataille FEU_VERT = new Parade(0, Type.FEU);
	
	public abstract boolean appliquer(Joueur j);
	
	protected Carte(int nombre) {
		this.nombre = nombre;
	}

	public int getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

}
