package multithreading.join;

public class MainThread {
    public static void main(String[] args) {
        PrintMessage printMessage = new PrintMessage();
        Thread newThread = new Thread(printMessage, "printMessage");
        newThread.start();
        for (int i = 1; i <= 10; i++) {
            System.out.println("Main Thread printed" + i);
            try {
                newThread.join();
            } catch (InterruptedException interruptedException) {
                System.out.println(interruptedException);
            }
        }
    }
}
