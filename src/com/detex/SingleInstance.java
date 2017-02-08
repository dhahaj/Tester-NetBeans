/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.detex;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dmh
 */
public class SingleInstance {

  private File f;
  private FileChannel channel;
  private FileLock lock;
  private boolean locked;

  /**
   *
   */
  public SingleInstance() {
    locked = false;
  }

  void start() {
    locked = false;

    f = new File("");
    if (f.exists()) {
      f.delete();
    }

    try {
      channel = new RandomAccessFile(f, "rw").getChannel();
      lock = channel.tryLock();
      if (lock == null) {
        channel.close();
        locked = true;
      }
    } catch (IOException ex) {
      Logger.getLogger(SingleInstance.class.getName()).log(Level.SEVERE, null, ex);
    }

  }

  boolean isLocked() {
    return locked;
  }

  void unlockFile() {
    if (lock != null) {
      try {
        lock.release();
        channel.close();
        f.delete();
      } catch (IOException ex) {
        Logger.getLogger(SingleInstance.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }

}
