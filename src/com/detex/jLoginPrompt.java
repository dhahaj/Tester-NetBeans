/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.detex;

import com.detex.Logger;
import com.sun.org.apache.xerces.internal.util.URI;
import java.awt.Frame;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.*;
import javax.swing.Timer;
import java.nio.file.*;

/**
 * <strong>Opens a login prompt in a separate thread upon program start requiring a
 * user to login.</strong>
 *
 * @author dmh
 */
public class jLoginPrompt extends Thread implements Serializable {

//  private static final long sreialVersionUID = 1L;
boolean DEBUG;
private final String userConfigFile = "users.cfg";
private boolean running;
private boolean loggedIn;
private User thisUser;
private ArrayList<User> userArrayList;
private final String filename = "users.cfg";
private String currentUser;
final static int TOTAL_CNT = 0, FAILED_CNT = 1, PASSED_CNT = 2, PROG_CNT = 3;
private Timer loginTimer;
static Frame f = null;
private String[][] UserList;

void init () {
		ArrayList<User> al = new ArrayList<User>();
		User user = null;
		for (int i = 0; i < UserList.length; i++) {
				if (i == 10 || i == 11)
						user = new User(UserList[i][0], UserList[i][1], true);
				else
						user = new User(UserList[i][0], UserList[i][1], false);
				al.add(user);
		}
		Object[] data = al.toArray();
		storeData(filename, data);
}

/**
 *
 */
public jLoginPrompt () {
		running = false;
		loggedIn = false;
}

/**
 *
 * @param log A Logger Object
 */
public jLoginPrompt (Logger log) {
		running = false;
		loggedIn = false;
}

@Override
public void start () {
		running = true; // Start the run loop
		super.start();
}

private ArrayList<User> loadUsers () {
		String path = userConfigFile;
		Object[] data = readData(filename);
		ArrayList<User> _users = new ArrayList<User>();

		ArrayList<User> arrayList = new ArrayList<User>();
		for (int i = 0; i < data.length; i++) {
				if (DEBUG)
						System.err.println((User) data[i] + "\n");
				try {
						arrayList.add((User) data[i]);
				} catch (Exception ex) {
						if (DEBUG)
								System.err.println("exception loading user files");
				}
		}
		return arrayList;
}

private ArrayList<User> loadUserConfig () throws IOException {
		String path = userConfigFile;
		try {
				if (!dataFileExists(path))
						throw new FileNotFoundException();
		} catch (Exception ex) {
				if (DEBUG)
						System.err.println("User Config File missing.");
		}
		Object[] _data = readData(userConfigFile);
		BufferedReader userConfig = null;
		ArrayList<String> userList;
		userList = new ArrayList<>();
		ArrayList<User> _users = new ArrayList<>();
		Object x;
		try {
				userConfig = new BufferedReader(new FileReader(new File(userConfigFile)));
				while ((x = userConfig.readLine()) != null) {
						if (((String) x).charAt(0) == '#')
								continue;
						if (DEBUG)
								System.out.println(x);
						Object o = x;
						_users.add((User) x);
				}
		} catch (IOException e) {
		} finally {
				userConfig.close();
		}
		return _users;
}

public ArrayList<String> getUsers () {
		Object[] data = readData(filename);
		ArrayList<String> arrayList;
		arrayList = new ArrayList<>();
		for (Object data1 : data)
				try {
						arrayList.add(((User) data1).getName());
				} catch (Exception ex) {
						if (DEBUG)
								System.err.println("exception");
				}
		return arrayList;
}

private void storeData (String filename, Object[] data) throws IOException {
		String path = new File("").getAbsolutePath() + "\\resources\\" + filename;
		FileWriter fw = null;
		try {
				fw = new FileWriter(new File(path));
				for (int i = 0; i < data.length; i++)
						fw.write((String) data[i]);
		} catch (IOException ex) {
		} finally {
				fw.close();
		}
}

private boolean dataFileExists (String path) {
		File f = new File(path);
		return f.exists();
}

private Object[] readData (String filename) {
		java.nio.Buffer b = null;
		Reader reader = null;

		reader = new Reader() {

		@Override
		public int read (char[] cbuf, int off, int len) throws IOException {
				return 0;
		}

		@Override
		public void close () throws IOException {

		}

		};
		ArrayList<String> strings = new ArrayList<String>();
		BufferedReader br = null;
		br = new BufferedReader(reader);
		try {
				String line = br.readLine();
				if (line != null)
						strings.add(line);
		} catch (IOException ex) {
				ex.printStackTrace();
				br = null;
		} finally {
				if (br != null)
						try {
								br.close();
						} catch (IOException ex) {
								ex.printStackTrace();
						}
		}
		return null;
}

}
