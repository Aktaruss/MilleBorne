package jeu;

import cartes.*;
import java.util.*;

public class Jeu {
	Set<Joueur> ensJou = new HashSet<>();
	List<Carte> sabot = new ArrayList<>();

	public Set<Joueur> getEnsJou() {
		return ensJou;
	}

	public void setEnsJou(Set<Joueur> ensJou) {
		this.ensJou = ensJou;
	}

	public List<Carte> getSabot() {
		return sabot;
	}

	public void setSabot(List<Carte> sabot) {
		this.sabot = sabot;
	}

	public void inscris(Joueur j) {
		j.setJeu(this);
	}
}
