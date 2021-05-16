import javax.swing.*;

/**
 * GUI class containing JFrame
 */
public class GUI extends JFrame {
    
    /**
     * GUI class constructor
     */
    public GUI() {
        setTitle("TraPaint 1.0");
        setSize(1280, 720);
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setJMenuBar(new BarMenu());
        add(new DrawingPanel());
        setVisible(true);
    }
}