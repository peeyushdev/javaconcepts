package multithreading.consumerproducer2;

public class Data {
    String message;
    boolean messageAvailable = false;

    public synchronized void pushMessage(String message){
        while(messageAvailable){
            try {
                wait();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
        messageAvailable= true;
        this.message=message;
        printMessage(message);
        notifyAll();
    }


    public synchronized void pullMessage(){
        while (!messageAvailable){
            try {
                wait();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
        printMessage(message);
        messageAvailable=false;
        notifyAll();
    }

    public void printMessage(String message){
        System.out.println(Thread.currentThread().getName()+":"+message);
    }
}
