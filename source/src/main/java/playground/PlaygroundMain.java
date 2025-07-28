package playground;

final class Counter {
    private int count;

    public Counter() {
        this.count = 0;
    }

    public synchronized void increment() {
        this.count++;
    }

    public int getCount() {
        return this.count;

    }
}

public class PlaygroundMain {
    public static void main(String[] args) throws InterruptedException {

        final Counter counter = new Counter();
        final int target = 10_000_000;

        long start = System.nanoTime();

        final Runnable t1 = () -> {
            for (int i = 0; i < target; i++)
                counter.increment();
        };

        final Runnable t2 = () -> {
            for (int i = 0; i < target; i++)
                counter.increment();
        };

        t1.run();
        t2.run();

        long end = System.nanoTime();

        System.out.println((end - start) / 1_000_000);
        System.out.println(counter.getCount());
    }
}
