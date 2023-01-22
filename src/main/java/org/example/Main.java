package org.example;

import java.util.*;

public class Main {
    public static final List<Integer>pointsInCircle = new ArrayList<>();
    public static void main(String[] args){
        int PointsTotal = 100000000;
        int threadsNumber = 11;
        long startTime = System.currentTimeMillis();
        List<Thread> threads = new ArrayList<>();
        for(int i = 0; i < threadsNumber; i++){
            threads.add(new Thread(new PiFinder(PointsTotal/threadsNumber)));
            threads.get(i).start();
        }

        try{
            for(Thread thread : threads)
                thread.join();
        } catch (InterruptedException e){}

        int totalPointsInCircle = pointsInCircle.stream().reduce(0, Integer::sum);
        double PI = 4.0*totalPointsInCircle/PointsTotal;
        System.out.println("PI: " + PI);
        System.out.println("Execute time: " + (System.currentTimeMillis() - startTime) + "ms");
    }
}