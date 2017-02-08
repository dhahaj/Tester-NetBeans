/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.detex;

import com.sun.org.apache.xerces.internal.util.URI;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.*;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import org.apache.commons.io.*;

/**
 * <strong>Main Class for the testing interface</strong>
 *
 * @version 2.0
 * @author dmh
 */
public class TesterInterface {

User user = null;
Device device = null;
static final int ACRELAY = 9, BAT_EN = 4, LOW_BAT = 2, DOOR = 6, REMOTE = 5, TEST_MODE = 3, OKC = 8, RELAYIN = 7;
final int outputs[] = {ACRELAY, BAT_EN, BAT_EN, LOW_BAT, DOOR, REMOTE, TEST_MODE, OKC};
final int inputs[] = {RELAYIN};

/**
 * Confirms exiting by opening a dialog window.
 */
void confirmExit () {
		try {
				SwingUtilities.invokeAndWait(() -> {
						int choice = JOptionPane.showConfirmDialog(null, "Exit?", "Confirm Exit", JOptionPane.YES_NO_OPTION);
						if (choice != JOptionPane.YES_OPTION)
								return;

						if (user != null)
								Logger.log(Level.INFO, "");
						else
								Logger.log(Level.INFO, "Tester Interface Shutting Down.");
						user.quit();
						System.exit(0);
				});
		} catch (InterruptedException | InvocationTargetException ex) {
				java.util.logging.Logger.getLogger(TesterInterface.class.getName()).log(Level.SEVERE, null, ex);
		}
}

void program () {
		// TODO: call batch file for programing
}

/**
 * Main thread
 *
 * @param args the command line arguments
 */
public static void main (String args[]) {
		/* Set the Nimbus look and feel */
		try {
				for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
						if ("Nimbus".equals(info.getName())) {
								javax.swing.UIManager.setLookAndFeel(info.getClassName());
								break;
						}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
				java.util.logging.Logger.getLogger(InterfaceGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
		@Override
		public void run () {
				// Configuration.loadConfig("config.properties");
				// Configuration.loadUsers();
				try {
						String s = new File("").getAbsolutePath();
						String ps = FileUtils.getUserDirectoryPath();
						ps = ps.replace("\\", "/");
						System.out.println(ps);
						URI uri = new URI(ps);
						String p = uri.getPath();
						System.out.println(p);
				} catch (URI.MalformedURIException ex) {
						ex.printStackTrace();
				}
				InterfaceGUI gui = new InterfaceGUI();
				gui.setVisible(true);

		}
		});
}

}
