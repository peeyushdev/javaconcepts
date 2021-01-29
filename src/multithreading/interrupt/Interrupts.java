package multithreading.interrupt;

import multithreading.constants.Constants;

public class Interrupts {
    public static void main(String[] args) {
        for(String string : Constants.stringArray){
            try{
                Thread.sleep(1000);
            }catch (InterruptedException interruptedException){
                interruptedException.printStackTrace();
            }
            System.out.println(string);
        }
    }
}
