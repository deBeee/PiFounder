package org.example;

import java.util.Random;

public class PiFinder implements Runnable {
    private int pointsNumber;
    public PiFinder() {
    }
    public PiFinder(int pointsNumber) {
        this.pointsNumber = pointsNumber;
    }

    @Override
    public void run() {
        Random rand = new Random();
        int pointsCircle = 0;
        for(int i = 0; i < this.pointsNumber; i++){
            float x = rand.nextFloat() * 2 - 1;
            float y = rand.nextFloat() * 2 - 1;
            if(Math.sqrt(Math.pow(x,2)+Math.pow(y,2)) < 1) pointsCircle++;
        }
        Main.pointsInCircle.add(pointsCircle);
    }
}
