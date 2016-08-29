package com.dumbpug.spriteanimationviewer.desktop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.Texture;
import com.dumbpug.spriteanimationviewer.Viewer;

import java.io.File;

public class DesktopLauncher {

	public static void main (String[] arg) {
        // Ensure we have the correct number of command line arguments.
        if(arg.length != 4) {
            System.out.println("usage: savi <path> <columns> <rows> <fps>");
            return;
        }

		// Check that the specified sprite-sheet exists.
        if(!new File(arg[0]).exists()) {
            System.out.println("error: sprite-sheet does not exist.");
        }

        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        new LwjglApplication(new Viewer(), config);
	}
}
