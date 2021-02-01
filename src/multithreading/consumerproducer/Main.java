package multithreading.consumerproducer;

import multithreading.constants.Constants;

public class Main {
    static class Message {
        String message;
        volatile boolean messageProduced = false;
        volatile boolean messageConsumed = true;

        public synchronized void printMessage(String output) {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + "| " + output);
        }

        public synchronized void consumer() {
            while (!messageProduced) {
                try {
                    printMessage("waiting for producer to produce message");
                    wait();
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
                if(message==null)
                    break;
                printMessage("consumed message:" + message);
                messageConsumed = true;
                messageProduced = false;
                notify();
            }
            printMessage("finished");
        }

        public synchronized void producer(String[] message) {
            int i = 0;

            while (messageConsumed &&  i<message.length) {
                this.message = message[i];
                printMessage("produced message:" + this.message);
                messageProduced = true;
                messageConsumed = false;
                i++;
                notify();
                try {
                    printMessage("waiting for consumer to consume message");
                    wait();
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
            printMessage("finished");
            this.message =  null;
            notify();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Message message = new Message();
        Thread consumer = new Thread(() -> {
            message.consumer();
        }, "consumer");
        consumer.start();
        Thread producer = new Thread(() -> {
                message.producer(Constants.stringArray);
        }, "producer");
        producer.start();
    }
}
