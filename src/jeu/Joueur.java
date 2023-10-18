package jeu;

import java.util.*;
import java.util.List;
import cartes.*;
import utils.*;

public class Joueur {
	private String nom;
	private List<Limite> pileLimite = new ArrayList<>();
	private List<Bataille> pileBataille = new ArrayList<>();
	private Set<Borne> pileBorne = new HashSet<>();

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

	public Set<Borne> getPileBorne() {
		return pileBorne;
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

	
	
}
