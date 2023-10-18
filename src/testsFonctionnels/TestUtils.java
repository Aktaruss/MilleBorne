package testsFonctionnels;

import utils.*;
import java.util.*;

import cartes.*;

public class TestUtils {

	private static <C> void testMelange(List<C> liste) {
		List<C> listeM = Utils.melanger(liste);
		boolean res = Utils.verifierMelange(liste, listeM);
		System.out.println("Le melange est bien fais : " + res + ".\n");
	}
	
	private static <C> void testRassemblement(List<C> vide,List<C> liste1,List<C> liste2,List<C> liste3) {
		System.out.println("Liste vide : "+vide.toString()+"\n");
		System.out.println("Liste liste1 : "+liste1.toString()+"\n");
		System.out.println("Liste liste2 : "+liste2.toString()+"\n");
		System.out.println("Liste liste3 : "+liste3.toString()+"\n");
		boolean videBool = Utils.verifierRassemblement(vide);
		boolean liste1Bool = Utils.verifierRassemblement(liste1);
		boolean liste2Bool = Utils.verifierRassemblement(liste2);
		boolean liste3Bool = Utils.verifierRassemblement(liste3);
		System.out.println("Liste vide pas rassembler verification : "+videBool+"\n");
		System.out.println("Liste liste1 pas rassembler verification : "+liste1Bool+"\n");
		System.out.println("Liste liste2 pas rassembler verification : "+liste2Bool+"\n");
		System.out.println("Liste liste3 pas rassembler verification : "+liste3Bool+"\n");
		List<C> videRas = Utils.rassembler(vide);
		List<C> liste1Ras = Utils.rassembler(liste1);
		List<C> liste2Ras = Utils.rassembler(liste2);
		List<C> liste3Ras = Utils.rassembler(liste3);
		System.out.println("Liste vide rassembler : "+videRas.toString()+"\n");
		System.out.println("Liste liste1 rassembler : "+liste1Ras.toString()+"\n");
		System.out.println("Liste liste2 rassembler : "+liste2Ras.toString()+"\n");
		System.out.println("Liste liste3 rassembler : "+liste3Ras.toString()+"\n");
		boolean videRasBool = Utils.verifierRassemblement(videRas);
		boolean liste1RasBool = Utils.verifierRassemblement(liste1Ras);
		boolean liste2RasBool = Utils.verifierRassemblement(liste2Ras);
		boolean liste3RasBool = Utils.verifierRassemblement(liste3Ras);
		System.out.println("Liste vide rassembler verification : "+videRasBool+"\n");
		System.out.println("Liste liste1 rassembler verification : "+liste1RasBool+"\n");
		System.out.println("Liste liste2 rassembler verification : "+liste2RasBool+"\n");
		System.out.println("Liste liste3 rassembler verification : "+liste3RasBool+"\n");
	}
	
	
	public static void main(String[] args) {
		List<Integer> vide = new ArrayList<>();
		List<Integer> liste1 = new ArrayList<>();
		List<Integer> liste2 = new ArrayList<>();
		List<Integer> liste3 = new ArrayList<>();
		JeuDeCartes jeuDeCartes = new JeuDeCartes();
		List<Carte> listeJeuDeCartes = jeuDeCartes.getListe();
		liste1.add(1);
		liste1.add(1);
		liste1.add(2);
		liste1.add(1);
		liste1.add(3);
		liste2.add(1);
		liste2.add(4);
		liste2.add(3);
		liste2.add(2);
		liste3.add(1);
		liste3.add(1);
		liste3.add(2);
		liste3.add(2);
		liste3.add(1);
		testMelange(listeJeuDeCartes);
		testRassemblement(vide, liste1, liste2, liste3);
	}
}
