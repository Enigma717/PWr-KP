import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * BarMenu class containing elements of bar menu
 */
public class BarMenu extends JMenuBar implements ActionListener {

    /**
     * BarMenu class constructor
     */
    public BarMenu() {

        /**
         * Creating the menu bar
         */
        JMenuBar bar = new JMenuBar();
        
        add(bar);


        /** Submenu containing file save/load options */
        JMenu file = new JMenu("File");
        /** "File" menu option to save to the file */
        JMenuItem save = new JMenuItem("Save");
        save.addActionListener(this);
        /** "File" menu option to load from the file */
        JMenuItem load = new JMenuItem("Load");
        load.addActionListener(this);

      
        bar.add(file);
        file.add(save);
        file.add(load);


        /** Submenu containing figures drawing options */
        JMenu draw = new JMenu("Draw");
        /** "Draw" menu option to draw a rectangle */
        JMenuItem rectangle = new JMenuItem("Rectangle");
        rectangle.addActionListener(this);
        /** "Draw" menu option to draw a circle */
        JMenuItem circle = new JMenuItem("Circle");
        circle.addActionListener(this);
        /** "Draw" menu option to draw a triangle */
        JMenuItem triangle = new JMenuItem("Triangle");
        triangle.addActionListener(this);
        /** "Draw" menu option to clear the drawing panel */
        JMenuItem clear = new JMenuItem("Clear");
        clear.addActionListener(this);


        bar.add(draw);
        draw.add(rectangle);
        draw.add(circle);
        draw.add(triangle);
        draw.addSeparator();
        draw.add(clear);


        /** Submenu containing help and about options */
        JMenu info = new JMenu("Info");
        /** "Info" menu option to view help for the user */
        JMenuItem help = new JMenuItem("Help");
        help.addActionListener(this);
        /** "Info" menu option to view information about the app */
        JMenuItem about = new JMenuItem("About");
        about.addActionListener(this);
        
        bar.add(info);
        info.add(help);
        info.add(about);
    }

    /**
     * Method handling actions performed by menu options
     * @param event chosen option from the menu 
     */
    public void actionPerformed(ActionEvent event) {
        switch(event.getActionCommand()) {
            case "Save": {
                System.exit(0);
                break;
            }
            case "Load": {
                System.exit(0);
                break;
            }
            case "Rectangle": {
                System.out.println("Selected rectangle");
                break;
            }
            case "Circle": {
                System.out.println("Selected circle");
                break;
            }
            case "Triangle": {
                System.out.println("Selected triangle");
                break;
            }
            case "Clear": {
                System.out.println("Panel cleared");
                break;
            }
            case "Help": {
                JOptionPane.showMessageDialog(
                    new DrawingPanel(),
                    "<html><body style=\"font-size:14px\"><center>Placeholder<center/>",
                    "User manual",
                    JOptionPane.PLAIN_MESSAGE);
				break;
            }
            case "About": {
                JOptionPane.showMessageDialog(
                    new DrawingPanel(),
                    "<html><body style=\"font-size:14px\"><center>Title: TraPaint ver. 1.0<center/>" +
                    "<b><center>Application for drawing and manipulating simple shapes<center/></b>" +
                    "Author: Marek Traczyński (261748)<br/>",
                    "About",
                    JOptionPane.PLAIN_MESSAGE);
                break;
            }
        }
    }
}