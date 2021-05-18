import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFileChooser;
import javax.swing.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
        cursorMode(m);
    }

    /**
     * Drawing mode getter 
     */
    public int getMode() {
        return mode;
    }

    /**
     * Setting cursor for drawing and mouse tools
     */
    public void cursorMode(int cMode) {
        mode = cMode; 
        if(mode == 0) { setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); }
        else { setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR)); }
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
        save.addActionListener((event) -> { save(); });
        /** "File" menu option to load from the file */
        JMenuItem load = new JMenuItem("Load File...");
        load.addActionListener((event) -> { load(); });
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
        mouse.addActionListener((event) -> { setMode(0); System.out.println("===================\nUsing mouse tools\n==================="); });
        /** "Draw" menu option to draw a rectangle */
        JMenuItem rectangle = new JMenuItem("Rectangle");
        rectangle.addActionListener((event) -> { setMode(1); System.out.println("===================\nDrawing rectangles\n==================="); });
        /** "Draw" menu option to draw a circle */
        JMenuItem ellipse = new JMenuItem("Ellipse");
        ellipse.addActionListener((event) -> { setMode(2); System.out.println("===================\nDrawing ellipses\n==================="); });
        /** "Draw" menu option to draw a triangle */
        JMenuItem triangle = new JMenuItem("Triangle");
        triangle.addActionListener((event) -> { setMode(3); System.out.println("===================\nDrawing triangles\n==================="); });

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

    /**
     * Creating new file with clean panel
     */
    public void newFile() {

        panel.figuresList = new ArrayList<Figures>();
        panel.repaint();
    }

    /**
     * Saving current panel to the file
     */
    public void save() {

        File file = fileExplorer();
        FileWriter writer;

        if (!file.getAbsolutePath().endsWith(".tpf")) { file = new File(file.getAbsolutePath() + ".tpf"); }

        try {
            writer = new FileWriter(file);

            for (Figures figure : panel.figuresList)
            {
                writer.write(figure + "\n");
            }

            writer.close();
        } catch (IOException exception) {
            JOptionPane.showMessageDialog(
                panel,
                "An error occured while trying to save the file:\n" + exception.toString(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Loading existing panel from the file
     */
    public void load() {
        
		File file = fileExplorer();
		ArrayList<String[]> readingList = new ArrayList<String[]>();
        Scanner scanner;

        String nextLine;
        String[] lineSplitter;

		try
		{
			scanner = new Scanner(file);

			while (scanner.hasNextLine()) {
		        nextLine = scanner.nextLine();
		        lineSplitter = nextLine.split(":");
		        readingList.add(lineSplitter);
		    }

		    scanner.close();
		}
		catch(IOException exception)
		{
			JOptionPane.showMessageDialog(
                panel,
                "An error occured while trying to load the file:\n" + exception.toString(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
		}

		if(readingList != null)
		{
			panel.figuresList.clear();

			for(String[] element : readingList)
			{
				Figures figure = null;
				double x, y, width, height;
				int color; 

                try{
                    x = Double.parseDouble(element[1]);
                    y = Double.parseDouble(element[2]);
                    width = Double.parseDouble(element[3]);
                    height = Double.parseDouble(element[4]);
                    color = Integer.parseInt(element[5]);

                    if(element[0].equals("R")) { figure = new MyRectangle(x, y, width, height); }
                    else if(element[0].equals("E")) { figure = new MyEllipse(x, y, width, height); }
                    else if(element[0].equals("T")) { figure = new MyTriangle(x, y, width, height); }
                        
                    if(figure != null)
                    {
                        figure.setColor(color);
                        panel.figuresList.add(figure);
                        panel.repaint();
                    }
                } catch(NumberFormatException exception) {
                    JOptionPane.showMessageDialog(
                    panel,
                    "An error occured while trying to load the file:\n" + exception.toString(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
                }	
			}
		}
    }

    /**
     * Creating file explorer window
     */
    public File fileExplorer() {

        JFileChooser fileExplorer = new JFileChooser();
        FileNameExtensionFilter extension = new FileNameExtensionFilter("TrackPaint file (*.tpf)", "tpf");

        fileExplorer.setDialogTitle("Choose file");
        fileExplorer.addChoosableFileFilter(extension);
		fileExplorer.setFileFilter(extension);

        int userSelection = fileExplorer.showSaveDialog(this);
            
        if (userSelection != JFileChooser.APPROVE_OPTION) { return null; }
        
        return fileExplorer.getSelectedFile();
    }

    /**
     * Viewing "User manual" message box
     */
    public void help() {

        JOptionPane.showMessageDialog(
            panel,
            "<html><body style=\"font-size:14px\">" +
            "<center><p style=\"font-size:16px\"/><b>File handling</b></center><br/>" +
            "<center><p style=\"font-size:15px\"/>Select \"File\" from bar menu:</center><br/><br/>" +
            "New File - Creates new clean panel ready for drawing<br/>" +
            "Save As... - Saves current figures drawn on the panel into .tpf file<br/>" +
            "Load File... - Loads existing .tpf file with saved figures<br/><br/>" +
            "<center><p style=\"font-size:16px\"/><b>Drawing</b></center><br/>" +
            "<center><p style=\"font-size:15px\"/>Select \"Draw\" from bar menu:</center><br/><br/>" +
            "Rectangle/Ellipse/Triangle - Press mouse left button then drag and release to draw chosen figure<br/>" +
            "Mouse Tools - Allows you to manipulate already drawn figures:<br/>" +
            "<ul><li><i>Selecting a figure - Click mouse left button on the figure to select it then click anywhere on the panel to deselect it</i></li><br/>" +
            "<li><i>Moving a figure - Select a figure then press mouse left button and drag anywhere on the panel to move it to cursor location</i></li><br/>" +
            "<li><i>Resizing a figure - Select a figure then use mouse scroll anywhere on the panel to make it bigger or smaller</i></li><br/>" +
            "<li><i>Coloring a figure - Select a figure then press mouse right button anywhere on the panel to choose new color for it<br/>" +
            "When there is no figure selected press right mouse button anywhere on the panel to change background color</i></li></ul><br/>" +
            "</body></html>",
            "User manual",
            JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * Viewing "About" message box
     */
    public void about() {

        JOptionPane.showMessageDialog(
            panel,
            "<html><body style=\"font-size:14px\"><center>TrackPaint ver. 2.0<center/>" +
            "<b><center>Application for drawing and manipulating simple shapes<center/></b>" +
            "Author: Marek Traczyński (261748)<br/>",
            "About",
            JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * GUI class constructor
     */
    public GUI() {
        try { 
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }  catch(ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException exception) {
            JOptionPane.showMessageDialog(
                panel,
                "An error occured while trying to load the UI Look And Feel:\n" + exception.toString(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
        setTitle("TrackPaint 2.0");
        setSize(1280, 720);
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BarMenu();
        add(panel);
        setVisible(true);
    }
}