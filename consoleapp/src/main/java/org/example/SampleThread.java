package org.example;

public class SampleThread implements Runnable{
    private int number;

    public SampleThread(int number) {
        this.number = number;
    }


    @Override
    public void run() {
        for (int i=1; i<=5; i++){
            System.out.println(i + ". sayı " +
                    number + ". threadden gönderildi.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
        }
    }
}
