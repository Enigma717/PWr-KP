import java.awt.Color;
import java.awt.Paint;
import java.awt.Shape;

/**
 * Interface containing methods used in creating and managing each figure
 */
public interface Figures {
    
    /**
     * Checks whether the clicked point contains within a figure
     * @param x X coordinate of the clicked point
     * @param y Y coordinate of the clicked point
     * @return true if the point contains, false otherwise
     */
    boolean isHit(double x, double y);

    /**
     * Adds certain value to figure's X coordinate
     * @param x value to be added
     */
    void addX(double x);

    /**
     * Adds certain value to figure's Y coordinate
     * @param y value to be added
     */
    void addY(double y);

    /**
     * Adds certain value to figure's width
     * @param w value to be added
     */
    void addWidth(double w);

    /**
     * Adds certain value to figure's height
     * @param h value to be added
     */
    void addHeight(double h);

    /**
     * Sets values of the figure's parameters (prevents drawing bugs)
     * @param x1 X coordinate of the starting point
     * @param y1 Y coordinate of the starting point
     * @param x2 X coordinate of the ending point
     * @param y2 Y coordinate of the ending point
     */
    void setValues(double x1, double y1, double x2, double y2);

    /**
     * Sets color of the figure
     * @param color given color
     */
    void setColor(Color color);

    /**
     * Returns color of the figure
     * @return figure's color
     */
    Paint getColor();

    /**
     * Returns what type of shape the figure is
     * @return type of the shape
     */
    Shape returnShape();

    /**
     * Formats figure's parameters for easier file IO management
     * @return string containing figure's parameters
     */
    String toString();
}
