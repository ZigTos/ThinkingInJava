package com.company.concurrency;//: concurrency/DaemonsDontRunFinally.java
// Daemon threads don't run the finally clause 908
import java.util.concurrent.*;

import static com.company.net.mindview.util.Print.print;

class ADaemon implements Runnable {
  public void run() {
    try {
      print("Starting ADaemon");
      TimeUnit.SECONDS.sleep(1);
    } catch(InterruptedException e) {
      print("Exiting via InterruptedException");
    } finally {
      print("This should always run?");
    }
  }
}

public class DaemonsDontRunFinally {
  public static void main(String[] args) throws Exception {
    Thread t = new Thread(new ADaemon());
    t.setDaemon(true);
    t.start();
    TimeUnit.MILLISECONDS.sleep(1000);
  }
} /* Output:
Starting ADaemon
*///:~
