package cartes;

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
}
