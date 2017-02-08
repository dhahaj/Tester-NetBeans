/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.detex;

/**
 * An enumeration of all the available firmwares for a device, categorized by
 * device and indexed by order.
 *
 * @author dmh
 */
public abstract class Firmware {

    final Devices device;

    private Firmware() {
        this.device = null;
    }

    public Firmware(Devices device) {
        this.device = device;
    }
}