package jeu;

import java.util.*;
import cartes.*;
import cartes.Probleme.Type;

public class Joueur implements Main {
	private String nom;
	private List<Limite> pileLimite = new ArrayList<>();
	private List<Bataille> pileBataille = new ArrayList<>();
	private List<Borne> collecborne = new ArrayList<>();
	private Set<Botte> setBote = new HashSet<>();
	private List<Carte> main = new ArrayList<>();
	private Jeu jeu;

	public Joueur(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public List<Limite> getPileLimite() {
		return pileLimite;
	}

	public List<Bataille> getPileBataille() {
		return pileBataille;
	}

	public List<Borne> getcollecBorne() {
		return collecborne;
	}

	public Set<Botte> getSetBote() {
		return setBote;
	}

	public List<Carte> getMain() {
		return main;
	}

	public Jeu getJeu() {
		return jeu;
	}

	public void setJeu(Jeu jeu) {
		this.jeu = jeu;
	}

	public int getKM() {
		int kilometreParcourus = 0;
		for (Borne borne : collecborne) {
			kilometreParcourus += borne.getKm();
		}
		return kilometreParcourus;
	}

	public boolean aBotte(Type type) {
		for (Botte botte : setBote) {
			if (botte.getType() == type) {
				return true;
			}
		}
		return false;
	}

	public int getLimite() {
		int limite = 50;
		boolean pileVide = pileLimite.isEmpty();
		boolean botteFeu = aBotte(Type.FEU);
		if (pileVide) {
			limite = 200;
		} else {
			boolean finLimite = pileLimite.get(0).equals(new FinLimite(0));
			if (finLimite || botteFeu) {
				limite = 200;
			}
		}
		return limite;
	}

	public boolean estBloque() {
		boolean pileNotVide = !pileBataille.isEmpty();
		Bataille sommetPile = pileBataille.get(0);
		boolean estPrioritaire = aBotte(Type.FEU);
		if (!pileNotVide && estPrioritaire) {
			return false;
		}
		if (pileNotVide && sommetPile.equals(Carte.FEU_VERT)) {
			return false;
		}
		if (pileNotVide && sommetPile.getClass().equals("Parade") && estPrioritaire) {
			return false;
		}
		if (pileNotVide && sommetPile.equals(Carte.FEU_ROUGE) && estPrioritaire) {
			return false;
		}
		if (pileNotVide && aBotte(sommetPile.getType()) && estPrioritaire) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return nom;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Joueur) {
			Joueur joueur = (Joueur) obj;
			return nom.equals(joueur.toString());
		}
		return false;
	}

	@Override
	public void prendre(Carte carte) {
		main.add(carte);
	}

	@Override
	public void jouer(Carte carte) {
		assert main.contains(carte);
		main.remove(carte);
	}

	public void donner(Carte carte) {
		main.add(carte);
	}

	Carte prendreCarte(List<Carte> sabot) {
		if (sabot.isEmpty()) {
			return null;
		}
		Carte carte = sabot.get(0);
		sabot.remove(0);
		donner(carte);
		return carte;
	}

	public void ajouterBorne(Borne borne) {
		collecborne.add(0, borne);
	}

	public void ajouterLimite(Limite limite) {
		pileLimite.add(0, limite);
	}

	public void ajouterBotte(Botte botte) {
		setBote.add(botte);
	}

	public void ajouterBataille(Bataille bataille) {
		pileBataille.add(0, bataille);
	}

	public Set<Coup> coupsParDefault() {
		List<Joueur> listJoueur = new ArrayList<Joueur>();
		listJoueur.add(this);
		listJoueur.add(null);
		Set<Coup> setCoup = Coup.coupsPossibles(listJoueur);
		return setCoup;
	}

	public Coup selectionner() {
		Coup coup;
		Set<Coup> ensCoup = Coup.coupsPossibles((List<Joueur>) jeu.getEnsJou());
		if (ensCoup.isEmpty()) {
			coup = null;
		} else {
			List<Coup> lisCoup = new ArrayList<>(ensCoup);
			coup = lisCoup.get(0);
			coup.jouer(this);
		}
		return coup;
	}

	public Coup rendreCarte() {
		Coup coup;
		Set<Coup> ensCoup = Coup.coupsPossibles((List<Joueur>) jeu.getEnsJou());
		if (ensCoup.isEmpty()) {
			coup = null;
		} else {
			List<Coup> lisCoup = new ArrayList<>(ensCoup);
			coup = lisCoup.get(0);
			coup.jouer(this);
		}
		return coup;
	}

}
