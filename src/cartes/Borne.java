package cartes;

import jeu.*;

public class Borne extends Carte {
	private int km;

	public Borne(int nombre, int km) {
		super(nombre);
		this.km = km;
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}

	@Override
	public String toString() {
		return km + " Km";
	}

	public boolean equals(Object obj) {
		if (obj instanceof Borne) {
			Borne carte = (Borne) obj;
			return km == carte.getKm();
		}
		return false;
	}

	@Override
	public boolean appliquer(Joueur j) {
		boolean pasBloquer = !(j.estBloque());
		boolean pasDepasserVit = km < j.getLimite();
		boolean pasDepasserBorne = (km + j.getKM()) < 1000;
		if (pasBloquer && pasDepasserBorne && pasDepasserVit) {
			j.ajouterBorne(this);
			return true;
		}
		return false;
	}
}
