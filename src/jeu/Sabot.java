package jeu;

import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.*;

public class Sabot implements Iterable<Carte> {
	private Carte[] tabCartes;
	private int nbCartes;
	private Iterator<Carte> iter = iterator();

	public Sabot(int nbCartesMax) {
		this.tabCartes = new Carte[nbCartesMax];
		this.nbCartes = 0;
	}

	public Iterator<Carte> iterator() {
		return new Iterateur();
	}

	private class Iterateur implements Iterator<Carte> {
		private int indiceIterateur = 0;
		private boolean nextEffectue = false;

		@Override
		public boolean hasNext() {
			return indiceIterateur < nbCartes;
		}

		@Override
		public Carte next() {
			if (hasNext()) {
				Carte res = tabCartes[indiceIterateur];
				indiceIterateur++;
				nextEffectue = true;
				return res;
			} else {
				throw new NoSuchElementException("Il n y a plus de carte apres");
			}
		}

		@Override
		public void remove() {
			if (nbCartes < 1 || !nextEffectue) {
				throw new IllegalStateException("Il n y a pas de carte a supprimer");
			} else {
				for (int i = indiceIterateur - 1; i < nbCartes; i++) {
					tabCartes[i] = tabCartes[i + 1];
				}
				nextEffectue = false;
				indiceIterateur--;
				nbCartes--;
			}
		}
	}

	public boolean estVide() {
		return nbCartes == 0;
	}

	private void ajouterCarte(Carte carte) {
		if (nbCartes < tabCartes.length) {
			tabCartes[nbCartes] = carte;
			nbCartes++;
		} else {
			throw new ArrayIndexOutOfBoundsException("Le sabot est plein");
		}
	}

	public void ajouterFamilleCarte(Carte... carte) {
		for (Carte carte2 : carte) {
			for (int i = 0; i < carte2.getNombre(); i++) {
				ajouterCarte(carte2);
			}
		}
	}

	public Carte piocher() {
		Carte res = iter.next();
		iter.remove();
		return res;
	}

	public void afftab() {
		System.out.println("[");
		for (int i = 0; i < nbCartes; i++) {
			System.out.println(tabCartes[i].toString() + ",");
		}
		System.out.println("]\n");
	}
}
