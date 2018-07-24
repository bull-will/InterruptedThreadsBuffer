/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interruptedthreadsbuffer;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class InterruptedProducer implements Runnable {

    private int startValue;
    private final InterruptBuffer buffer;

    public InterruptedProducer(int startValue, InterruptBuffer buffer) {
        this.startValue = startValue;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(startValue + " produced");
                buffer.put(startValue++);
                Thread.sleep((int) (1000 * Math.random()));
            } catch (InterruptedException ex) {
                return;
            }
        }

    }
}