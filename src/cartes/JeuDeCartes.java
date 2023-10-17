package cartes;

import java.util.*;

import cartes.Probleme.Type;
import utils.*;

public class JeuDeCartes {

	private Botte vehiculePrioritaire = new Botte(1, Type.FEU);
	private Botte citerne = new Botte(1, Type.ESSENCE);
	private Botte increvable = new Botte(1, Type.CREVAISON);
	private Botte asDuVolant = new Botte(1, Type.ACCIDENT);
	private Attaque feuRouge = new Attaque(5, Type.FEU);
	private Attaque panneEssence = new Attaque(3, Type.ESSENCE);
	private Attaque crevaison = new Attaque(3, Type.CREVAISON);
	private Attaque accident = new Attaque(3, Type.ACCIDENT);
	private Parade feuVert = new Parade(14, Type.FEU);
	private Parade essence = new Parade(6, Type.ESSENCE);
	private Parade roueSecours = new Parade(6, Type.CREVAISON);
	private Parade reparations = new Parade(6, Type.ACCIDENT);
	private DebutLimite debutLimite = new DebutLimite(4);
	private FinLimite finLimite = new FinLimite(6);
	private Borne km25 = new Borne(10, 25);
	private Borne km50 = new Borne(10, 50);
	private Borne km75 = new Borne(10, 75);
	private Borne km100 = new Borne(12, 100);
	private Borne km200 = new Borne(4, 200);
	private Carte[] typesDeCartes = { vehiculePrioritaire, citerne, increvable, asDuVolant, feuRouge, panneEssence,
			crevaison, accident, feuVert, essence, roueSecours, reparations, debutLimite, finLimite, km25, km50, km75,
			km100, km200 };
	private List<Carte> listeCartes;

	public JeuDeCartes() {
		listeCartes = new ArrayList<>();
		for (Carte carte : typesDeCartes) {
			for (int i = 0; i < carte.getNombre(); i++) {
				listeCartes.add(carte);
			}
		}
		listeCartes = Utils.melanger(listeCartes);
	}

	public List<Carte> getListe() {
		return listeCartes;
	}

	public Carte getListeI(int i) {
		return listeCartes.get(i);
	}

	public int sizeListe() {
		return listeCartes.size();
	}

	public boolean checkCount() {
		boolean res = true;
		for (Carte carte : typesDeCartes) {
			res = carte.getNombre() == Collections.frequency(listeCartes, carte);
			if (!res) {
				return res;
			}
		}
		return res;
	}


}
