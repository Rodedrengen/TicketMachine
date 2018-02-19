package automat;



public class BenytBilletautomat
{
	public static void main(String[] arg)
	{
		Billetautomat automat = new Billetautomat();
		java.util.Scanner tastatur = new java.util.Scanner(System.in);  // forbered

		System.out.println("BenytBilletautomat version 3");
		System.out.println();
		
		while (true) {
			System.out.println("-----------------------------------------------");
			System.out.println("En billet koster " + automat.getBilletpris() + " kroner");
			System.out.println("Balancen er på " + automat.getBalance() + " kroner");
			System.out.println();
			System.out.println("Tast 1 for at indbetale penge");
			System.out.println("Tast 2 for at udskrive din billet");
			System.out.println("Tast 3 for at få returpengene");
			System.out.println();
			System.out.println("Tast 10 for at logge ind som montør");
			if (automat.erMontør()) {
				System.out.println("Tast 11 for at se status (montør)");
				System.out.println("Tast 12 for at nulstille (montør)");
				System.out.println("Tast 13 for at sætte billetpris (montør)");
				System.out.println("Tast 14 for at logge ud af montørtilstand");
                                System.out.println("Press 15 for print log");
			}
			int valg = tastatur.nextInt();
			tastatur.nextLine();
		
                    switch (valg) {
                        case 1:
                                System.out.print("Skriv beløb: ");
                                int inputAmount = tastatur.nextInt();
                                automat.indsætPenge(inputAmount);
                                break;
                        case 2:
                            automat.udskrivBillet();
                            break;
                        case 3:
                                int returnAmount = automat.returpenge();
                                System.out.println("Du fik "+returnAmount+" retur retur");
                                break;
                        case 10:
                            System.out.print("Skriv kode: ");
                            String kode = tastatur.next();
                            automat.montørLogin(kode);
                            break;
                        case 11:
                            System.out.println("Antal billetter solgt: " + automat.getAntalBilletterSolgt());
                            System.out.println("Total indkomst: " + automat.getTotal()+" kr");
                            break;
                        case 12:
                            automat.nulstil();
                            break;
                        case 13:
                                System.out.print("Skriv beløb: ");
                                int aTicketPrice = tastatur.nextInt();
                                automat.setBilletpris(aTicketPrice);
                                break;
                        case 14:
                            automat.montørLogin("");
                            break;
                        case 15:
                            automat.printeLog();
                            break;
                        default:
                            System.out.println("Ugyldigt valg, prøv igen");
                            break;
                    }
		}
	}
}