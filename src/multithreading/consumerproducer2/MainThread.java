package multithreading.consumerproducer2;

import multithreading.constants.Constants;

public class MainThread {
    public static void main(String[] args) {
        Data data = new Data();
        new Thread(()->{
            while(!(data.message=="DONE")){
                data.pullMessage();
            }
        },"consumer").start();

        new Thread(()->{
            for(String str: Constants.stringArray){
                data.pushMessage(str);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
            data.pushMessage("DONE");
        },"producer").start();
    }
}
