package fi.helsinki.cs.sand.TicTacToe;

/**
 * Luokka hoitaa pelikent�n alustuksen, uuden pelin alussa, tai peli� ladatessa.
 * @author Timo Sand
 *
 */
public class Pelikentta {
	
	int[][] kentta;
	Filehandle kasittelija;
	int vuoro;
	String[] pelaajaNimet = new String[2];
	private static final int RISTI = 1;
	private static final int NOLLA = 2;
	
	/**
	 * Konstruktori, joka luo uuden pelikent�n, annetulle koolle.
	 * My�s alustaa kent�n nolliksi.
	 * @param gsize Int muuttuja joka sis�lt�� pelikent�n koon.
	 */
	public Pelikentta (int gsize) {
		if (gsize == 3 || gsize == 4 || gsize == 5) {
			this.kentta = new int[gsize][gsize];
		}
		else  {
			System.out.println("Kent�n koko on v��r�!");
			return;
		}
		
		for (int i = 0; i < this.kentta.length; i++) {
			for (int j = 0; j < this.kentta[i].length; j++) {
				this.kentta[i][j] = 0;
			}
		}	
	}

	/**
	 * Kuormitettu konstruktori, saa parametrin� tiedoston polun. Ja lataa t�m�n tiedoston uuteen kentt��n.
	 * @param file String muuttuja, joka sis�lt�� tallennetun tilanteen.
	 */
	public Pelikentta(String file) {
		this.alustaLukija(file);
		this.kentta = this.lataaKentta(file);
	}
	
	/**
	 * Funktio alustaa lukija olion.
	 * @param file String tiedosto, joka sis�lt�� tiedostopolun.
	 */
	private void alustaLukija (String file) {
		this.kasittelija = new Filehandle(file);
		this.kasittelija.alusta("lue");
	}
	
	/**
	 * Metodi lukee tiedostosta tallennetun pelikent�n, pelaajien nimet ja pelaajan vuoron.
	 * @return Int[][] taulukko, joka sis�lt�� tallennetun pelin.
	 */
	public int[][] lataaKentta(String file) {
		if (this.kasittelija == null) {
			this.alustaLukija(file);
		}
		this.kasittelija.alusta("lue");
		int[][] temp = this.kasittelija.lueMatriisi();
		this.vuoro = this.kasittelija.lueInt();
		this.pelaajaNimet = this.kasittelija.lueNimet();
		return temp;
	}
	
	/**
	 * Funktio tallentaa pelikent�, pelivuoron ja pelaajien nimet tiedostoon.
	 * @param vuoro Int, joka sis�lt�� tiedon, siit� kenen vuoro on.
	 */
	public void tallennaKentta(int vuoro, String file) {
		if (this.kasittelija == null) {
			this.kasittelija = new Filehandle(file);
		}
		this.kasittelija.alusta("kirj");
		this.kasittelija.kirjoitaTallennus(vuoro, this.kentta, this.pelaajaNimet);
	}


	/*public static void main(String[] args) {
		String nimi = "testi.txt";
		Pelikentta uus = new Pelikentta(5);
		Pelikentta test = new Pelikentta(nimi);
		
		for (int i = 0; i < uus.kentta.length; i++) {
			for (int j = 0; j < uus.kentta[i].length; j++) {
				System.out.print(uus.kentta[i][j]+" ");
			}
			System.out.println();
		}
		
		for (int i = 0; i < test.kentta.length; i++) {
			for (int j = 0; j < test.kentta[i].length; j++) {
				System.out.print(test.kentta[i][j]+" ");
			}
			System.out.println();
		}
	}*/
}

