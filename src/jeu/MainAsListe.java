package jeu;

import java.util.*;
import cartes.*;

public class MainAsListe implements Main {
	private List<Carte> cartes = new ArrayList<>();

	@Override
	public void prendre(Carte carte) {
		cartes.add(carte);
	}

	@Override
	public void jouer(Carte carte) {
		assert cartes.contains(carte);
		cartes.remove(carte);
	}

}
