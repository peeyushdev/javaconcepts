package multithreading.sleep;


import multithreading.constants.Constants;

/*
* Thread.sleep() is a static method.
* 2 Overloaded methods with one having time in milliseconds and other in nanoseconds
* sleep() throws InterruptedException when any other thread interrupts the current thread while it is on sleep
* max value we can supply to nanosecond is 999999*/
public class threadSleep {
    public static void main(String[] args) throws InterruptedException{
        for(String string : Constants.stringArray){
            System.out.println("Sleep starts: "+System.currentTimeMillis());
            Thread.sleep(4000); //throws InterruptedException // sleep for 4 millisecond
            System.out.println("Sleep ends: "+System.currentTimeMillis());
            System.out.println(string);
        }
    }
}
