/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.awt.EventQueue;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;

/**
 *
 * @author ESCOBAR
 */
public class HiloPasos extends Thread{
    JProgressBar barra;
    private static  int retraso=300;

    public HiloPasos(JProgressBar barra) {
        this.barra = barra;
    }

    

    @Override
    public void run() {
       int minimo=barra.getMinimum();
       int maximo=barra.getMaximum();
       
       Runnable ejecutor=new Runnable() {

           @Override
           public void run() {
               int  valoractual=barra.getValue();
               barra.setValue(valoractual+1);
               
           }
       };
       for(int i=minimo;i<maximo;i++)
       {
           try {
               EventQueue.invokeAndWait(ejecutor);
                Thread.sleep(retraso);
           } catch (InterruptedException ex) {
               
           } catch (InvocationTargetException ex) {
              
           }
           
       }
        
    }
      }
   
    
    
    

