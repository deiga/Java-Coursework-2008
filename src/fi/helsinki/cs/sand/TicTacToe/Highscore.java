package fi.helsinki.cs.sand.TicTacToe;

/**
 *  Luokka hallinnoi pelin pistelistaa, se näyttää kutsuttaessa pistelistan ja pelin pätyttyä päivittää listan.
 * @author Timo Sand
 * 
 */
public class Highscore {
	
	private String polku = "Score.txt"; /*Tiedostopolku, jossa pistetilanteet säilytetään.*/
	private Filehandle kasittelija; /*Filehandle olio, jolla luetaan tiedostoja ja tallennetaan tiedostoihin.*/
	private String[] pistetaulu; /*Taulu, jota käytetään, tiedostosta tulevan pistetilanteen tallentamiseen.*/
	private String[] valitaulu; /*Tauluun pilkotaan, pistetaulun varsinaiset String-oliot.*/
	private String[] lisataulu;/*Taulukkoon pilkotaan pistetilanteen muutossa käytetyn string-olion, varsinaiset String-jonot*/
	private int[] lisapelattu; /*Taulukkoon pilkotaan pistetilanteen muuttamisessa käytetyn String-olion int arvot.*/
	private int[] lisahavitty; /*Taulukkoon pilkotaan pistetilanteen muuttamisessa käytetyn String-olion int arvot.*/
	private int[] lisavoitettu; /*Taulukkoon pilkotaan pistetilanteen muuttamisessa käytetyn String-olion int arvot.*/
	private int[] pelattu; /*Taulukkoon pilkotaan pistetaulun olioitten  int-arvot.*/
	private int[] havitty; /*Taulukkoon pilkotaan pistetaulun olioitten  int-arvot.*/
	private int[] voitettu; /*Taulukkoon pilkotaan pistetaulun olioitten  int-arvot.*/
	private static final int RISTI = 1;
	private static final int NOLLA = 2;
	
	/**
	 * Luokan konstruktori, ei parametrejä.
	 * alustaa kasittelija:n ja kaikki taulukot, lukee tiedoston sisällön ja jakaa sen taulukkoihin,
	 * helppoa käsittelyä varten.
	 */
	public Highscore() {
		this.valitaulu = new String[10];
		this.pelattu = new int[10];
		this.havitty = new int[10];
		this.voitettu = new int[10];
		this.kasittelija = new Filehandle(polku);
		
		this.luePisteet();	
	}
	
	/**
	 * Funktio, joka alustaa lukijan, lukee tiedoston sisällön 
	 * ja jakaa sen taulukoihin
	 * helppoa käsittelyä varten.
	 */
	public void luePisteet() {
		this.kasittelija.alusta("lue");
		this.pistetaulu = this.kasittelija.luePisteet();
		yksiloi(this.pistetaulu);
	}
	
	/**
	 * Tulostaa pistetaulukon käyttäjän nähtäväksi.
	 */
	public void naytaPisteet () {
		System.out.println("       Nimi \t Voitettu\t  Hävitty \t Pelattu") ;
		System.out.println("-------------------------------------------");
		for (int i = 0; i < this.valitaulu.length; i++) {
			if (valitaulu[i] == null)
				return;
			System.out.println(i+1+". \t"+this.valitaulu[i]+"\t     "+this.voitettu[i]+"\t\t    "+this.havitty[i]+"\t \t   "+this.pelattu[i]);
		}
	}
	
	/**
	 * Metodi muuntaa tiedoston sisällön,
	 * erillisiksi stringeiksi ja inteiksi.
	 * @param String[]-taulu, josta pilkotaan arvoja.
	 */
	private void yksiloi(String[] taulu) {
		int temp = 0;
		for (int i = 0; i < taulu.length; i++) {
			if (taulu[i] == null)
				return;
			for (String pala : taulu[i].split(" ")) {
				try {
					temp = Integer.parseInt(pala);
					if (this.voitettu[i] == 0)
						this.voitettu[i] = temp;
					else if (this.havitty[i] == 0)
						this.havitty[i] = temp;
					else this.pelattu[i] = temp;
				} catch (NumberFormatException e) {
					this.valitaulu[i] = pala;
				}
			}
		}
	}
	
	/**
	 * Metodi on pistemuutoksia varten kuormitettu.
	 * @param taulu String[]-taulu, josta pilkotaan arvoja.
	 * @param maarittely String olio, joka auttaa vain kuormittamisessa.
	 */
	private void yksiloi(String[] taulu, String maarittely) {
		int temp = 0;
		int kohde;
		for (int i = 0; i < taulu.length; i++) {
			kohde = 0;
			if (taulu[i] == null)
				return;
			for (String pala : taulu[i].split(" ")) {
				try {
					temp = Integer.parseInt(pala);
					kohde += 1;
					if (kohde == 1) {
						this.lisavoitettu[i] = temp;
					}
					else if (kohde == 2) {
						this.lisahavitty[i] = temp;
					}
					else if (kohde == 3) {
						this.lisapelattu[i] = temp;
					}
				} catch (NumberFormatException e) {
					this.lisataulu[i] = pala;
				}
			}
		}
	}
	
	/**
	 * Metodi alustaa, pisteiden lisäykseen tarvittavat taulukot,
	 *  sekä kirjoittavan olion ja pilkkoo syötteenä saaneen taulu,
	 *   näihin alustetuihin tauluihin.
	 * @param taulu String[] olio, tulee sisältää lisättävien pisteiden tiedot.
	 */
	private void alustaPisteet(String[] taulu) {
		int temp = taulu.length;
		this.lisataulu = new String[temp];
		this.lisapelattu = new int[temp];
		this.lisahavitty = new int[temp];
		this.lisavoitettu = new int[temp];
		
		kasittelija.alusta("Kirj");
		yksiloi(taulu,"lisäys");
		//for (int i = 0; i < taulu.length; i++) {
	//		System.out.println(this.lisataulu[i]+" "+this.lisavoitettu[i]+" "+this.lisahavitty[i]+" "+this.lisapelattu);
	//	}
	}
	
	/**
	 * Funktio, joka lisää uudesta pelistä koituneet muutokset pistetaulukkoon.
	 * @param taulu String[] olio, joka sisältää pistetilanteen muutokset.
	 */
	public void lisaaPisteet(String[] taulu) {
		alustaPisteet(taulu);
		
		// Jos pistetietoja ei ole, niin kopioidaan uudet pisteet suoraan vanhaan taulukkoon.
		if (this.valitaulu[0] == null) {
			for (int i = 0; i < this.lisataulu.length; i++) {
				this.valitaulu[i] = this.lisataulu[i];
				this.pelattu[i] = this.lisapelattu[i];
				this.havitty[i] = this.lisahavitty[i];
				this.voitettu[i] = this.lisavoitettu[i];
			}
			
			/* 
			 * Yhdistetään pilkotutty Stringi ja kirjoitetaan koko homma tiedostoon,
			 * lopussa suljetaan kirjoittaja
			 */
			this.pistetaulu = yhdista();
			this.kasittelija.kirjoitaPisteet(pistetaulu);
			this.kasittelija.sulje();
			return;
		}
		else {
			for (int i = 0; i < this.valitaulu.length; i++) {
				for (int j = 0; j < this.lisataulu.length; j++) {
					if (this.valitaulu[i] != null && this.lisataulu[j] != null) { /* Tarkistetaan, ettei kumpikaan taulukon alkio ole 'null', ja sitten vertaillaan.*/
						if (this.valitaulu[i].equals(this.lisataulu[j])) { /* Kun löytyy samat alkiot, niin lisätään pistetiedot tähän kenttään, ja asetetaan lisättävän, nimi 'null'-arvoksi*/
							this.pelattu[i] += this.lisapelattu[j];
							this.havitty[i] += this.lisahavitty[j];
							this.voitettu[i] += this.lisavoitettu[j];
							this.lisataulu[j] = null;
							break;
						}
					}
					else if (this.valitaulu[i] == null && this.lisataulu[j] != null) { /*Jos alkuperäisessä taulukossa on 'null'-arvo, ja lisättävässä ei ole, niin lisätään arvo siihen 'null' -arvon kohdalle.*/
						this.valitaulu[i] = this.lisataulu[j];
						this.pelattu[i] = this.lisapelattu[j];
						this.havitty[i] = this.lisahavitty[j];
						this.voitettu[i] = this.lisavoitettu[j];
						this.lisataulu[j] = null;
						break;
					}					
				}
			}
			this.pistetaulu = yhdista();
			this.kasittelija.kirjoitaPisteet(pistetaulu);
			this.kasittelija.sulje();
		}
	}
	
	/**
	 * Funktio yhdistää pistetilanteen rivit, 
	 * jotta pistetilanteen voi tallettaa tiedostoon.
	 */
	private String[] yhdista() {
		String[] temp = new String[10];
		if (this.valitaulu[0] != null) {
			for (int i = 0; i < this.valitaulu.length; i++) {
				if (valitaulu[i] == null) {
					break;
				}
				else { temp[i] = this.valitaulu[i]+" "+Integer.toString(this.voitettu[i])+" "+Integer.toString(this.havitty[i])+" "+Integer.toString(this.pelattu[i]); }
			} 
		}
		return temp;
	}
	/*
	public static void main(String[] args) {
		
		String[] lol = new String[3];		
		Highscore pisteet = new Highscore();
		
		lol[0] = "Lotta 4 5 9";
		lol[1] = "Lauri 2 3 7";
		lol[2] = "Timo 4 2 8";
		pisteet.naytaPisteet();
		pisteet.lisaaPisteet(lol);
		pisteet.naytaPisteet();
		
	}*/

}
