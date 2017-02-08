/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.detex;

import java.awt.*;
import java.io.File;
import static java.lang.System.out;

/**
 *
 * @author dmh
 */
public class Main {

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
		out.println(new File("").getAbsolutePath());
		EventQueue.invokeLater(new Runnable() {
		@Override
		public void run () {
				// Configuration.loadUsers();
				InterfaceGUI gui = new InterfaceGUI();
				gui.setEnabled(true);
				gui.setVisible(true);
		}
		});

		System.out.println("F You");
		System.exit(0);
}

}
