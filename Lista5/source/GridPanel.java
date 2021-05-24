import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import javax.swing.*;

/**
 * Class creating frame and grid
 */
public class GridPanel extends JPanel {
    
    /** Field side length */
    public static final int FIELDSIDE = 25;

    /** Two-dimensional array containing every field */
    public FieldThreads[][] grid;
    
    /** Array containing neighbours surrounding the field */
    public FieldThreads[] neighbours;

    /** Dimensions of the panel measured in n x m grid of 25x25px squares */
    public int nSize, mSize;

    /** Simulation refreshing speed */
    private int refreshSpeed;

    /** Simulation color change probability */
    private double probability;

    private Rectangle2D.Double outline;


    /**
     * GridPanel class constructor
     */
    public GridPanel() {

        initUI();

        DeactivateThreads clickDeactivator = new DeactivateThreads();
        addMouseListener(clickDeactivator);
        
        grid = new FieldThreads[nSize][mSize];

        for(int i = 0; i < nSize; i++) {
            for(int j = 0; j < mSize; j++) {
                grid[i][j] = new FieldThreads(i * FIELDSIDE, j * FIELDSIDE, refreshSpeed, probability, this);
            }
        }

        setFieldNeighbours();
        runThreads();

        repaint();
    }

    /**
     * Creating input box to set values for simulation
     */
    public void inputBox() {

        try { 
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }  catch(ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException exception) {
            JOptionPane.showMessageDialog(
                this,
                "An error occured while trying to load the UI Look And Feel:\n" + exception.toString(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }

        JTextField n = new JTextField();
        JTextField m = new JTextField();
        JTextField r = new JTextField();
        JTextField p = new JTextField();

        Object[] input = {
            "Dimensions (number of 25x25px squares)",
            "Columns:", n, 
            "Rows: ", m,
            "\nRefresh frequency (in miliseconds): ", r,
            "Probability (1 >= p >= 0): ", p
        };
  
        int inputBox = JOptionPane.showConfirmDialog(
            null,
            input, 
            "Please enter input values",
            JOptionPane.OK_CANCEL_OPTION);

        
        if (inputBox == JOptionPane.OK_OPTION) {
            try {
                nSize = Integer.parseInt(n.getText());
                mSize = Integer.parseInt(m.getText());
                refreshSpeed = Integer.parseInt(r.getText());
                probability = Double.parseDouble(p.getText());

                if(probability > 1 || probability < 0 || nSize <= 0 || mSize <= 0 || refreshSpeed < 0) {
                    JOptionPane.showMessageDialog(
                        this,
                        "Please enter correct values!",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                    inputBox();
                }

            } catch(NumberFormatException exception) {
                JOptionPane.showMessageDialog(
                    this,
                    "Please enter correct values!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
                inputBox();
            }
        }
        else {
            System.exit(0);
        }
    }

    /**
     * Initializing user interface
     */
    public void initUI() {

        inputBox();

        setPreferredSize(new Dimension(nSize * FIELDSIDE, mSize * FIELDSIDE));
        setSize(nSize * FIELDSIDE, mSize * FIELDSIDE);
    }

    /**
     * Saving surrounding neighbours for specified field in the array
     */
    public void setFieldNeighbours() {

        int westNeighbour;
        int northNeighbour; 
        int eastNeighbour; 
        int southNeighbour;

        for(int i = 0; i < nSize; i++) {
            for(int j = 0; j < mSize; j++) {
                westNeighbour = i == 0 ? nSize - 1 : i - 1;
                northNeighbour = j == 0 ? mSize - 1 : j - 1; 
                eastNeighbour = i == mSize - 1 ? 0 : i + 1;
                southNeighbour = j == mSize - 1 ? 0 : j + 1;

                neighbours = new FieldThreads[] { grid[westNeighbour][j],
                                                  grid[i][northNeighbour],
                                                  grid[eastNeighbour][j],
                                                  grid[i][southNeighbour] };

                grid[i][j].addNeighbours(neighbours);
            }
        }          
    }

    /**
     * Starting thread for each field
     */
    public void runThreads() {

        for(int i = 0; i < nSize; i++) {
            for(int j = 0; j < mSize; j++) {
                grid[i][j].start();
            }
        }
    }

    /**
     * Overriding paintComponent method
     */
    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        float[] outlineDash = {4f, 0f, 2f};
        BasicStroke outlineStroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 1.0f, outlineDash, 2f);

        for(int i = 0; i < nSize; i++) {
            for(int j = 0; j < mSize; j++) {
                g2d.setColor(grid[i][j].getColor());
                g2d.fill(grid[i][j].getField());

                if(grid[i][j].getActiveState() == false) {
                    outline = new Rectangle2D.Double(grid[i][j].getField().getX(),
                                                     grid[i][j].getField().getY(),
                                                     FIELDSIDE, FIELDSIDE);
                    
                    g2d.setColor(new Color(0, 0, 0));
                    g2d.setStroke(outlineStroke);
                    g2d.draw(outline);
                }
            }
        } 
    }

    /**
     * Class used to toggle thread state by mosue click
     */
    class DeactivateThreads extends MouseAdapter {

        private int x, y;

        @Override
        public void mouseClicked(MouseEvent event) {

            x = event.getX();
            y = event.getY();

            int fieldX = x / FIELDSIDE;
            int fieldY = y / FIELDSIDE;

            grid[fieldX][fieldY].toggleState();
        }
    }
}