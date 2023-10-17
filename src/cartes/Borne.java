package cartes;

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
}
