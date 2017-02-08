/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.detex;


/**
 * Enumeration of the V40 models.
 *
 * @author dmh
 */
public enum Models {
  EHxR(1), EH(2), EBxW(3), EB(4), EHxRxLBM(5), EHxLBM(6), EBxLBM(7), EA(8), EBxW_L9SI(9), EH_L9SI(10);

  /**
   * String containing the part number and name for this model.
   */
  String part;

  /**
   * Boolean variable which describe the features for each model.
   */
  boolean hasRelay = true,
      hasMolex = false,
      hasAC = true,
      hasDC = true,
      hasJack = false,
      hasRemote = true,
      hasWires = false,
      hasPad = true;

  // Sets the vairables for the different model types.
  Models(int i) {
    // this.part = "104010-" + Integer.toString(this.ordinal()+1) +' '+ this.name();
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
        hasWires = true;
        hasAC = false;
        break;
      case 10: // EH L9SI selected
        hasRelay = false;
        hasDC = false;
        break;
    }
  }

  Models getModel(String part) {
    int position = part.length() - 1;
    return Models.valueOf(part);
    /*    switch (position) {
      case 1:
        return Models.valueOf(part);
      case 2:
       return Models.valueOf(part);
      case 1:
 return Models.valueOf(part);
      case 1:
return Models.valueOf(part);
      case 1:
        return Models.valueOf(part);
        EHxR;
        return Models.valueOf(part);
      case 1:
        EHxR;
        break;
      case 1:
        EHxR;
        break;
    }*/
  }

}
