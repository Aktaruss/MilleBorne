package utils;

import java.util.*;

public class Utils {
	
	public Utils() {
		//contructeur vide
	}

	public static <C> C extraire(List<C> liste) {
		int i = (int) (Math.random() * ((liste.size() - 1) - 0));
		C res = liste.get(i);
		liste.remove(i);
		return res;
	}

	public static <C> List<C> melanger(List<C> liste) {
		List<C> listeres = new ArrayList<>();
		while (!liste.isEmpty()) {
			listeres.add(extraire(liste));
		}
		return listeres;
	}

	public static <C> boolean verifierMelange(List<C> liste1, List<C> liste2) {
		boolean res;
		for (int i = 0; i < liste1.size(); i++) {
			res = Collections.frequency(liste1, liste1.get(i)) == Collections.frequency(liste2, liste1.get(i));
			if (!res) {
				return false;
			}
		}
		return true;
	}

	public static <C> List<C> rassembler(List<C> liste) {
		List<C> res = new ArrayList<>();
		for (int i = 1; i < liste.size(); i++) {
			C cCourant = liste.get(i);
			C cPrecedent = liste.get(i - 1);
			if (!cCourant.equals(cPrecedent)) {
				res.add(cCourant);
			}
		}
		return res;
	}

	public static <C> Boolean verifierRassemblement(List<C> liste) {
		if (liste.isEmpty() || liste == null) {
			return true;
		}
		ListIterator<C> iterator = liste.listIterator();
		C cPrecedent = iterator.next();

		while (iterator.hasNext()) {
			C cCourant = iterator.next();
			if (!cCourant.equals(cPrecedent)) {
				ListIterator<C> reverseIterator = liste.listIterator(liste.size());
				while (reverseIterator.hasPrevious()) {
					C cPrecedentCopie = reverseIterator.previous();
					if (cPrecedentCopie.equals(cPrecedent)) {
						return true;
					}
				}
				return false;
			}
		}
		return true;
	}

}