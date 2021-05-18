import java.awt.Color;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Polygon;

/**
 * Class containing operations done with triangle 
 */
public class MyTriangle implements Figures {

    /** Default color (gray) */
    public Color color = Color.GRAY;

    /** Creating polygon for triangle */
    public Polygon myTriangle;

    /** Variables used to set vertices */
    public double x, y, width, height;

    /** Class constructor */
    public MyTriangle(double x, double y, double width, double height) {
        myTriangle = new Polygon();
        setValues(x, y, width, height);
    }

    /** Setting values for triangle vertices */
    public void setValues(double newx, double newy, double newwidth, double newheight) {
        x = newx;
        y = newy;
        width = newwidth;
        height = newheight;
        setPoints();
    }

    /** Creating triangle vertices */
    public void setPoints() {
        myTriangle.reset();
        myTriangle.addPoint((int)(x + width) / 2, (int)y);
        myTriangle.addPoint((int)width, (int)height);
        myTriangle.addPoint((int)x, (int)height);
    }

    /** See {@link Figures#isHit(double, double)} */
    public boolean isHit(double x, double y) {
        return myTriangle.contains(x, y);
    }

    /** See {@link Figures#addX(double)} */
    public void addX(double x) {
        this.x += x;
        this.width += x;
        setPoints();
    }

    /** See {@link Figures#addY(double)} */
    public void addY(double y) {
        this.y += y;
        this.height += y;
        setPoints();
    }

    /** See {@link Figures#addWidth(double)} */
    public void addWidth(double w) {
        this.width += w;
        setPoints();
    }

    /** See {@link Figures#addHeight(double)} */
    public void addHeight(double h) {
        this.height += h;
        setPoints();
    }

    /** See {@link Figures#getWidth()} */
    @Override
    public double getWidth() { 
        return this.width; 
    }

    /** See {@link Figures#getHeight()} */
    @Override
    public double getHeight() { 
        return this.height; 
    }

    /** See {@link Figures#setColor(Color)} */
    @Override
    public void setColor(Color c) {
        color = c;
    }

    /** See {@link Figures#setColor(int)} */
    @Override
    public void setColor(int c) {
        color = new Color(c);
    }

    /** See {@link Figures#getColor()} */
    @Override
    public Paint getColor() {
        return color;
    }

    /** See {@link Figures#returnShape()} */
    @Override
    public Shape returnShape() {
        return myTriangle;
    }

    /** See {@link Figures#toString()} */
    @Override
    public String toString() {
        return "T:" + x + ":" + y + ":" + width + ":" + height + ":" + color.getRGB();
    }
}