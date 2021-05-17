import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * GUI class containing JFrame
 */
public class GUI extends JFrame {
    
    /** Drawing panel object */
    public DrawingPanel panel = new DrawingPanel(this);

    /** Drawing mode (0 - mouse actions | 1 - rectangle | 2 - ellipse | 3 - triangle) */
    public int mode;

    /**
     * Drawing mode setter
     */
    public void setMode(int m) {
        mode = m;
    }

    /**
     * Drawing mode getter 
     */
    public int getMode() {
        return mode;
    }

    /**
     * Creating bar menu for the frame
     */
    public void BarMenu() {

        /**
         * Creating the menu bar
         */
        JMenuBar bar = new JMenuBar();
        
        setJMenuBar(bar);


        /** Submenu containing file save/load options */
        JMenu file = new JMenu("File");
        /** "File" menu option to create a new file */
        JMenuItem newFile = new JMenuItem("New File");
        newFile.addActionListener((event) -> { newFile(); });
        /** "File" menu option to save to the file */
        JMenuItem save = new JMenuItem("Save As...");
        save.addActionListener((event) -> { System.exit(0); });
        /** "File" menu option to load from the file */
        JMenuItem load = new JMenuItem("Load File...");
        load.addActionListener((event) -> { System.exit(0); });
        /** "File" menu option to save to the file */
        JMenuItem exitApp = new JMenuItem("Exit");
        exitApp.addActionListener((event) -> { System.exit(0); });

        bar.add(file);
        file.add(newFile);
        file.addSeparator();
        file.add(save);
        file.add(load);
        file.addSeparator();
        file.add(exitApp);


        /** Submenu containing figures drawing options */
        JMenu draw = new JMenu("Draw");
        /** "Draw" menu option to activate mouse activities (moving and resizing figures) */
        JMenuItem mouse = new JMenuItem("Mouse Tools");
        mouse.addActionListener((event) -> { setMode(0); System.out.println("Current index: " + mode); System.out.println("Using mouse tools"); });
        /** "Draw" menu option to draw a rectangle */
        JMenuItem rectangle = new JMenuItem("Rectangle");
        rectangle.addActionListener((event) -> { setMode(1); System.out.println("Current index: " + mode); System.out.println("Drawing rectangle"); });
        /** "Draw" menu option to draw a circle */
        JMenuItem ellipse = new JMenuItem("Ellipse");
        ellipse.addActionListener((event) -> { setMode(2); System.out.println("Current index: " + mode); System.out.println("Drawing ellipse"); });
        /** "Draw" menu option to draw a triangle */
        JMenuItem triangle = new JMenuItem("Triangle");
        triangle.addActionListener((event) -> { setMode(3); System.out.println("Current index: " + mode); System.out.println("Drawing triangle"); });

        bar.add(draw);
        draw.add(mouse);
        draw.addSeparator();
        draw.add(rectangle);
        draw.add(ellipse);
        draw.add(triangle);


        /** Submenu containing help and about options */
        JMenu info = new JMenu("Info");
        /** "Info" menu option to view help for the user */
        JMenuItem help = new JMenuItem("Help");
        help.addActionListener((event) -> { help(); });
        /** "Info" menu option to view information about the app */
        JMenuItem about = new JMenuItem("About");
        about.addActionListener((event) -> { about(); });
        
        bar.add(info);
        info.add(help);
        info.add(about);
    }

    public void newFile() {

        panel.figuresList = new ArrayList<Figures>();
        panel.repaint();
    }

    public void help() {

        JOptionPane.showMessageDialog(
            panel,
            "<html><body style=\"font-size:14px\"><center>Placeholder<center/>",
            "User manual",
            JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * Viewing "About" message box
     */
    public void about() {

        JOptionPane.showMessageDialog(
            panel,
            "<html><body style=\"font-size:14px\"><center>Title: TrackPaint ver. 1.1<center/>" +
            "<b><center>Application for drawing and manipulating simple shapes<center/></b>" +
            "Author: Marek Traczyński (261748)<br/>",
            "About",
            JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * GUI class constructor
     */
    public GUI() {
        setTitle("TrackPaint 1.1");
        setSize(1280, 720);
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BarMenu();
        add(panel);
        setVisible(true);
    }
}