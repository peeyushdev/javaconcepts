package multithreading.guardedblock;

public class GuardedBlock {
    static class Greeting {
       volatile boolean greetingRecieved = false;

/*        public synchronized void isHappy()  {
            while (!greetingRecieved) {
                System.out.println("waiting for greeting");
//                try {
//                    Thread.sleep(5000);
//                } catch (InterruptedException interruptedException) {
//                    interruptedException.printStackTrace();
//                }
            }
            *//*
             * example of guarded block as this code will be executed only when greetingRecieved is true*//*
            System.out.println("greeting received happy now");
        }*/


        public synchronized void isHappy() {
            while (!greetingRecieved) {
                try {
                    System.out.println("waiting for greeting");
                    wait();
                } catch (InterruptedException exception) {
                    System.out.println(exception);
                }
            }
            System.out.println("greeting received happy now");
        }

        public synchronized void sendNotification() {
            System.out.println("Sending Greeting");
            this.greetingRecieved = true;
            System.out.println("Greeting sent");
            notifyAll();
        }

        public static void main(String[] args) {
            Greeting greeting = new Greeting();
            new Thread(greeting::isHappy).start();
            new Thread(() -> {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                greeting.sendNotification();
            }).start();

        }
    }
}
