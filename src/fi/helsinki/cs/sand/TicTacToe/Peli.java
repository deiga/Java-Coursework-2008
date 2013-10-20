package fi.helsinki.cs.sand.TicTacToe;

/**
 * Luokka toimii pelin rajapintana, suurin osa toiminnasta tehd��n luokan kautta.
 * @author Deiga
 *
 */
public class Peli {
	
		Highscore pisteet = new Highscore();
		Pelimekaniikka mech;
		
		/**
	     * Luo uuden pelin.
	     */
	    public Peli(int size) {
	    	this.aloitaPeli(size);
	    }
	    
	    public Peli(String file) {
	    	this.aloitaPeli(file);
	    }

	    /**
	     * Aloittaa uuden pelin, kyselle alustukset jne.
	     */
	    public void aloitaPeli(int gsize) {
	    	mech = new Pelimekaniikka(gsize);	
	    }
	    
	    public void aloitaPeli(String file) {
	    	mech = new Pelimekaniikka(file);
	    }

	    /**
	     * N�ytt�� pelin pistetilanteen
	     */
	    public void katsoPisteet() {
	    	this.pisteet.naytaPisteet();
	    	}

	    /**
	     * Talentaa menossa olevan pelin
	     */
	    public void tallennaPeli(String file) {
	    	this.mech.lauta.tallennaKentta(this.mech.lauta.vuoro, file);	
	    }

	    /**
	     * Lataa tallennetun pelitilanteen
	     */
	     public void lataaPeli(String file) {
	    	 this.mech.lataaPeli(file);
	     }
}

