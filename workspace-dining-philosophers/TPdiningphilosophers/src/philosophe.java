
//imports
import java.util.concurrent.ThreadLocalRandom;

public class philosophe extends Thread {
		
		//variables
        public int nombre;
        //constructeurs
        public fourchette fourchettegauche;
        public fourchette fourchettedroite;
        public philosophe(int nb, fourchette gauche, fourchette droite) {
            nombre = nb;
            fourchettegauche = gauche;
            fourchettedroite = droite;
        }

        //fonction qui anime les philosophes
        public void run(){

            while (true) {
            	fourchettegauche.prend();
                System.out.println("Le philosophe numéro " + (nombre+1) + " prend la fourchette gauche.");
                fourchettedroite.prend();
                System.out.println("Le philosophe numéro " + (nombre+1) + " prend la fourchette droite.");
                mange();
                fourchettegauche.relache();
                System.out.println("Le philosophe numéro " + (nombre+1) + " relache la fourchette gauche.");
                fourchettedroite.relache();
                System.out.println("Le philosophe numéro " + (nombre+1) + " relache la fourchette droite.");
                pense();
            }
        }
        
        //fonction qui fait manger un philosophe
        public void mange() {
            try {
                int temps = ThreadLocalRandom.current().nextInt(0, 1000);
                System.out.println("Le philosophe numéro " + (nombre+1) + " mange pendant " + "0." + temps + " secondes. ");
                Thread.sleep(temps);
            }
            catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }
        
        //fonction qui fait penser un philosophe
        public void pense() {
            try {
                int temps = ThreadLocalRandom.current().nextInt(0, 1000);
                System.out.println("Le philosophe numéro " + (nombre+1) + " pense pendant " + "0." + temps + " secondes. ");
                Thread.sleep(temps);
            }
            catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }
    }