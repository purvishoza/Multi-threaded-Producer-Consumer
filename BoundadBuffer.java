/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javathread;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author kusha
 */
public class BoundadBuffer implements Buffer{

    private final int[] buffer = {0, 0, 0, 0, 0};
   // private int occupiedslot = 0;
    private int writeindex;
    private int readindex;
    //private int sum = 0;
    
    @Override
    public synchronized void blockingPut(int value, int location) {
        while (buffer[location] > 100)
        {
            System.out.println("Slot is full. Producer waits.\n");
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(BoundadBuffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        writeindex = location;
        //System.out.println(writeindex + "\t" + value);
        //System.out.println(buffer[writeindex]);
        
        
       /* if(buffer[writeindex] == 0 )
        {
        buffer[writeindex] = value;
        //sum = sum + value;
        System.out.println(Thread.currentThread().getName() + " produced\t" + value + "on slot\t" + writeindex);
        System.out.println("Total value on" + writeindex + " = " + buffer[writeindex]);
        }*/
       
        if(buffer[writeindex] <= 100)
        {
            //sum = sum + value;
            buffer[writeindex] = buffer[writeindex] + value;
            System.out.println(Thread.currentThread().getName() + " produced\t" + value + "on slot\t" + writeindex);
            System.out.println("Total value on" + writeindex + " = " + buffer[writeindex]);
            
        }
        else
        {
            System.out.println("Slot is full can not add more item ");
            
        }
        //writeindex  = (writeindex + 1 )% buffer.length;
        
        //++occupiedslot;
         
        //System.out.println("Producer occupied slot" + occupiedslot);
        
        notifyAll();
    }

    @Override
    public synchronized void blockingGet(int value, int location) {
        while(buffer[location] == 0)
        {
            System.out.println(location + "  is Empty. Consumer wait.");
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(BoundadBuffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        readindex = location;
        //int readvalue = value;
        
        /* if(buffer[readindex] == 0)
        {
            System.out.println("There is no value on the slot");
            try {
                Thread.sleep(5);
            } catch (InterruptedException ex) {
                Logger.getLogger(BoundadBuffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        } */
        if(buffer[readindex] != 0 && buffer[readindex] >= value)
        {
            System.out.println(Thread.currentThread().getName()+ "\tconsume\t" + value + "\tfrom slot\t" + readindex);
            int readvalue = buffer[readindex] - value;
            //buffer[readindex] = readvalue;
            buffer[readindex] = readvalue;
            System.out.println("Item on slot" + readindex + "=" + buffer[readindex]);
        }
        else
        {
            System.out.println("Can not consume"+ value+ "from slot" + buffer[readindex]);
        }
        //readindex = (readindex + 1 ) % buffer.length;
        //--occupiedslot;
        notifyAll();
        
        //return readvalue;
        
    }
    
    
}
