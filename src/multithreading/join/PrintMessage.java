package multithreading.join;

import multithreading.constants.Constants;

public class PrintMessage implements Runnable{

    @Override
    public void run() {
        for(String string : Constants.stringArray){
            System.out.println(string);
        }
    }
}
