package multithreading.extendingThreadClass;


//returns the prime number upto the number we have specified
public class MyThread extends Thread {
    private long maxPrime;

    MyThread(long maxPrime) {
        this.maxPrime = maxPrime;
    }

    @Override
    public void run() {
        for (long i = 2L; i <= maxPrime; i++) {
            if (isPrime(i))
                System.out.println(i);
        }
    }

    private boolean isPrime(long number) {
        long sqrtNumber = (long) Math.sqrt(number);
        for (long i = 2; i <= sqrtNumber; i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread(20);
        myThread.start();
    }
}
