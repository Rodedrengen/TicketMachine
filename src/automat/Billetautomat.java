package automat;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.ArrayList;

/**
 * Model af en simpel billetautomat til enkeltbilletter med én fast pris.
 */
public class Billetautomat {
        
        private ArrayList<String> logg = new ArrayList<String>();
        Date date = new Date();
	private int billetpris;    // Prisen for én billet.
	private int balance; // Hvor mange penge kunden p.t. har puttet i automaten
	private int antalBilletterSolgt; // Antal billetter automaten i alt har solgt
	private boolean montørtilstand;
	/**
	 * Opret en billetautomat der sælger billetter til 10 kr.
	 */
        
        
	public Billetautomat() {
		billetpris = 10;
		balance = 0;
		antalBilletterSolgt = 0;
                logg.add(new Date() + " a TicketMachine was created");
                
                 
	}

	/**
	 * Giver prisen for en billet. 
     * @return 
	 */
	public int getBilletpris() {
		int resultat = billetpris;
                //logg.add(new Date() + "a request for Ticketprice was made");
		return resultat;
	}

	/**
	 * Modtag nogle penge (i kroner) fra en kunde.
     * @param beløb
	 */
	public void indsætPenge(int beløb) {
                if(beløb < 0){
                    beløb = 0; 
                    System.out.println("Du har indkastet mindre end 0 kroner. Det kan man ikke");
                }
		balance = balance + beløb;
                logg.add(new Date() + " " + beløb + " was put into the machine");
	}

	/**
	 * Giver balancen (beløbet maskinen har modtaget til den næste billet).
     * @return 
	 */
	public int getBalance() {
                //logg.add(new Date() + " a request for balance was made");
		return balance;
	}

	/**
	 * Udskriv en billet.
	 * Opdater total og nedskriv balancen med billetprisen
	 */
	public void udskrivBillet() {
		if (balance < billetpris) {
			System.out.println("Du mangler at indbetale nogle penge");
                        return; 
		}
		System.out.println("##########B##T#########");
		System.out.println("# BlueJ Trafikselskab #");
		System.out.println("#                     #");
		System.out.println("#        Billet       #");
		System.out.println("#        " + billetpris + " kr.       #");
		System.out.println("#                     #");
		System.out.println("##########B##T#########");
		System.out.println("#Du har " + (balance-billetpris) + " kr til gode#");
		System.out.println("##########B##T#########");
		System.out.println();

		antalBilletterSolgt = antalBilletterSolgt + 1;
		balance = balance - billetpris; // Billetter koster 10 kroner
                logg.add(new Date() + " a tricket was printed");
	}


	public int returpenge() {
		int returbeløb = balance;
		logg.add(new Date() + " "+ balance + " was returned");
                balance = 0;
		//System.out.println("Du får "+returbeløb+" kr retur"); //Is this even needed, we're allready printing in the main(); 
		return returbeløb;
	}

	
	void montørLogin(String adgangskode) {
		if ("1234".equals(adgangskode)) {
			montørtilstand = true;
			System.out.println("Montørtilstand aktiveret");
			System.out.println("Du kan nu angive billetpris");
                        logg.add(new Date() + " an admin logged on");
		} else {
			montørtilstand = false;
			System.out.println("Montørtilstand deaktiveret");
                        logg.add(new Date() + " an admin failed to logon");
		}
	}


	public int getTotal() {
		if (montørtilstand) {
                        logg.add(new Date() + " a request for earning was succesfull");
			return billetpris * antalBilletterSolgt;
		} else {
                        logg.add(new Date() + " a equest for earning failed");
			System.out.println("Afvist - log ind først");
			return 0;
		}
	}

	public int getAntalBilletterSolgt() {
		if (montørtilstand) {
                        logg.add(new Date() + " a request for amount of tickets sold was succesfull");
			return antalBilletterSolgt;
		} else {
                        logg.add(new Date() + " a request for amount of tickets sold failed");
			System.out.println("Afvist - log ind først");
			return 0;
		}
	}

	public void setBilletpris(int billetpris) {
                if(montørtilstand){
                    logg.add(new Date() + " an atempt to change the tickeprice was succesfull");
                    this.billetpris = billetpris;
                }else{
                    logg.add(new Date() + " a request to change the ticketprice failed");
                    System.out.println("Afvist - log ind først");
                }
		
	}
	public void nulstil() {
		if (montørtilstand) {
                        logg.add(new Date() + " a request to reset the machine was succesfull");
			antalBilletterSolgt = 0;
		} else {
                        logg.add(new Date() + " a request to reset the machine failed");
			System.out.println("Afvist - log ind først");
		}
	}

	public void setAntalBilletterSolgt(int antalBilletterSolgt) {
		if (montørtilstand) {
                        logg.add(new Date() + " an atempt to the amount of tickets sold was succesfull");
			this.antalBilletterSolgt = antalBilletterSolgt;
		} else {
                        logg.add(new Date() + " an atempt to the amount of tickets sold failed");
			System.out.println("Afvist - log ind først");
		}
	}

	public boolean erMontør() {
		return montørtilstand;
	}
        public void printeLog() { 
            if (montørtilstand) {
                System.out.print("========== log pr " + new Date() + "\n" );
                for (String log : logg) {
                    System.out.println(log);
                }
                System.out.println("==========");
            } else {
                System.out.println("Afvist - log ind først");
            }
    }
        public void savelog(){
            
            if(montørtilstand){
                    FileWriter fil = null;
                    try {
                        fil = new FileWriter("log.txt");
                        
                        PrintWriter file = new PrintWriter(fil);
                        
                        file.println("========== log pr " + new Date() + "\n");
                        for (String var : logg){
                            file.println(var);
                            System.out.println(var);
                        }

                        file.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }else{
                 System.out.println("Afvist - log ind først");
                     }               
            }               
}
