package multithreading.symchronization.threadinterference;

public class MainThread {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread t1 = new Thread(counter,"t1");
        Thread t2 = new Thread(counter,"t2");
        t1.start();
        t2.start();
    }
}
