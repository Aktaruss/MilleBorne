package jeu;

import java.util.*;
import cartes.*;

public class Coup {
	Carte carte;
	Joueur joueurCible;

	public Coup(Carte carte, Joueur joueurCible) {
		super();
		this.carte = carte;
		this.joueurCible = joueurCible;
	}

	public Carte getCarte() {
		return carte;
	}

	public Joueur getJoueurCible() {
		return joueurCible;
	}

	public static boolean estValide(Joueur j) {
		return !(j == null);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Coup) {
			Coup coup = (Coup) obj;
			return carte.equals(coup.getCarte()) && joueurCible.equals(coup.getJoueurCible());
		}
		return false;
	}

	@Override
	public int hashCode() {
		return 31 * (carte.hashCode() + joueurCible.hashCode());
	}

	public static Set<Coup> coupsPossibles(List<Joueur> participants) {
		Set<Coup> setCoup = new HashSet<Coup>();
		boolean possible = false;
		for (Joueur joueur1 : participants) {
			for (Carte carte : joueur1.getMain()) {
				Coup coup = new Coup(carte, joueur1);
				for (Joueur joueur2 : participants) {
					if (!joueur1.equals(joueur2) && estValide(joueur2)) {
						possible = true;
					}
				}
				if (possible) {
					setCoup.add(coup);
				}
				possible = false;
			}
		}
		return setCoup;
	}

	public boolean jouer(Joueur j) {
		boolean res;
		if (joueurCible == null) {
			j.getJeu().getSabot().add(carte);
			System.out.println("le joueur mets la carte dans le sabot");
			res = true;
		} else {
			res = carte.appliquer(j);
			if (res) {
				j.jouer(carte);
				System.out.println("le joueur a jouer le coup");
			} else {
				System.out.println("le joueur repose la carte");
			}
		}
		return res;
	}

}
