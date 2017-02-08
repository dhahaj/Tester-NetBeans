package com.detex;

import java.io.Serializable;
import java.util.logging.*;

/**
 * Class for Users of the tester.
 *
 * @author dmh
 * @version 2.0.1
 */
public class User implements Serializable {

private static final long serialVersionUID = -7641865732502498527L;
static final int PASSED_CNT = 0;
static final int FAILED_CNT = 1;
static final int PROG_CNT = 2;
static final int TOTAL_CNT = 3;
public String username = null;
private String password = null;
private boolean admin = false;
private int passed_count = 0;
private int failed_count = 0;
private int pgm_count = 0;
private int total_count = 0;

/**
 * Constructors
 *
 * @param username
 *                 User's login name
 * @param password
 *                 User's password
 */
User (String username, String password) {
		this.username = username;
		this.password = password;
		this.admin = false;
}

/**
 * Constructors
 *
 * @param username
 *                 User's login name
 * @param password
 *                 User's password
 * @param admin
 *                 Administrative privileges
 */
User (String username, String password, boolean admin) {
		this.username = username;
		this.password = password;
		this.admin = admin;
}

public void incrementCount (int which) {
		switch (which) {
		case PASSED_CNT:
				this.passed_count++;
				break;
		case FAILED_CNT:
				this.failed_count++;
				break;
		case PROG_CNT:
				this.pgm_count++;
				break;
		case TOTAL_CNT:
				this.total_count++;
				break;
		}
}

public int getCount (int which) {
		switch (which) {
		case PASSED_CNT:
				return this.passed_count;
		case FAILED_CNT:
				return this.failed_count;
		case PROG_CNT:
				return this.pgm_count;
		case TOTAL_CNT:
				return this.total_count;
		}
		return 0;
}

@Override
public String toString () {
		return this.username + " " + this.password;
}

public boolean isAdmin () {
		return this.admin;
}

public String getName () {
		return this.username;
}

/**
 * Verify the password for a given user.
 *
 * @param p
 *          The password to check (ignores case).
 *
 * @return True if the password matches this users password.
 */
public boolean checkPassword (String p) {
		return p.equalsIgnoreCase(this.password);
}

/**
 * Logs a user out. Just log information on the stats of the current user
 * and reset their values;
 * <p>
 */
void quit () {
		Logger.log(Level.INFO, username + " logged off");
}

}

//import java.io.Serializable;
//import java.util.ArrayList;
//
//
///**
// * Class that holds and maintains data for every user of the software.
// *
// * @author dmh
// */
//class User implements Serializable {
//
//  private static final long serialVersionUID = -7641865726502498527L;
//  static final int PASSED_CNT = 0, FAILED_CNT = 1, PROG_CNT = 2, TOTAL_CNT = 3;
//  public String username = null;
//  private String password = null;
//  private boolean admin = false;
//  private int passed_count = 0, failed_count, pgm_count = 0, total_count = 0;
//  final String[][] UserList = {{"ASG", "AG2012"}, {"BTA", "1419"},
//  {"CKP", "3235"}, {"DEM", "1234"}, {"EMD", "0138"}, {"IGR", "IZZYGLEN"},
//  {"MA", "0325"}, {"MLL", "LULU"}, {"MVG", "3-27-5-30"}, {"RLP", "1959"},
//  {"SLT", "1812"}, {"DMH", "D853"}, {"TCM", "PINZ"}, {"GUEST", "GUEST"},
//  {"AHF", "1964"}, {"SRH", "071520006"}};
//
//  /**
//   * Default Constructor for a standard (non-administrator) user
//   *
//   * @param username
//   * @param password
//   */
//  User(String username, String password) {
//    this.failed_count = 0;
//    this.username = username;
//    this.password = password;
//    this.admin = false;
//  }
//
//  /**
//   * Default Constructor for administer users.
//   *
//   * @param username
//   * @param password
//   * @param admin
//   */
//  User(String username, String password, boolean admin) {
//    this.failed_count = 0;
//    this.username = username;
//    this.password = password;
//    this.admin = admin;
//  }
//
//  public void incrementCount(int which) {
//    switch (which) {
//      case PASSED_CNT:
//        this.passed_count++;
//        break;
//      case FAILED_CNT:
//        this.failed_count++;
//        break;
//      case PROG_CNT:
//        this.pgm_count++;
//        break;
//      case TOTAL_CNT:
//        this.total_count++;
//        break;
//    }
//  }
//
//  public int getCount(int which) {
//    switch (which) {
//      case PASSED_CNT:
//        return this.passed_count;
//      case FAILED_CNT:
//        return this.failed_count;
//      case PROG_CNT:
//        return this.pgm_count;
//      case TOTAL_CNT:
//        return this.total_count;
//    }
//    return 0;
//  }
//
//  @Override
//  public String toString() {
//    return this.username + " " + this.password;
//  }
//
//  public boolean isAdmin() {
//    return this.admin;
//  }
//
//  public String getName() {
//    return this.username;
//  }
//
//  /**
//   * Verifies the password for a given user.
//   *
//   * @param p The password to check (ignores case).
//   *
//   * @return True if the password matches this users password.
//   */
//  public boolean checkPassword(String p) {
//    return p.equalsIgnoreCase(this.password);
//  }
//
//  public ArrayList<String> getUsers() {
//    Object[] data = readData();
//    ArrayList<String> arrayList;
//    arrayList = new ArrayList<>();
//    for (Object data1 : data) {
//      try {
//        arrayList.add(((User) data1).getName());
//      } catch (Exception ex) {
//        if (DEBUG) {
//          System.err.println("exception");
//        }
//      }
//    }
//    return arrayList;
//  }
//
//}
