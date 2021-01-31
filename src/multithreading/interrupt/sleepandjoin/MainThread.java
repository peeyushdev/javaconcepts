package multithreading.interrupt.sleepandjoin;

public class MainThread {
    public static void main(String[] args)  {
        PrintMessageThread printMessageThread = new PrintMessageThread(Thread.currentThread());
        Thread printMessage = new Thread(printMessageThread,"PrintMessage");
        printMessage.start();
        try {
            printMessage.join(20);
            printMessage.interrupt();
            for(int i=0;i<10;i++){
                System.out.println(Thread.currentThread().getName()+"printed"+(i+1));
            }
        }catch (InterruptedException interruptedException){
            System.out.println("Interrupted Exception came in main thread");
        }

    }
}
