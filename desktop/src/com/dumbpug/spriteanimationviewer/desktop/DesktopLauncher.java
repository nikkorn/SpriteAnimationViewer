package com.dumbpug.spriteanimationviewer.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.dumbpug.spriteanimationviewer.Viewer;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * @author nikolas.howard
 */
public class DesktopLauncher {

	/**
	 * Entry point.
	 * @param arg Command line args.
	 */
	public static void main (String[] arg) {
        // Ensure we have the correct number of command line arguments.
        if(arg.length != 4) {
            System.out.println("usage: savi <path> <columns> <rows> <step>");
            return;
        }

		// Check that the specified sprite-sheet exists.
        if(!new File(arg[0]).exists()) {
            System.out.println("error: sprite-sheet does not exist.");
            return;
        }
        
        int columns;
        try {
        	columns = Integer.parseInt(arg[1]);
        } catch(NumberFormatException nEx) {
        	System.out.println("error: columns must be a number.");
            return;
        }
        
        int rows;
        try {
        	rows = Integer.parseInt(arg[2]);
        } catch(NumberFormatException nEx) {
        	System.out.println("error: rows must be a number.");
            return;
        }
        
        float step;
        try {
        	step = Float.parseFloat(arg[3]);
        } catch(NumberFormatException nEx) {
        	System.out.println("error: step must be a number.");
            return;
        }
        
        // Derive the window size from the  texture size.
        BufferedImage sheet = null;
		try {
			sheet = ImageIO.read(new File(arg[0]));
		} catch (IOException e) {
			System.out.println("error: couldnt read image data from '" + new File(arg[0]).getAbsolutePath() + "'");
			return;
		}
   
        // Make our window to display the animation.
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width  = (int) sheet.getWidth() / columns;
        config.height = (int) sheet.getHeight() / rows;
        config.title  = arg[0];
        new LwjglApplication(new Viewer(arg[0], columns, rows, step), config);
	}
}
