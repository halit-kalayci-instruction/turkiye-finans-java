package org.example;

public class Main extends Thread{
    public static int amount = 0;
    public static void main(String[] args) {
        // Threadler
        // Stream &
        // Lambda Expression
        /*SampleThread sampleThread = new SampleThread();
        sampleThread.start();*/
        Main thread = new Main();
        thread.start();
        System.out.println(amount);
        amount++;
        // thread çalışmış, çalışmamış
        // thread çalıştığı sürece
        while(thread.isAlive()){
            System.out.println("Threadin bitmesi bekleniyor...");
        }

        System.out.println(amount);
    }

    @Override
    public void run() {
        amount++;
    }
}