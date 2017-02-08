/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snippets;


import java.io.*;
import java.nio.charset.*;
import java.nio.file.*;


/**
 * Checks for the existence of a directory or a file.
 * Alternatively it can list files in a directory or read contents of a file.
 *
 * @author dmh
 */
public class FileDirExistence {

  static String dir;

  public FileDirExistence() {
  }

  static boolean directoryExists(String path) {
    File f = new File(path);
    return f.exists();
  }

  static String getFileName() {
    return null;
  }

  static Path getPath(String s) {
    return Paths.get(s);
  }

  static boolean fileExists(String path) {
    File f = new File(path);
    return f.exists();
  }

  static BufferedReader readFile(String path, String name) throws IOException {
    Path path1 = Paths.get(path + "/" + name);
    BufferedReader br = Files.newBufferedReader(path1, StandardCharsets.UTF_8);
    return br;
  }

  static void getConfiguration(String name) {

  }

}
