package multithreading.symchronization.threadinterference;

public class Counter implements Runnable{
    int count = 0;

    public void inc(){
        count++;
    }
    public void dec(){
        count--;
    }
    public int getValue(){
        return count;
    }

    @Override
    public void run() {
        this.inc();
        System.out.println(Thread.currentThread().getName()+" "+ this.getValue());
        this.inc();
        System.out.println(Thread.currentThread().getName()+" "+ this.getValue());
        this.dec();
        System.out.println(Thread.currentThread().getName()+" "+ this.getValue());
    }
}
