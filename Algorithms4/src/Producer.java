import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Producer {

    public static void main(String[] args) {
        new Thread(pRun).start();
        new Thread(conRun).start();
    }

    private static LinkedList<Integer> list = new LinkedList<>();
    private static Lock lock = new ReentrantLock(false);
    private static Condition proCon = lock.newCondition();
    private static Condition consumCon = lock.newCondition();
    private static AtomicInteger num = new AtomicInteger();

    private static Runnable pRun = new Runnable() {
        @Override
        public void run() {
            while (true) {
                produce(num.incrementAndGet());
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    private static Runnable conRun = new Runnable() {
        @Override
        public void run() {
            while (true) {
                consume();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    private static void produce(int n) {
        lock.lock();
        if (list.size() >= 10) {
            try {
                proCon.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.add(n);
        System.out.println("add n " + n + " size " + list.size());
        if (list.size() == 1) {
            consumCon.signalAll();
        }
        lock.unlock();
    }

    private static void consume() {
        lock.lock();
        if (list.size() == 0) {
            try {
                consumCon.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Integer n = list.poll();
        System.out.println("remove n " + n + " size " + list.size());
        if (list.size() == 9) {
            proCon.signalAll();
        }
        lock.unlock();
    }
}
