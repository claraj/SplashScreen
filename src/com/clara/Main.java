package com.clara;

import java.awt.*;

public class Main {

    public static void main(String[] args) {

        //Reference: https://docs.oracle.com/javase/tutorial/uiswing/misc/splashscreen.html
        //Nyan cat from Wikipedia https://en.wikipedia.org/wiki/Nyan_Cat
        //Also useful: http://wiki.netbeans.org/Splash_Screen_Beginner_Tutorial

        /*

        Important: for this to work, you need to Edit the run configuration
        for this project. In IntelliJ, Click on Main (next to the Green play button)
        then select Edit Configurations.
        Add this to the VM options

        -splash:nyan.jpg

        And run the program.
        Replace with the image of your choice, you can use a gif, png or jpg.

        The splash screen is displayed by the JVM before your code runs.
        If your code grabs a reference to the splash screen, you can load things
        in the background, or display an animation or messages on the screen
        Painting works by gettting a Graphics2D object, and requesting that it
        draws strings, rectangles etc in the window.

        */

     //   MyGUI gui = new MyGUI();
     //   gui.setVisible(false);   //hide while loading!

        final SplashScreen splash = SplashScreen.getSplashScreen();

        if (splash != null) {

            //splash will be null if the picture provided in the VM options is
            //not found, or if there are other problems displaying the splash screen.
            //So you don't want anything critical here, or your should check to make
            //sure all of the loading/config did happen

            System.out.println("Configure the splash screen");

            Graphics2D g = splash.createGraphics();

            //Pretend to be loading stuff
            //TODO actually load stuff, like connect to DB etc.

            System.out.println("Loading...");

            Color colors[] = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.MAGENTA};

            g.setComposite(AlphaComposite.Clear);
            g.fillRect(120, 140, 200, 40);
            g.setPaintMode();

            for (Color c : colors) {
                    g.setFont(new Font("Arial", Font.BOLD, 18));
                    g.setColor(c);
                    g.drawString("Welcome!", 120, 180);
                    splash.update();

                    try {
                        Thread.sleep(1000);   //Sleep for 1 seconds
                                              //Maybe you want the splash screen to pause so users can see a picture or some message
                                            //Or, you would not sleep - you'd load stuff the remove splash screen as soon as it was loaded.
                    } catch (InterruptedException e) {
                        //whatever
                    }
                }

            System.out.println("Loading done");

            splash.close();   //What it sounds like
        }


        //Now your code starts....

        MyGUI gui = new MyGUI();

    }
}
