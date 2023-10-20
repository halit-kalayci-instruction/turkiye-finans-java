package org.example;

import java.util.ArrayList;
import java.util.function.Consumer;

public class Main extends Thread{
    public static int amount = 0;
    public static void main(String[] args) {
        // Threadler
        // Stream &
        // Lambda Expression
        /*SampleThread sampleThread = new SampleThread();
        sampleThread.start();*/
        /*Main thread = new Main();
        thread.start();
        System.out.println(amount);
        amount++;
        // thread çalışmış, çalışmamış
        // thread çalıştığı sürece
        while(thread.isAlive()){
            System.out.println("Threadin bitmesi bekleniyor...");
        }

        System.out.println(amount); */
/*
        for(int i=1; i<=3; i++){
            SampleThread sampleThread = new SampleThread(i);
            Thread thread = new Thread(sampleThread);
            thread.start();
        }
*/

        // Lambda Expression

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(6);
        numbers.add(9);

        ArrayList<Integer> numbers2 = new ArrayList<>();
        numbers2.add(3);
        numbers2.add(5);
        numbers2.add(7);

        Consumer<Integer> method = (number) -> {
            System.out.println(number);
        };

        numbers.forEach(method);
        numbers2.forEach(method);

    }

    @Override
    public void run() {
        amount++;
    }
}
//