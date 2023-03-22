package E3_W2_U1;

import java.util.List;

public class Ex2_Thread extends Thread {
    String t_name;
    List<Integer> threadPartition;
    int partitionSum = 0;

    Ex2_Thread(String name, List<Integer> listPart) {
        t_name = name;
        threadPartition = listPart;
    }

    @Override
    public void run() {
        for (int n : threadPartition) {
            partitionSum += n;
        }
    }
}
