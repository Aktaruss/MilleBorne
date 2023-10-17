package cartes;

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
}
