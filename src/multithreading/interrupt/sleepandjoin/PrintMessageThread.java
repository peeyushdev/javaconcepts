package multithreading.interrupt.sleepandjoin;

import multithreading.constants.Constants;

public class PrintMessageThread implements Runnable {

    private Thread mainThread;

    public PrintMessageThread(Thread mainThread) {
        this.mainThread = mainThread;
    }

    @Override
    public void run() {
        try {
            for (String string : Constants.stringArray) {
                Thread.sleep(50);
                System.out.println(Thread.currentThread().getName() + "printed " + string);
            }
        } catch (Exception e) {
//            here getState() will always be false as the interrupted status was cleared by sleep method.
//            System.out.println(Thread.currentThread().isInterrupted()+""+Thread.currentThread().getState()+" "+Thread.currentThread().getName());
            System.out.println("PrintMessageThread is interrupted inside catch");
        }
    }
}
