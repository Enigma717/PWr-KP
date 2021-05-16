import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * DrawingPanel class containing surface user draws on
 */
public class DrawingPanel extends JPanel {

    /**
     * DrawingPanel class constructor
     */
    public DrawingPanel() {

        initPanel();
    }

    public void initPanel() {

        MovingHandler moveHandle = new MovingHandler();

        addMouseMotionListener(moveHandle);
        addMouseListener(moveHandle);
        addMouseWheelListener(new ScalingHandler()); 

    }

    /**
     * Overriding paintComponent
     */
    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        drawing(g);      
    }

    /**
     * Drawing figures method
     */
    public void drawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
         
    }


    class MovingHandler extends MouseAdapter {


        @Override
        public void mousePressed(MouseEvent e) {
            System.out.println("Siema Eniu");
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            System.out.println("Kekw");
        }   

        @Override
        public void mouseReleased(MouseEvent e) {
            System.out.println("Ysz");
        }
    }

    class ScalingHandler implements MouseWheelListener {
        
        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
            doScale(e);
        }

        private void doScale(MouseWheelEvent e) {
            System.out.println("Siema");
        }
    }
    
}