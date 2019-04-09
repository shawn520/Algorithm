package others.thread;

public class Main {
    public static void main(String [] args) {
        /*MyThread myThread = new MyThread();
        myThread.start();*/
        Thread thread = new Thread(new MyRunnable());
        for(int i=0;i<100;i++) {
            System.out.println("MainThread:" + i);

        }
    }
}
