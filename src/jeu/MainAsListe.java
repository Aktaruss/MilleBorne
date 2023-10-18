package jeu;

import java.util.*;
import cartes.*;

public class MainAsListe<C extends Carte> implements Main{
	private List<C> liste = new ArrayList<>();
	
	public MainAsListe() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public <C> void prendre(C cartes) {
		liste.add(cartes);
	}

	@Override
	public <C> void jouer(C cartes) {
		assert liste.contains(cartes);
		liste.remove(cartes);
		
	}

}
