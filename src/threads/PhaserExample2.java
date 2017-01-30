package threads;

import java.util.Date;
import java.util.concurrent.Phaser;

/**
 * Created by Ajay on 18-Apr-16.
 */
public class PhaserExample2 implements Runnable
{
    static Phaser phaser = new Phaser();

    PhaserExample2 () {
        phaser.register();
    }


    public static void main(String[] args) throws InterruptedException
    {
        phaser.register();//register self... phaser waiting for 1 party (thread)

        System.out.println("Phasecount is "+phaser.getPhase());

        new Thread(new PhaserExample2()).start();
        new Thread(new PhaserExample2()).start();
        new Thread(new PhaserExample2()).start();

        phaser.arriveAndDeregister();
        Thread.sleep(10000);
        System.out.println("Phasecount is "+phaser.getPhase());

        phaser.arriveAndDeregister();
    }

    @Override
    public void run() {
        try
        {
            System.out.println(Thread.currentThread().getName()+" arrived at "+ new Date() +", Barrier: 1");
            phaser.arriveAndAwaitAdvance();     //1st barrier.
            if(Thread.currentThread().getName().equals("Thread-0")){
                phaser.arriveAndDeregister();
                System.out.println("Deregistering "+Thread.currentThread().getName());
            } else {
                Thread.sleep(3000);
            }

            //===============Task 1======================
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " processing "+i);
            }
            System.out.println(Thread.currentThread().getName() + " finished task 1");
            //===============Task 1======================

            phaser.arriveAndAwaitAdvance();     //2nd barrier.
            System.out.println(Thread.currentThread().getName()+", Time: "+ new Date()+", Barrier: 2");
            Thread.sleep(3000);

            //===============Task 2======================
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " processing "+i);
            }
            System.out.println(Thread.currentThread().getName() + " finished task 2");
            //===============Task 2======================

            phaser.arriveAndAwaitAdvance();     //3rd barrier.
            System.out.println(Thread.currentThread().getName()+", Time: "+ new Date()+", Barrier: 3");
        }

        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
