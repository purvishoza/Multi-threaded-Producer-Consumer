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
public interface Buffer {
    
    /**
     *
     * @param value
     * @param location
     */
    public void blockingPut(int value, int location);
    
    public void blockingGet(int value, int location);
}
