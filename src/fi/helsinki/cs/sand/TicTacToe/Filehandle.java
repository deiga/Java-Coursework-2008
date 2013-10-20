package fi.helsinki.cs.sand.TicTacToe;

import java.util.*;
import java.io.*;

/**
 * Luokka k�sittelem��n ohjelman tiedostokutsut. 
 * Lukee ja kirjoittaa tiedostoja.
 * @author Timo Sand
 * @version %I%, %G%
 */
public class Filehandle {
	
	private PrintWriter kirjoittaja;
	private File tiedosto = null;
	private Scanner lukija;
	private static final int RISTI = 1;
	private static final int NOLLA = 2;

	/**
	 * Luokan constructori
	 * @param file the File variable has the pathname for the file read or written.
	 */
	public Filehandle(String file) {
		if (file != null) {
			this.tiedosto = new File(file);
		}
		else {
			System.out.println("File path not specified! \nHalted operation.");	
		}
	}
	
	/**
	 * Aksessori lukijan tai kirjoittajan alustukseen.
	 * Vertailee parametrin Stringiin, jonka perusteella toteaa kumpi pit�� alustaa.
	 * @param choice
	 */
	public void alusta(String choice) {
		if (choice == "lue")
			alustaLukija();
		else alustaKirjoittaja();
	}
	
	/**
	 * Metodi alustaa lukijan, "tiedoston" osoittamaan tiedostoon.
	 * @exception FileNotFoundException Jos tiedostoa ei l�ydy tai sit� ei voi avata.
	 */
	private void alustaLukija () {
		try {
			this.lukija = new Scanner(this.tiedosto);
		} catch (FileNotFoundException e) {
			System.out.println("Tiedostoa ei l�ytynyt!");
		}
	}
	/**
	 * Metodi alustaa kirjoittajan, "tiedoston" osoittamaan polkuun. Korvaa aina vanhan tiedoston.
	 * @exception FileNotFoundException Jos tiedostoa ei voi luoda, tai sen p��lle ei voi kirjoittaa.
	 * @exception UnsupportedEncodingException Jos k�ytt�j�rjestelm� ei tue m��ritelty� kirjasintyyppi�.
	 */
	private void alustaKirjoittaja() {
		try {
			this.kirjoittaja = new PrintWriter(this.tiedosto, "ISO-8859-1");
		} catch (FileNotFoundException e) {
			System.out.println("Tiedostoa ei l�ytynyt!");
		} catch (UnsupportedEncodingException e) {
			System.out.println("Charset ei kelpaa.");
		}
	}
	
	/**
	 * Sulkee lukijan ja kirjoittajan.
	 */
	public void sulje() {
		this.kirjoittaja.close();
		this.lukija.close();
	}
	/**
	 * Kirjoittaa tiedostoon String-olion sis�ll�n.
	 * @param word String, joka kirjoitetaan tiedostoon.
	 */
	private void kirjoita(String word) {
		if (word == null) {
			return;
		} else {
			this.kirjoittaja.println(word);
			this.kirjoittaja.flush();
		}
	}
	
	/**
	 * Kirjoittaa yhden int-numeron tiedostoon.
	 * @param numero Numero joka kirjoitetaan tiedostoon.
	 */
	private void kirjoita(int numero) {
		this.kirjoittaja.println(numero);
		this.kirjoittaja.flush();
	}
	/**
	 * Kirjoittaa tiedostoon matriisitaulukon sis�ll�n, t�ss� tarkoituksessa peli kent�n sis�ll�n.
	 * @param taulu
	 */
	private void kirjoita(int[][] taulu) {		
		for (int i = 0; i < taulu.length; i++) {
			for (int j = 0; j < taulu[i].length; j++) {
				this.kirjoittaja.print(taulu[i][j]+" ");
			}
		}
		this.kirjoittaja.flush();
	}
	
	/**
	 * Funktio tallentaa meneill� olevan pelin tekstitiedostoon.
	 * @param vuoro Int, joka sis�lt�� tiedon, kumman pelaajan vuoro oli tallentaessa.
	 * @param matriisi int[][], joka sis�lt�� pelikent�n tiedot.
	 * @param nimet String[], kertoo pelaajien nimet.
	 */
	public void kirjoitaTallennus(int vuoro, int[][]matriisi, String[] nimet) {
		int temp = matriisi.length;
		this.kirjoita(temp);
		this.kirjoita(matriisi);
		this.kirjoita(vuoro);
		for (String nimi : nimet) {
			this.kirjoita(nimi);
		}
	}
	
	/**
	 * Metodi kirjoittaa pistetilanteen tiedostoon.
	 * @param taulu String[], joka sis�lt�� pistelistat.
	 */
	public void kirjoitaPisteet (String[] taulu) {
		String[] temp = taulu;
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] == null) {
				return;
			} else {
				this.kirjoita(temp[i]);
			}
		}
	}
	
	/**
	 * Metodi joka lukee pistetiedostosta nimet ja pisteet.
	 * @return String[] joka sis�lt�� pisteet.
	 */
	public String[] luePisteet() {
		String[] taulu = new String[10];
		String temp = null;
		for (int i = 0; i < taulu.length; i++) {
			temp = lueString();
			if (temp == "-1") {
					return taulu;
			} else taulu[i] = temp;
		}
		return taulu;
	}
	
	/**
	 * Metodi lukee tiedostosta matriisitaulukkoon arvot.
	 * @return int[][], joka sis�lt�� pelikent�n tiedot.
	 */
	public int[][] lueMatriisi() {		
		int size = 0;
		int[][] matrix;
		
		size = lueInt();
		matrix = new int[size][size];
		this.lukija.nextLine();
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) { 
					matrix[i][j] = lueInt();
			}
		}
		return matrix;
	}
	
	/**
	 * Lukuoperaatio, joka lukee seuraavan int-tyyppisen luvun tiedostosta.
	 * @return int, joka on tiedostosta, tai -1 jos ei ole en�� intti�.
	 */
	public int lueInt() {
		if (this.lukija.hasNextInt()) {
			int luku = this.lukija.nextInt();
			return luku;
		} else System.out.println("Ei en�� lukuja!");
		return -1;
	}
	
	/**
	 * Metodi lukee seuraavan String-olion tiedostosta.
	 * @return String olion, tiedoston sis�ll�st�.
	 */
	private String lueString () {
		if (this.lukija.hasNextLine()) {
			String sana = this.lukija.nextLine();
			return sana;
		} else return "-1";
	}
	
	/**
	 * Funktio lukee kaksi alkioiseen taulukkoon pelaajien nimet, tiedostosta.
	 * @return Palauttaa taulukon, jossa nimet, taikka null arvon.
	 */
	public String[] lueNimet () {
		String[] sana = new String[2];
		
		if (this.lukija.hasNext()) {
			for (int i = 0; i < sana.length; i++) {
				sana[i] = this.lukija.next();	
			}
			return sana;
		} else return null; 	
	}
	
/**	
	public static void main(String args[]) {
		
		String nimi = "testi.txt";
		int[][] testitaulu = new int[4][4];
		int[][] taulu;
		String lol;
		
		for (int i = 0; i < testitaulu.length; i++) {
			for (int j = 0; j < testitaulu[i].length; j++) {
				testitaulu[i][j] = (int)(10.0 * Math.random()) + 1;
			}
		}
		
		Filehandle testi = new Filehandle(nimi);
		testi.alustaLukija();
		testi.alustaKirjoittaja();
		testi.kirjoita(4);
		testi.kirjoita(testitaulu);
		testi.kirjoita("B��!!");
		testi.suljeKirjoittaja();
		taulu = testi.lue();
		lol = testi.lueString();
		
		for (int i = 0; i < taulu.length; i++) {
			for (int j = 0; j < taulu[i].length; j++) {
				System.out.print(taulu[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println(lol);
	}
	*/
}
