package cartes;

public abstract class Probleme extends Carte {
	public enum Type {
		FEU, ESSENCE, CREVAISON, ACCIDENT
	};

	private Type type;

	protected Probleme(int nombre, Type type) {
		super(nombre);
		this.type = type;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Probleme) {
			Probleme carte = (Probleme) obj;
			return this.toString().equals(carte.toString());
		}
		return false;
	}

}
