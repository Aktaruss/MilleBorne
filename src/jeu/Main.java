package jeu;

import java.util.List;
import java.util.*;

public interface Main {
	
	public 	<C> void prendre(C cartes);
	
	public <C> void jouer(C cartes);
	
	public static <C> ListIterator<C> iterateurCarte(List<C> liste) {
		return liste.listIterator();
	}
}