package com.detex;


/**
 * <strong>Device Class</strong>
 *
 * @author dmh
 */
public class Device {

  public final Devices device;

  String name = null;
  Boolean hasModel = false;
  Models model = null;

  /**
   * Constructor
   *
   * @param d The device name pass as a string.
   */
  Device(String d) {
    device = Devices.valueOf(d); //valueOf(d).name();
    name = device.toString();
    if (device == Devices.V40)
      this.hasModel = true;
  }

}
