/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interruptedthreadsbuffer;

/**
 *
 * @author Admin
 */
public class InterruptedThreadsStart {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InterruptBuffer buffer = new InterruptBuffer();
        Thread[] producers = new Thread[] {
            new Thread(new InterruptedProducer(1, buffer)),
            new Thread(new InterruptedProducer(1000, buffer)),
            new Thread(new InterruptedProducer(100500, buffer)),
        };
        for (Thread producer: producers) {
            producer.start();
        }
        
        Thread[] consumers = new Thread[] {
            new Thread(new InterruptedConsumer(buffer)),
            new Thread(new InterruptedConsumer(buffer))
        };
        
        for (Thread consumer : consumers) {
            consumer.start();
        }
    }
    
}
