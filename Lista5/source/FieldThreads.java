import java.awt.*;
import java.awt.geom.Rectangle2D;
import javax.swing.*;
import java.util.Random;

/**
 * Class creating fields with threads
 */
public class FieldThreads extends Thread {

    /** Creating GridPanel object */
    private GridPanel panel;
    
    /** Color of the field */
    private Color color;

    /** Creating random generator */
    private static final Random randomizer = new Random();
    
    /** Creating field cell */
    private Rectangle2D.Double field;

    /** Creating field neighbours array */
    private FieldThreads[] neighbour = new FieldThreads[4];
    
    /** Simulation refreshing speed */
    private int speed;

    /** Simulation color change probability */
    private double probability;

    /** Active state of the field */
    public boolean fieldState = true;

    /**
     * FieldThreads class constructor
     * @param x x coordinate of the field
     * @param y y coordinate of the field
     * @param speed simulation refreshing speed
     * @param probability simulation color change probability
     * @param panel GridPanel object
     */
    public FieldThreads(int x, int y, int speed, double probability, GridPanel panel) {
        this.speed = speed;
        this.probability = probability;
        this.panel = panel;

        field = new Rectangle2D.Double(x, y, panel.FIELDSIDE, panel.FIELDSIDE);

        setColorRandom();
    }

    /**
     * Adds neighbours to array for specified field
     * @param fieldN array containing neighbours
     */
    public void addNeighbours(FieldThreads[] fieldN) {
        neighbour = fieldN;
    }

    /**
     * Sets color of the field
     * @param c color to be set
     */
    public void setColor(Color c) {
        color = c;
        panel.repaint();
    }

    /** 
     * Uses setColor(Color) method with random color as argument
     */
    public void setColorRandom() {
        setColor(new Color(randomizer.nextFloat(), randomizer.nextFloat(), randomizer.nextFloat()));
    }   

    /**
     * Returns color of the field
     * @return field's color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Returns field object
     * @return the field
     */
    public Rectangle2D.Double getField() {
        return field;
    }

    /**
     * Returns field's state (active or idle)
     * @return true (active) or false (idle)
     */
    public boolean getActiveState() {
        return fieldState;
    }

    /**
     * Toggles field's state depending on its actual state
     */
    public void toggleState() {
        if(fieldState == true) { fieldState = false; }
        else { fieldState = true; }
    }

    /**
     * Generating average color for the field from surrounding active neighbours
     */
    public synchronized void generateAverageColor() {

        int r = 0, g = 0, b = 0;
        int activeNeighbourCount = 0;

        /** neighbour index: 0 - west, 1 - north, 2 - east, 3 - south */
        for(int i = 0; i < 4; i++) {
            if(neighbour[i].getActiveState()) {
                activeNeighbourCount++;
                r += neighbour[i].getColor().getRed();
                g += neighbour[i].getColor().getGreen();
                b += neighbour[i].getColor().getBlue();
            }
        }
        
        if(activeNeighbourCount != 0) {
            setColor(new Color(r / activeNeighbourCount,
                               g / activeNeighbourCount,
                               b / activeNeighbourCount));
        } else {
            getColor();
        }     
    }

    /**
     * Overriding run() method with instructions
     * calling color setting functions depending on probability
     */
    @Override
    public void run() {

        while(true) {
            
            if(fieldState) {
                if(randomizer.nextDouble() < probability) { setColorRandom(); }
                else { generateAverageColor(); }
            }

            panel.repaint();
                
            try {
                sleep((long)((randomizer.nextDouble() + 0.5) * speed));   
            } catch(InterruptedException exception) {
                JOptionPane.showMessageDialog(
                    panel,
                    "An error occurred",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}