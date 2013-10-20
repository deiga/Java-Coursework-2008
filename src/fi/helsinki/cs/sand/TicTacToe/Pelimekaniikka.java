package fi.helsinki.cs.sand.TicTacToe;

/**
 * Luokka käsittää pelinmekaniikan, eli tarkistaa onko voittoa tullut, onko pelikenttä täynnä, 
 * sekä mitä tapahtuu voitolla ja kumpi voitti.
 * @author Timo Sand
 *
 */
public class Pelimekaniikka {
	
	Pelikentta lauta;
	String[] pisteita = new String[2];
	Highscore pisteLisays = new Highscore();
	int pvuoro = 1;
	private static final int RISTI = 1;
	private static final int NOLLA = 2;
	
	/**
	 * Konstruktori, joka alustaa pelikentän annetun koon mukaan.
	 * @param koko Int, joka sisältää pelikentän koon.
	 */
	public Pelimekaniikka(int koko) {
		this.lauta = new Pelikentta(koko);
	}
	
	/**
	 * Konstruktori, joka alustaa pelikentän, lataamalla tiedostosta tallennetun pelin.
	 * @param file String, sisältää tiedostopolun tallennukselle.
	 */
	public Pelimekaniikka(String file) {
		this.lauta = new Pelikentta(file);
	}
	
	/**
	 * Metodi tarkistaa pelilaudan koon, 
	 * jonka jälkeen tarkistaa koko laudan onko voittoa ja, 
	 * että kumpi pelaaja voitti
	 */
	public void peliTilanne() {
		int koko = this.lauta.kentta.length;
		
		if (koko == 3) {
			
			// Vaakarivi tarkistukset Pelaaja 1
			if (this.lauta.kentta[0][0] == 1 && this.lauta.kentta[0][1] == 1 && this.lauta.kentta[0][2] == 1) {
				// Pelaaja 1 Voitti!
				this.voitto(1);
			} else if (this.lauta.kentta[1][0] == 1 && this.lauta.kentta[1][1] == 1 && this.lauta.kentta[1][2] == 1) {
				//Pelaaja 1 Voitti!
				this.voitto(1);
			} else if (this.lauta.kentta[2][0] == 1 && this.lauta.kentta[2][1] == 1 && this.lauta.kentta[2][2] == 1) {
				//Pelaaja 1 Voitti
				this.voitto(1);
			} 
			// Pystyrivi tarkistukset Pelaaja 1
			else if (this.lauta.kentta[0][0] == 1 && this.lauta.kentta[1][0] == 1 && this.lauta.kentta[2][0] == 1) {
				// Pelaaja 1 Voitti!
				this.voitto(1);
			} else if (this.lauta.kentta[0][1] == 1 && this.lauta.kentta[1][1] == 1 && this.lauta.kentta[2][1] == 1) {
				// Pelaaja 1 Voitti!
				this.voitto(1);
			} else if (this.lauta.kentta[0][2] == 1 && this.lauta.kentta[1][2] == 1 && this.lauta.kentta[2][2] == 1) {
				// Pelaaja 1 Voitti!
				this.voitto(1);
			}
			// Vinorivi tarkistus Pelaaja 1
			else if (this.lauta.kentta[0][0] == 1 && this.lauta.kentta[1][1] == 1 && this.lauta.kentta[2][2] == 1) {
				// Pelaaja 1 Voitti!
				this.voitto(1);
			} else if (this.lauta.kentta[0][2] == 1 && this.lauta.kentta[1][1] == 1 && this.lauta.kentta[2][0] == 1) {
				// Pelaaja 1 Voitti!
				this.voitto(1);
			} 
			// Vaakarivi tarkistukset Pelaaja 2
			else if (this.lauta.kentta[0][0] == NOLLA && this.lauta.kentta[0][1] == NOLLA && this.lauta.kentta[0][2] == NOLLA) {
				// Pelaaja 2 Voitti!
				this.voitto(NOLLA);
			} else if (this.lauta.kentta[1][0] == NOLLA && this.lauta.kentta[1][1] == NOLLA && this.lauta.kentta[1][2] == NOLLA) {
				//Pelaaja 2 Voitti!
				this.voitto(NOLLA);
			} else if (this.lauta.kentta[2][0] == NOLLA && this.lauta.kentta[2][1] == NOLLA && this.lauta.kentta[2][2] == NOLLA) {
				//Pelaaja 2 Voitti
				this.voitto(NOLLA);
			}
			// Pystyrivi tarkistukset Pelaaja 2
			else if (this.lauta.kentta[0][0] == NOLLA && this.lauta.kentta[1][0] == NOLLA && this.lauta.kentta[2][0] == NOLLA) {
				// Pelaaja 2 Voitti!
				this.voitto(NOLLA);
			} else if (this.lauta.kentta[0][1] == NOLLA && this.lauta.kentta[1][1] == NOLLA && this.lauta.kentta[2][1] == NOLLA) {
				// Pelaaja 2 Voitti!
				this.voitto(NOLLA);
			} else if (this.lauta.kentta[0][2] == NOLLA && this.lauta.kentta[1][2] == NOLLA && this.lauta.kentta[2][2] == NOLLA) {
				// Pelaaja 2 Voitti!
				this.voitto(NOLLA);
			} 
			// Vinorivi tarkistukset Pelaaja 2
			else if (this.lauta.kentta[0][0] == NOLLA && this.lauta.kentta[1][1] == NOLLA && this.lauta.kentta[2][2] == NOLLA) {
				// Pelaaja 2 Voitti!
				this.voitto(NOLLA);
			} else if (this.lauta.kentta[0][2] == NOLLA && this.lauta.kentta[1][1] == NOLLA && this.lauta.kentta[2][0] == NOLLA) {
				// Pelaaja 2 Voitti!
				this.voitto(NOLLA);
			}
		}
		else if (koko == 4) {
			
			// Vaakarivi tarkistukset Pelaaja 1
			if (this.lauta.kentta[0][0] == 1 && this.lauta.kentta[0][1] == 1 && this.lauta.kentta[0][2] == 1 && this.lauta.kentta[0][3] == 1) {
				// Pelaaja 1 Voitti!
				this.voitto(1);
			} else if (this.lauta.kentta[1][0] == 1 && this.lauta.kentta[1][1] == 1 && this.lauta.kentta[1][2] == 1 && this.lauta.kentta[1][3] == 1) {
				//Pelaaja 1 Voitti!
				this.voitto(1);
			} else if (this.lauta.kentta[2][0] == 1 && this.lauta.kentta[2][1] == 1 && this.lauta.kentta[2][2] == 1 && this.lauta.kentta[2][3] == 1) {
				//Pelaaja 1 Voitti
				this.voitto(1);
			} else if (this.lauta.kentta[3][0] == 1 && this.lauta.kentta[3][1] == 1 && this.lauta.kentta[3][2] == 1 && this.lauta.kentta[3][3] == 1) {
				//Pelaaja 1 Voitti
				this.voitto(1);
			}
			// Pystyrivi tarkistukset Pelaaja 1
			else if (this.lauta.kentta[0][0] == 1 && this.lauta.kentta[1][0] == 1 && this.lauta.kentta[2][0] == 1 && this.lauta.kentta[3][0] == 1) {
				// Pelaaja 1 Voitti!
				this.voitto(1);
			} else if (this.lauta.kentta[0][1] == 1 && this.lauta.kentta[1][1] == 1 && this.lauta.kentta[2][1] == 1 && this.lauta.kentta[3][1] == 1) {
				// Pelaaja 1 Voitti!
				this.voitto(1);
			} else if (this.lauta.kentta[0][2] == 1 && this.lauta.kentta[1][2] == 1 && this.lauta.kentta[2][2] == 1 && this.lauta.kentta[3][2] == 1) {
				// Pelaaja 1 Voitti!
				this.voitto(1);
			} else if (this.lauta.kentta[0][3] == 1 && this.lauta.kentta[1][3] == 1 && this.lauta.kentta[2][3] == 1 && this.lauta.kentta[3][3] == 1) {
				//Pelaaja 1 Voitti
				this.voitto(1);
			}
			// Vinorivi tarkistukset Pelaaja 1
			else if (this.lauta.kentta[0][0] == 1 && this.lauta.kentta[1][1] == 1 && this.lauta.kentta[2][2] == 1 && this.lauta.kentta[3][3] == 1) {
				// Pelaaja 1 Voitti!
				this.voitto(1);
			} else if (this.lauta.kentta[0][3] == 1 && this.lauta.kentta[1][2] == 1 && this.lauta.kentta[2][1] == 1 && this.lauta.kentta[3][0] == 1) {
				// Pelaaja 1 Voitti!
				this.voitto(1);
			}
			// Vaakarivi tarkistukset Pelaaja 2
			else if (this.lauta.kentta[0][0] == NOLLA && this.lauta.kentta[0][1] == NOLLA && this.lauta.kentta[0][2] == NOLLA && this.lauta.kentta[0][3] == NOLLA) {
				// Pelaaja 2 Voitti!
				this.voitto(NOLLA);
			} else if (this.lauta.kentta[1][0] == NOLLA && this.lauta.kentta[1][1] == NOLLA && this.lauta.kentta[1][2] == NOLLA && this.lauta.kentta[1][3] == NOLLA) {
				//Pelaaja 2 Voitti!
				this.voitto(NOLLA);
			} else if (this.lauta.kentta[2][0] == NOLLA && this.lauta.kentta[2][1] == NOLLA && this.lauta.kentta[2][2] == NOLLA && this.lauta.kentta[2][3] == NOLLA) {
				//Pelaaja 2 Voitti
				this.voitto(NOLLA);
			} else if (this.lauta.kentta[3][0] == NOLLA && this.lauta.kentta[3][1] == NOLLA && this.lauta.kentta[3][2] == NOLLA && this.lauta.kentta[3][3] == NOLLA) {
				//Pelaaja 2 Voitti
				this.voitto(NOLLA);
			}
			// Pystyrivi tarkistukset Pelaaja 2
			else if (this.lauta.kentta[0][0] == NOLLA && this.lauta.kentta[1][0] == NOLLA && this.lauta.kentta[2][0] == NOLLA && this.lauta.kentta[3][0] == NOLLA) {
				// Pelaaja 2 Voitti!
				this.voitto(NOLLA);
			} else if (this.lauta.kentta[0][1] == NOLLA && this.lauta.kentta[1][1] == NOLLA && this.lauta.kentta[2][1] == NOLLA && this.lauta.kentta[3][1] == NOLLA) {
				// Pelaaja 2 Voitti!
				this.voitto(NOLLA);
			} else if (this.lauta.kentta[0][2] == NOLLA && this.lauta.kentta[1][2] == NOLLA && this.lauta.kentta[2][2] == NOLLA && this.lauta.kentta[3][2] == NOLLA) {
				// Pelaaja 2 Voitti!
				this.voitto(NOLLA);
			} else if (this.lauta.kentta[0][3] == NOLLA && this.lauta.kentta[1][3] == NOLLA && this.lauta.kentta[2][3] == NOLLA && this.lauta.kentta[3][3] == NOLLA) {
				//Pelaaja 2 Voitti
				this.voitto(NOLLA);
			}
			// Vinorivi tarkistukset Pelaaja 2
			else if (this.lauta.kentta[0][0] == NOLLA && this.lauta.kentta[1][1] == NOLLA && this.lauta.kentta[2][2] == NOLLA && this.lauta.kentta[3][3] == NOLLA) {
				// Pelaaja 2 Voitti!
				this.voitto(NOLLA);
			} else if (this.lauta.kentta[0][3] == NOLLA && this.lauta.kentta[1][2] == NOLLA && this.lauta.kentta[2][1] == NOLLA && this.lauta.kentta[3][0] == NOLLA) {
				// Pelaaja 2 Voitti!
				this.voitto(NOLLA);
			}			
		}
		else if (koko == 5) {
			
			// Vaakarivi tarkistukset Pelaaja 1
			if (this.lauta.kentta[0][0] == 1 && this.lauta.kentta[0][1] == 1 && this.lauta.kentta[0][2] == 1 && this.lauta.kentta[0][3] == 1 && this.lauta.kentta[0][4] == 1) {
				// Pelaaja 1 Voitti!
				this.voitto(1);
			} else if (this.lauta.kentta[1][0] == 1 && this.lauta.kentta[1][1] == 1 && this.lauta.kentta[1][2] == 1 && this.lauta.kentta[1][3] == 1 && this.lauta.kentta[1][4] == 1) {
				//Pelaaja 1 Voitti!
				this.voitto(1);
			} else if (this.lauta.kentta[2][0] == 1 && this.lauta.kentta[2][1] == 1 && this.lauta.kentta[2][2] == 1 && this.lauta.kentta[2][3] == 1 && this.lauta.kentta[2][4] == 1) {
				//Pelaaja 1 Voitti
				this.voitto(1);
			} else if (this.lauta.kentta[3][0] == 1 && this.lauta.kentta[3][1] == 1 && this.lauta.kentta[3][2] == 1 && this.lauta.kentta[3][3] == 1 && this.lauta.kentta[3][4] == 1) {
				//Pelaaja 1 Voitti
				this.voitto(1);
			} else if (this.lauta.kentta[4][0] == 1 && this.lauta.kentta[4][1] == 1 && this.lauta.kentta[4][2] == 1 && this.lauta.kentta[4][3] == 1 && this.lauta.kentta[4][4] == 1) {
				//Pelaaja 1 Voitti
				this.voitto(1);
			}
			// Pystyrivi tarkistukset Pelaaja 1
			else if (this.lauta.kentta[0][0] == 1 && this.lauta.kentta[1][0] == 1 && this.lauta.kentta[2][0] == 1 && this.lauta.kentta[3][0] == 1 && this.lauta.kentta[4][0] == 1) {
				// Pelaaja 1 Voitti!
				this.voitto(1);
			} else if (this.lauta.kentta[0][1] == 1 && this.lauta.kentta[1][1] == 1 && this.lauta.kentta[2][1] == 1 && this.lauta.kentta[3][1] == 1 && this.lauta.kentta[4][1] == 1) {
				// Pelaaja 1 Voitti!
				this.voitto(1);
			} else if (this.lauta.kentta[0][2] == 1 && this.lauta.kentta[1][2] == 1 && this.lauta.kentta[2][2] == 1 && this.lauta.kentta[3][2] == 1 && this.lauta.kentta[4][2] == 1) {
				// Pelaaja 1 Voitti!
				this.voitto(1);
			} else if (this.lauta.kentta[0][3] == 1 && this.lauta.kentta[1][3] == 1 && this.lauta.kentta[2][3] == 1 && this.lauta.kentta[3][3] == 1 && this.lauta.kentta[4][3] == 1) {
				//Pelaaja 1 Voitti
				this.voitto(1);
			} else if (this.lauta.kentta[0][4] == 1 && this.lauta.kentta[1][4] == 1 && this.lauta.kentta[2][4] == 1 && this.lauta.kentta[3][4] == 1 && this.lauta.kentta[4][4] == 1) {
				//Pelaaja 1 Voitti
				this.voitto(1);
			}
			// Vinorivi tarkistukset Pelaaja 1
			else if (this.lauta.kentta[0][0] == 1 && this.lauta.kentta[1][1] == 1 && this.lauta.kentta[2][2] == 1 && this.lauta.kentta[3][3] == 1 && this.lauta.kentta[4][4] == 1) {
				// Pelaaja 1 Voitti!
				this.voitto(1);
			} else if (this.lauta.kentta[0][4] == RISTI && this.lauta.kentta[1][3] == RISTI && this.lauta.kentta[2][2] == RISTI && this.lauta.kentta[3][1] == RISTI && this.lauta.kentta[4][0] == RISTI) {
				// Pelaaja 1 Voitti!
				this.voitto(RISTI);
			}
			// Vaakarivi tarkistukset Pelaaja 2
			else if (this.lauta.kentta[0][0] == NOLLA && this.lauta.kentta[0][1] == NOLLA && this.lauta.kentta[0][2] == NOLLA && this.lauta.kentta[0][3] == NOLLA && this.lauta.kentta[0][4] == NOLLA) {
				// Pelaaja 2 Voitti!
				this.voitto(NOLLA);
			} else if (this.lauta.kentta[1][0] == NOLLA && this.lauta.kentta[1][1] == NOLLA && this.lauta.kentta[1][2] == NOLLA && this.lauta.kentta[1][3] == NOLLA && this.lauta.kentta[1][4] == NOLLA) {
				//Pelaaja 2 Voitti!
				this.voitto(NOLLA);
			} else if (this.lauta.kentta[2][0] == NOLLA && this.lauta.kentta[2][1] == NOLLA && this.lauta.kentta[2][2] == NOLLA && this.lauta.kentta[2][3] == NOLLA && this.lauta.kentta[2][4] == NOLLA) {
				//Pelaaja 2 Voitti
				this.voitto(NOLLA);
			} else if (this.lauta.kentta[3][0] == NOLLA && this.lauta.kentta[3][1] == NOLLA && this.lauta.kentta[3][2] == NOLLA && this.lauta.kentta[3][3] == NOLLA && this.lauta.kentta[3][4] == NOLLA) {
				//Pelaaja 2 Voitti
				this.voitto(NOLLA);
			} else if (this.lauta.kentta[4][0] == NOLLA && this.lauta.kentta[4][1] == NOLLA && this.lauta.kentta[4][2] == NOLLA && this.lauta.kentta[4][3] == NOLLA && this.lauta.kentta[4][4] == NOLLA) {
				//Pelaaja 2 Voitti
				this.voitto(NOLLA);
			} 
			// Pystyrivi tarkistukset Pelaaja 2
			else if (this.lauta.kentta[0][0] == NOLLA && this.lauta.kentta[1][0] == NOLLA && this.lauta.kentta[2][0] == NOLLA && this.lauta.kentta[3][0] == NOLLA && this.lauta.kentta[4][0] == NOLLA) {
				// Pelaaja 2 Voitti!
				this.voitto(NOLLA);
			} else if (this.lauta.kentta[0][1] == NOLLA && this.lauta.kentta[1][1] == NOLLA && this.lauta.kentta[2][1] == NOLLA && this.lauta.kentta[3][1] == NOLLA && this.lauta.kentta[4][1] == NOLLA) {
				// Pelaaja 2 Voitti!
				this.voitto(NOLLA);
			} else if (this.lauta.kentta[0][2] == NOLLA && this.lauta.kentta[1][2] == NOLLA && this.lauta.kentta[2][2] == NOLLA && this.lauta.kentta[3][2] == NOLLA && this.lauta.kentta[4][2] == NOLLA) {
				// Pelaaja 2 Voitti!
				this.voitto(NOLLA);
			} else if (this.lauta.kentta[0][3] == NOLLA && this.lauta.kentta[1][3] == NOLLA && this.lauta.kentta[2][3] == NOLLA && this.lauta.kentta[3][3] == NOLLA && this.lauta.kentta[4][3] == NOLLA) {
				//Pelaaja 2 Voitti
				this.voitto(NOLLA);
			} else if (this.lauta.kentta[0][4] == NOLLA && this.lauta.kentta[1][4] == NOLLA && this.lauta.kentta[2][4] == NOLLA && this.lauta.kentta[3][4] == NOLLA && this.lauta.kentta[4][4] == NOLLA) {
				//Pelaaja 2 Voitti
				this.voitto(NOLLA);
			}
			// Vinorivi tarkistukset Pelaaja 2
			else if (this.lauta.kentta[0][0] == NOLLA && this.lauta.kentta[1][1] == NOLLA && this.lauta.kentta[2][2] == NOLLA && this.lauta.kentta[3][3] == NOLLA && this.lauta.kentta[4][4] == NOLLA) {
				// Pelaaja 2 Voitti!
				this.voitto(NOLLA);
			} else if (this.lauta.kentta[0][4] == NOLLA && this.lauta.kentta[1][3] == NOLLA && this.lauta.kentta[2][2] == NOLLA && this.lauta.kentta[3][1] == NOLLA && this.lauta.kentta[4][0] == NOLLA) {
				// Pelaaja 2 Voitti!
				this.voitto(NOLLA);
			}
		}
	}
	
	/**
	 * Metodi julistaa voittajan.
	 * @param voittaja Int, joka kuvastaa voittajan.
	 */
	private void voitto(int voittaja) {
		String[] temp = new String[2];
		String[] voitta = this.lauta.pelaajaNimet;
		
		if (voittaja < 1 && voittaja > 2) {
			System.out.println("Väärä luku!");
			return;
		}
		if (voittaja == RISTI) {
			System.out.println("Pelaaja 1 Voitti!");
			temp[0] = voitta[0]+" 1 0 1";
			temp[1] = voitta[1] +" 0 1 1";
			
		} else if (voittaja == NOLLA) {
			System.out.println("Pelaaja 2 Voitti!");
			temp[0] = voitta[0]+" 0 1 1";
			temp[1] = voitta[1] +" 1 0 1";
		}		
		this.pisteita = temp;
		this.pisteLisays.lisaaPisteet(this.pisteita);
	}
	
	/**
	 * Funktio tarkistaa koko pelilaudan onko se jo täynnä.
	 * Jos löytyy ensimmäinenkin tyhjä ruut, funktio lopettaa tarkistuksen.
	 * @return booleanarvo, joka kertoo, onko täyttä vai ei.
	 */
	public boolean peliTays() {
		for (int i = 0; i < this.lauta.kentta.length; i++) {
			for (int j = 0; j < this.lauta.kentta[i].length; j++) {
				if (this.lauta.kentta[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * Funktio lisää valittuun kentän kohtaan riston taikka nolla, riippuen kumman vuoro on.
	 * @param x Int arvo, joka kertoo kentän x-koordinaation
	 * @param y Int arvo, joka kertoo kentän y-koordinaation
	 */
	public void lisaaMerkki (int x, int y) {
		this.lauta.kentta[x][y] = this.pvuoro;
		this.seuraavaVuoro();
	}
	
	/**
	 * Funktio asettaa pelivuoron seuraavalle pelaajalle.
	 */
	private void seuraavaVuoro () {
		 if (this.pvuoro == 1) {
			this.pvuoro = 2;
			return;
		} else if (this.pvuoro == 2) {
			this.pvuoro = 1;
			return;
		}
	}
	
	public void lataaPeli(String file) {
		this.lauta.kentta = this.lauta.lataaKentta(file);
		this.pvuoro = this.lauta.vuoro;
		this.pisteita = this.lauta.pelaajaNimet;
		
	}
	
	/*
	public static void main(String[] args) {
		
		Pelimekaniikka mech = new Pelimekaniikka(3);
		mech.lauta.pelaajaNimet[0] = "Lauri";
		mech.lauta.pelaajaNimet[1] = "Timo";
		String nimi = "lol.txt";
		
		for (int i = 0; i < mech.lauta.kentta.length; i++) {
			for (int j = 0; j < mech.lauta.kentta[i].length; j++) {
				if (!mech.peliTays()) {
					System.out.println("Pelissä on tilaa! Vuoro: "+mech.pvuoro);
					mech.lisaaMerkki(i,j);
				}
				else { 
					System.out.println("Kentät on täysiä");
				}
				mech.peliTilanne();
			}
		}
		mech.lauta.tallennaKentta(mech.pvuoro,nimi);
		mech.lataaPeli(nimi);
		for (int i = 0; i < mech.lauta.kentta.length; i++) {
			for (int j = 0; j < mech.lauta.kentta[i].length; j++) {
				System.out.println(mech.lauta.kentta[i][j]);
			}
		}
	}
	*/
}
