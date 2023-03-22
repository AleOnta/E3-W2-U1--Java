package E3_W2_U1;

// I've use the extends version of Thread Superclass because it's the only Superclass needed.
public class Ex1_Thread extends Thread {

    int cicle = 10;
    String sybl;

    public Ex1_Thread(String symbol) {
        sybl = symbol;
    }

    @Override
    public void run() {
        for (int i = 0; i < cicle; i++) {
            System.out.print(sybl);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
