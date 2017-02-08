/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.detex;

import java.awt.Component;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author dmh
 */
public class RunProgram {

    private Device device;
    private Firmware program;

    /**
     * Constructor
     *
     * @param device
     */
    public RunProgram(Device device) {
        this.device = device;
        program = Device.valueOf(device.toString());
    }

    boolean doProgram() {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Runtime runtime = Runtime.getRuntime();
                Process process = null;
                try {
                    process = runtime.exec("");
                    process.waitFor();
                } catch (Exception ex) {
                    Logger.getLogger(RunProgram.class.getName()).log(Level.SEVERE, null, ex);
                }  
                
                short exitValue = (short)(process.exitValue());
                if(process.exitValue()!=0){
                    try {
                        JOptionPane.showMessageDialog((Component) super.getClass().newInstance(), device, "Error", exitValue);
                    } catch (InstantiationException ex) {
                        Logger.getLogger(RunProgram.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(RunProgram.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        runnable.run();
        return true;
    }
        
        
     
}

