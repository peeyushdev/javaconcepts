package multithreading.guardedblock;

public class GuardedBlock {
    static class Greeting{
        boolean greetingRecieved = false;
        public void isHappy(){
            while(!greetingRecieved);
            /*
            * example of guarded block as this code will be executed only when greetingRecieved is true*/
            System.out.println("greeting received happy now");
        }
    }
}
