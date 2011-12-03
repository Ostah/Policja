/*
 * Copyright 2007-2008 Sun Microsystems, Inc.  All Rights Reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Sun Microsystems nor the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

//package com.sun.swingset3.demos.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
//import com.sun.swingset3.DemoProperties;
//import com.sun.swingset3.demos.DemoUtilities;



public class FrameDemo extends JPanel {
    //Ensure system menubar is used on Mac OSX
    static {
        // Property must be set *early* due to Apple Bug#3909714
        // ignored on other platforms
        if (System.getProperty("os.name").equals("Mac OS X")) {
            System.setProperty("apple.laf.useScreenMenuBar", "true");
        }
    }
 
    private JFrame frame;

    private JComponent frameSpaceholder;

    public FrameDemo() {
        initComponents();
    }

    protected void initComponents() {
        frame = createFrame();
        setLayout(new BorderLayout());
    }


    private static JComponent createFrameSpaceholder(JFrame frame) {
        JPanel framePlaceholder = new JPanel();
        Dimension prefSize = frame.getPreferredSize();
        prefSize.width += 12;
        prefSize.height += 12;
        framePlaceholder.setPreferredSize(prefSize);
        return framePlaceholder;
    }

    private static JFrame createFrame() {
        JFrame frame = new JFrame("Policja");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


       
        Image iconImage = null;
        try {
            URL imageURL = FrameDemo.class.getResource("resources/2899.gif");
            iconImage = ImageIO.read(imageURL);
        } catch (Exception e) {
            e.printStackTrace();
        }
        frame.setIconImage(iconImage);
 

        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);
        JMenu menu = new JMenu("File");
        menu.add("Open");
        menu.add("Save");
        menubar.add(menu);
      

        JToolBar toolbar = new JToolBar();
        toolbar.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.add(toolbar, BorderLayout.NORTH);  
        toolbar.add(new JButton("Katalog Osób"));
        Dimension odstep = new Dimension(50,10);
        toolbar.addSeparator(odstep);   
        toolbar.add(new JButton("Katalog Pojazdów"));
        toolbar.addSeparator(odstep);
        toolbar.add(new JButton("Mandaty"));
        toolbar.addSeparator(odstep);
        toolbar.add(new JButton("ZnajdŸ auto"));

        JPanel window = new JPanel();
        window.setBackground(new Color(250,0,0));
        window.setVisible(true);
        frame.add(window);
//        JLabel label = new JLabel("I'm content but a little blue.");
//        label.setHorizontalAlignment(JLabel.CENTER);
//        label.setPreferredSize(new Dimension(300, 160));
//        label.setBackground(new Color(266, 216, 236));
//        label.setOpaque(true); // labels non-opaque by default
//        frame.add(label);

        JLabel statusLabel = new JLabel("I show status.");
        statusLabel.setBorder(new EmptyBorder(4, 4, 4, 4));
        statusLabel.setHorizontalAlignment(JLabel.LEADING);
        frame.add(statusLabel, BorderLayout.SOUTH);

        //frame.pack();
        frame.setExtendedState(frame.getExtendedState()|JFrame.MAXIMIZED_BOTH);

        return frame;
    }

    public void start() {
        showFrame();
    }

    public void stop() {
        frame.setVisible(false);
    }

    public void showFrame() {
        if (frame.isShowing()) {
            frame.toFront();
        } else {
            frame.setVisible(true);
        }
    }


    private class ShowActionListener implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {
            showFrame();
        }
    }


}
