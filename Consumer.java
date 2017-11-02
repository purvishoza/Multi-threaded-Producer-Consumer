/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javathread;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kusha
 */
public class Consumer implements Runnable{

    private static  final SecureRandom generator = new SecureRandom();
    private final Buffer sharedlocation;
    
    public Consumer(Buffer  sharedlocation)
    {
        this.sharedlocation = sharedlocation;
    }
    
    
    @Override
    public void run() {
    
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("C:\\Users\\kusha\\Desktop\\file.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
        }
        String str = null;
        
        try {
            while((str = br.readLine())!= null)
            {
                int value, location;
                String s = "c";
                //System.out.println("Enter value and location for item remove");
                //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                
                //String str = null;
                try {
                    str = br.readLine();
                } catch (IOException ex) {
                    Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                String[] token = str.split("\u0020");
                
                value = Integer.decode(token[1]);
                location = Integer.decode(token[2]);
                
                if(token[0].equals(s))
                {
                    try {
                        Thread.sleep(generator.nextInt(1000));
                        sharedlocation.blockingGet(value, location);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
                else
                {
                    /*System.out.println("It is not a Consumer");
                    try {
                    Thread.sleep(5);
                    } catch (InterruptedException ex) {
                    Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
                    }*/
                    continue;
                    //break;
                }
            }   } catch (IOException ex) {
            Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
        }
    
 }
}