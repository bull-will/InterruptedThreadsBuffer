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
public class InterruptBuffer {

    private ThreadNode producers = null;
    private ThreadNode consumers = null;
    private Integer elem = null;

    public synchronized void put(int newElem) {
        while (elem != null) {
            try {
                producers = new ThreadNode(Thread.currentThread(), producers);
                this.wait();
            } catch (InterruptedException ex) {
                // NOP
            }
        }
        elem = newElem;
        if (consumers != null) {
            Thread consumerToWake = consumers.value;
            consumers = consumers.next;
            consumerToWake.interrupt(); // rewrite
        }
    }

    public synchronized int get() {
        while (elem == null) {
            try {
                consumers = new ThreadNode(Thread.currentThread(), producers);
                this.wait();
            } catch (InterruptedException ex) {
                // NOP
            }
        }
        int result = elem;
        elem = null;
        if (producers != null) {
            Thread producerToWake = producers.value;
            producers = producers.next;
            producerToWake.interrupt(); // rewrite
        }
        return result;
    }
}
