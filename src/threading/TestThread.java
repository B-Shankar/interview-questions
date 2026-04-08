package threading;

public class TestThread {

    public static void main(String[] args) {

        MyThread t1 = new MyThread();
        t1.start();

        MyThreadRunnable mtr1 = new MyThreadRunnable();
        Thread t2 = new Thread(mtr1);

        t2.start();

        try {
            t1.join();
            System.out.println("--------------------------------");
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
