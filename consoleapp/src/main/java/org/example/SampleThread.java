package org.example;

public class SampleThread extends Thread{
    @Override
    public void run() {
        System.out.println("Farklı bir threadden merhaba!");
    }
}
