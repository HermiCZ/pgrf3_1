/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.uhk.herman.pgrf3.gui;

import cz.uhk.herman.pgrf3.objects.ChoosedObject;
import cz.uhk.herman.pgrf3.objects.impl.CartesianCube;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;

/**
 *
 * @author Vladimír Herman
 */
public class Gui implements ActionListener {

    JOGLApp app;
    JFrame window;

    public Gui(JOGLApp app) {
        this.app = app;
        window = new JFrame("PGRF3 projekt1");
        window.setSize(512, 384);

        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("Menu");
        menu.setMnemonic(KeyEvent.VK_A);
        menu.getAccessibleContext().setAccessibleDescription(
                "Menu projektu");
        menuBar.add(menu);

        JMenu submenu = new JMenu("Kartézské");
        ButtonGroup group = new ButtonGroup();
        JRadioButtonMenuItem rbCube = new JRadioButtonMenuItem(ChoosedObject.CUBE.getChoosedObject());
        rbCube.addActionListener(this);
        rbCube.setSelected(true);
        group.add(rbCube);
        submenu.add(rbCube);
        JRadioButtonMenuItem rbSnake = new JRadioButtonMenuItem(ChoosedObject.SNAKE.getChoosedObject());
        rbSnake.addActionListener(this);
        group.add(rbSnake);
        submenu.add(rbSnake);
        menu.add(submenu);

        submenu = new JMenu("Sférické");
        JRadioButtonMenuItem rbSphere = new JRadioButtonMenuItem(ChoosedObject.SPHERE.getChoosedObject());
        rbSphere.addActionListener(this);
        group.add(rbSphere);
        submenu.add(rbSphere);
        JRadioButtonMenuItem rbAlien = new JRadioButtonMenuItem(ChoosedObject.ALIEN.getChoosedObject());
        rbAlien.addActionListener(this);
        group.add(rbAlien);
        submenu.add(rbAlien);
        menu.add(submenu);

        submenu = new JMenu("Cilindrické");
        JRadioButtonMenuItem rbJuicer = new JRadioButtonMenuItem(ChoosedObject.ALIEN.getChoosedObject());
        rbJuicer.addActionListener(this);
        group.add(rbJuicer);
        submenu.add(rbJuicer);
        JRadioButtonMenuItem rbCroockedPipe = new JRadioButtonMenuItem(ChoosedObject.CROOKED_PIPE.getChoosedObject());
        rbCroockedPipe.addActionListener(this);
        group.add(rbCroockedPipe);
        submenu.add(rbCroockedPipe);
        menu.add(submenu);

        window.setJMenuBar(menuBar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(ChoosedObject.CUBE.getChoosedObject())){
            app.ren.createBuffers(new CartesianCube());
            
        }
    }
}
