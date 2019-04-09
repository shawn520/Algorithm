package thread;

public class MultiThread {

    public static void main(String [] args) throws Exception{
        Thread thread = new Thread(new MyRunnable());
        thread.start();
        for(int i=0;i<100;i++) {
            System.out.println("Main:" + i);
            Thread.sleep(100);
        }
    }
}
