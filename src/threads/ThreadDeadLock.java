package threads;

/**
 * Created by Ajay on 04-Apr-16.
 */
public class ThreadDeadLock {

    static RunnableThread1 t1;
    static RunnableThread2 t2;

    public static void main(String[] args) {
        t1 = new RunnableThread1();
        t2 = new RunnableThread2();

        System.out.println("Starting RunnableThread1");
        t1.start();
        System.out.println("Starting RunnableThread2");
        t2.start();
    }

    static class RunnableThread1 extends Thread{

        @Override
        public void run() {
            try {
                t2.m1();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public synchronized void m1() throws Exception{
            System.out.println("RunnableThread1.m1");
            Thread.sleep(5000);
        }
    }

    static class RunnableThread2 extends Thread{

        @Override
        public void run() {
            try {
               t1.m1();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public synchronized void m1() throws Exception{
            System.out.println("RunnableThread2.m1");
            Thread.sleep(5000);
        }
    }
}
