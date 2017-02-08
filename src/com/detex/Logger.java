/*
 * Logger.java
 * Handles log file operations and logging information
 *
 * @author dmh
 * @version 2.0.1
 */
package com.detex;


import java.io.*;
import java.util.logging.*;


class Logger {

  private static FileHandler fileHandler = null;
  private static SimpleFormatter formatterTxt;
  //  private static FileHandler fileHTML;
  private static Formatter formatterHTML;
  public static String FilePath;
  private static final boolean Append = true;
  private static final String logFileName = "Log.txt";
  private static String User = null;

  /**
   * The local folder which holds old log files.
   */
  public static final String Archive_Folder_Name = "logArchive";
  public static String Archive_Folder_Path;

  /**
   * Default Constructor
   */
  Logger() {
    // Setup the file path and the log archive path
    FilePath = new File("").getAbsolutePath();
    Archive_Folder_Path = FilePath + Archive_Folder_Name;
    init();
  }

  /**
   * Initializes the log file handler.
   */
  private void init() {
    try {
      fileHandler = new FileHandler(logFileName, Append);
    } catch (IOException | SecurityException ex) {
      java.util.logging.Logger.getLogger(Logger.class.getName()).log(Level.SEVERE, null, ex);
      ex.printStackTrace();
    }

  }

  public void info(String info) {
    // TODO: Implement logging
  }

  /**
   * Publish a log entry
   *
   * @param level the log level
   * @param what  the log entry
   */
  public static void log(Level level, String what) {
    Logger.fileHandler.publish(new LogRecord(level, what));
  }

  public static void setUser(String User) {
    Logger.User = User;
  }

  /**
   * Checks the log date to determine if the log file should be placed into the archive folder.
   *
   * @param fileName The log file name
   */
  private static void checkDate(String fileName) {
    File currentLogFile = new File(fileName);

    if (!currentLogFile.exists()) {
      return;
    }

  }

  /**
   * Checks for a file's existence.
   *
   * @param filename The file's name
   *
   * @return True if it exists.
   */
  static boolean dataFileExists(String filename) {
    File f = new File(filename);
    return f.exists();
  }

}
