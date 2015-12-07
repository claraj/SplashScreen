package com.clara;

import javax.swing.*;
import java.awt.*;

/**
 * Created by admin on 12/7/15.
 */
public class MyGUI extends JFrame {
    private JPanel panel1;

    MyGUI() {
        setContentPane(panel1);

        setPreferredSize(new Dimension(500, 500));
        setLocation(300, 300);

        pack();
        setVisible(true);


    }
}
