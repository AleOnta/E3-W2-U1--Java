package E3_W2_U1;

public class Ex1_Runnable {
    static public void main(String[] args) {

        // creating 2 new Thread for the exercise
        Ex1_Thread T1 = new Ex1_Thread("*");
        Ex1_Thread T2 = new Ex1_Thread("#");

        T1.start();
        T2.start();
    }
}
