import javax.swing.*;

/**
 * Class creating frame for panel
 */
public class AppFrame extends JFrame {

    /** Creating GridPanel object */
    GridPanel panel = new GridPanel();

    /** 
     * AppFrame class constructor
     */
    public AppFrame() {
        setTitle("Threads Coloring Simulation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        add(panel);
        pack();
        setLocationRelativeTo(null); 
        setVisible(true);
    }
}