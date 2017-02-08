package com.detex;

import java.io.*;
import java.util.*;

class Configuration {

private static Properties PROPERTIES = null; //new Properties();
static Scanner scanner = null;
private static InputStream input = null;
private static final String resourceFolder = "resources";
private static final String fileName = "config.properties";
private static String configPath;
public static String firmwareFolder;
public static String instructionFolder;
public static String userConfig;
public static List<User> users = new ArrayList<User>();

public Configuration (String fileName) {
		String path = new File("").getAbsolutePath();
		Configuration.configPath = path + File.separator + resourceFolder + File.separator + fileName;
}

static {
		PROPERTIES = new Properties();
		String path = new File("").getAbsolutePath();
		Configuration.configPath = path + File.separator + resourceFolder + File.separator + fileName;
		try {
				scanner = new Scanner(new FileReader(path + File.separator + resourceFolder + File.separator + "users.config"));
		} catch (FileNotFoundException ex) {
		}
}

static List<User> loadUsers () {
		HashMap<String, String> map = new HashMap<String, String>();
		while (scanner.hasNext()) {
				String[] col = scanner.nextLine().split(" ");
				User u = new User(col[0], col[1]);
				System.out.println(u.toString());
				users.add(u);
		}
		return users;
}

static void loadConfig (String name) {

		/*try {
      System.out.println(configPath);
      input = new FileInputStream(configPath);
      PROPERTIES.load(input);
      List<String> names = new ArrayList<String>();
      names.add("dmh");
      PROPERTIES.putIfAbsent("users", names.get(0));
      System.out.println(PROPERTIES.getProperty("firmwareFolder", "No Entry"));
      System.out.println(PROPERTIES.getProperty("users", "No Entry"));

      StringWriter writer = new StringWriter();
      BufferedWriter bw = new BufferedWriter(writer);
      bw.write("dmh");

      PROPERTIES.store(bw, "");
      writer.close();
      bw.close();
      // TODO: Set the properties
    } catch (IOException e) {
    } finally {
      if (input != null) {
        try {
          input.close();
        } catch (IOException e) {
          System.err.println(e.toString());
        }
      }
    }*/
}

static void storeProperties () {

}

static String getProperty (String property) {
		String p = null;
		try {
				if (input == null)
						try {
								input = new FileInputStream(fileName);
						} catch (FileNotFoundException e) {
								System.err.println(e.toString());
								return p;
						}

				p = PROPERTIES.getProperty(property);
		} finally {
				if (input != null)
						try {
								input.close();
						} catch (IOException e) {
								System.err.println(e.toString());
						}
		}
		return p;
}

}
