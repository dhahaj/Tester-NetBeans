/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.detex;


import java.util.*;


/**
 * <strong>Device Enumeration</strong>
 *
 * @author dmh
 */
public enum Devices {

  EAX300, EAX500, EAX2500, V40, EAX3500;

  private String[] names = null;
  private ArrayList<String> s_names = null;
  private int size;

  Devices() {
    size = Devices.values().length;
    int j;
    for (j = 0; j < size; j++)
      names[j] = Devices.values().toString();
    s_names = new ArrayList<String>(size);
  }

  String[] getDeviceNames() {
    return names;
  }
  
  ArrayList<String> getDeviceArray(){
    return s_names;
  }
  
}

/* V40 Models */
 /*static enum Models {

  EHxR(1), EH(2), EBxW(3), EB(4), EHxRxLBM(5), EHxLBM(6), EBxLBM(7), EA(8), EBxW_L9SI(9), EH_L9SI(10);

  String part;

  boolean hasRelay = true, hasMolex = false, hasAC = true, hasDC = true,
      hasJack = false, hasRemote = true, hasWires = false, hasPad = true;

  /**
   * Constructor
   *
   * @param i The x in 104010-x
 *//*
  Models(int i) {
    this.part = "104010-" + i + ' ' + this.name();
    switch (i) {
      case 1: //  EHxR selected
      case 8:  //  EA selected
        hasMolex = true;
        break;
      case 2: //  EH selected
        hasRelay = false;
        break;
      case 3: //  EBxW selected
        hasWires = true;
        hasAC = false;
        break;
      case 7: //  EBxLBM selected
        hasJack = true; // no break, same as EB model
      case 4: //  EB selected
        hasRelay = false;
        hasAC = false;
        break;
      case 5: //  EHxRxLBM selected
        hasMolex = true;
        hasJack = true;
        break;
      case 6: //  EHxLBM selected
        hasRelay = false;
        hasJack = true;
        break;
      case 9: // EBxW L9SI selected
        hasWire = true;
        hasAC = false;
        break;
      case 10: // EH L9SI selected
        hasRelay = false;
        hasDC = false;
        break;
    }
  }

}*/


