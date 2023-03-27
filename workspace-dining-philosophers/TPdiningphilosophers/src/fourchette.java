
//imports
import java.util.concurrent.Semaphore;

public class fourchette {
		
		//constructeurs
        public Semaphore mutex = new Semaphore(1);
       
        //fonction qui prend une fourchette
        public void prend() {
            try {
                mutex.acquire();
            }
            catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }
        	
        //fonction qui relache une fourchette
        public void relache() {
            mutex.release();
        }

        //fonction qui check la disponibilité des fourchettes
        public boolean disponible() {
            return mutex.availablePermits() > 0;
        }
    }
