package jeu;

import cartes.*;
import java.util.*;

public interface Main {
	
	public void prendre(Carte carte);
	
	public void jouer(Carte carte);
	
	public static <C> ListIterator<C> iterateurCarte(List<C> liste) {
		return liste.listIterator();
	}
}