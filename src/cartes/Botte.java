package cartes;

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
}
