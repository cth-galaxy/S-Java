package Thread;

/**
 *继承thread
 * @author: CTH
 **/
public class StartThread extends Thread {
    @Override
    public void run() {
        for (int i=0; i<100; i++) {
            System.out.println("Sing");
        }
    }

    public static void main(String[] args) {
        StartThread st = new StartThread();
        st.start();
        for (int i=0; i<100; i++) {
            System.out.println("Code");
        }
    }
}
