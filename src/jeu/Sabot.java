package jeu;

import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.*;

public class Sabot implements Iterable<Carte>{
	private Carte[] tabCartes;
	private int nbCartes;

	protected Sabot(int nbCartesMax) {
		this.tabCartes = new Carte[nbCartesMax];
		this.nbCartes = 0;
	}
	
	public Iterator<Carte> iterator() {
		return new Iterateur();
	}
	
	private class Iterateur implements Iterator<Carte> {
		private int indiceIterateur = 0;
		
		
		@Override
		public boolean hasNext() {
			return indiceIterateur<nbCartes;
		}

		@Override
		public Carte next() {
			if (hasNext()) {
				Carte res = tabCartes[indiceIterateur];
				indiceIterateur++;
				return res;
			} else {
				throw new NoSuchElementException("Il n y a plus de carte apres");
			}
		}
		
		public void remove() {
			if (nbCartes<1) {
				throw new IllegalStateException("Il n y a pas de carte a supprimer");
			} else {
				for (int i = indiceIterateur; i < tabCartes.length; i++) {
					tabCartes[i]=tabCartes[i+1];
				}
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
		return tabCartes[0];
	}
	
}
