
//main
public class TPtest {

    static int philosophe = 5;	//ajuster le nombre de philosophes
    static philosophe philosophes[] = new philosophe[philosophe];	//nouvelle liste de philosophes de la taille voulue
    static fourchette fourchettes[] = new fourchette[philosophe];	//nouvelle liste de fourhettes d'une taille équivalente

    public static void main(String argv[]) {
    	
    	//création du nombre de fourchettes voulues
        for (int i = 0; i < philosophe; i++) {
            fourchettes[i] = new fourchette();
        }
        
        //création du nombre de philosophes voulus
        for (int i = 0; i < philosophe; i++) {
        	
        	//réduction des possibilités de deadlock si c'est le dernier philosophe
        	if (i == philosophes.length - 1) {
        	    philosophes[i] = new philosophe(i, fourchettes[(i + 1) % philosophe],fourchettes[i] );

        	} else {
        	    philosophes[i] = new philosophe(i, fourchettes[i], fourchettes[(i + 1) % philosophe]);
        	    philosophes[i].start();
        	}
        }

        while (true) {
            try {
                
            	// dors pendant 1 seconde
                Thread.sleep(1000);

                // check deadlock
                boolean deadlock = true;
                for (fourchette f : fourchettes) {
                    if (f.disponible()) {
                        deadlock = false;
                        break;
                    }
                }
                
                //dans le cas d'un deadlock
                if (deadlock) {
                    Thread.sleep(10000);	//ajuster la durée du programme
                    System.out.println("Fini de manger.");
                    break;
                }
            }
            catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }
        
        //fin du programme
        System.exit(0);
    }
}