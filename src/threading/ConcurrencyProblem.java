package threading;


import java.util.concurrent.atomic.AtomicInteger;

class Counter {
    // Race Condition
//    int counter = 0; // non-atomic

//    void increment() {
//        counter++;
//    }

    // Atomic value
    AtomicInteger counter = new AtomicInteger(0);

    void increment() {
        counter.getAndIncrement();
    }
}

public class ConcurrencyProblem {

    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++)
                c.increment();
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                c.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Counter: " + c.counter);
    }
}
