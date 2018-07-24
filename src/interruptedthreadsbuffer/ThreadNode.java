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
class ThreadNode {

    public final Thread value;
    public final ThreadNode next;
    
    public ThreadNode (Thread value, ThreadNode next) {
        this.value = value;
        this.next = next;
    }
    
}
