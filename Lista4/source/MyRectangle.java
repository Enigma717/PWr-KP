import java.awt.Color;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

/**
 * Class containing operations done with rectangle
 */
public class MyRectangle extends Rectangle2D.Double implements Figures {

    /** Default color (gray) */
    public Color color = Color.GRAY;

    /** Class constructor */
    public MyRectangle(double x, double y, double width, double height) {
        setRect(x, y, width, height);
    }

    /** See {@link Figures#isHit(double, double)} */
    @Override
    public boolean isHit(double x, double y) {
        return getBounds2D().contains(x, y);
    }

    /** See {@link Figures#addX(double)} */
    @Override
    public void addX(double x) {
        this.x += x;
    }

    /** See {@link Figures#addY(double)} */
    @Override
    public void addY(double y) {
        this.y += y;
    }

    /** See {@link Figures#addWidth(double)} */
    public void addWidth(double w) {
        this.width += w;
    }

    /** See {@link Figures#addHeight(double)} */
    @Override
    public void addHeight(double h) {
        this.height += h;
    }

    /** See {@link Figures#setValues(double, double, double, double)} */
    @Override
    public void setValues(double x1, double y1, double x2, double y2) {
        this.x = Math.min(x1, x2);
        this.y = Math.min(y1, y2);
        this.width = Math.abs(x1 - x2);
        this.height = Math.abs(y1 - y2);
    }

    /** See {@link Figures#setColor(Color)} */
    @Override
    public void setColor(Color c) {
        color = c;
    }

    /** See {@link Figures#getColor()} */
    @Override
    public Paint getColor() {
        return color;
    }

    /** See {@link Figures#returnShape()} */
    @Override
    public Shape returnShape() {
        return this;
    }

    /** See {@link Figures#toString()} */
    @Override
    public String toString() {
        return "Rectangle:" + x + "|" + y + "|" + width + "|" + height + "|" + color.getRGB();
    }
}