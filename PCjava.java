/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javathread;
/**
 *
 * @author kusha
 */
public class PCjava {
    
    public static  void main(String[] args) throws InterruptedException
    {   
        BoundadBuffer sharedlocation  = new BoundadBuffer();
        
        Thread t = new Thread(new Producer(sharedlocation),"Producer1");
        Thread t2 = new Thread(new Producer(sharedlocation),"Producer2");
        Thread t3 = new Thread(new Producer(sharedlocation),"Producer3");
        
        Thread c1 = new Thread(new Consumer(sharedlocation), "consumer1");
        Thread c2 = new Thread(new Consumer(sharedlocation),"consumer2");
        
        t.start();
        t2.start();
        t3.start();
        
        c1.start();
        c2.start();
    }
}
