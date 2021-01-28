package multithreading.implementingRunnableInterface;


public class MyThread implements  Runnable{
    private long maxPrime;

    MyThread(long maxPrime){
        this.maxPrime=maxPrime;
    }
    @Override
    public void run() {
        for(int i=2;i<=maxPrime;i++){
            if(isPrime(i))
                System.out.println(i);
        }
    }
    private boolean isPrime(long number){
        long sqrtNumber = (long) Math.sqrt(number);
        for(int i=2;i<=sqrtNumber;i++){
            if(number%i==0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread(30); //creating instance of MyThread class
        Thread thread = new Thread(myThread); //passing MyThread class instance to Thread class
        thread.start();//starting the thread
    }
}
