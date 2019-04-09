package others.thread;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for(int i=0;i<100;i++) {
            System.out.println("MyRunnable:" + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
