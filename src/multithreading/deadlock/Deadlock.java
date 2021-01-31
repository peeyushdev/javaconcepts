package multithreading.deadlock;

public class Deadlock {
    static class Friend {
        private final String name;

        public Friend(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public synchronized void bow(Friend bower) {
            System.out.format("%s: %s"
                            + "  has bowed to me!%n",
                    this.name, bower.getName());
            bower.bowBack(this);
            System.out.println("done");
        }

//      this also caused deadlock but exactly before line 26.
        public void bowBack(Friend bower) {
            System.out.println("Inside Method");
            synchronized (this) {
                System.out.format("%s: %s"
                                + " has bowed back to me!%n",
                        this.name, bower.getName());
            }
        }

        /*
//         Causes Deadlock
        public synchronized void bowBack(Friend bower) {

            System.out.format("%s: %s"
                            + " has bowed back to me!%n",
                    this.name, bower.getName());
        }*/
    }

    public static void main(String[] args) {
        final Friend peeyush =
                new Friend("peeyush");
        final Friend sahitya =
                new Friend("sahitya");
        new Thread(() -> peeyush.bow(sahitya)).start();
        new Thread(() -> sahitya.bow(peeyush)).start();
    }
}
/*
 * Here Thread-0 calls bow() on peeyush object and at the same time Thread-1 calls bow() sahitya object
 * Both the thread after executing line 18 gets blocked for any of the synchronised method to execute completely
 * before they can start executing method bower.*/