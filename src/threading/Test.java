package threading;

// using Thread class
class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("Running thread using Thread class");
    }
}

// using Runnable interface
class MyThreadRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Runnable thread using Runnable Interface");
    }
}

public class Test {

    public static void main(String[] args) {
        MyThread t1 = new MyThread();

        t1.start();

        MyThreadRunnable mtr1 = new MyThreadRunnable();
        Thread t2 = new Thread(mtr1);

        t2.start();
    }
}
