import java.awt.Point;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.RenderingHints;
import java.awt.BasicStroke;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.List;

/**
 * DrawingPanel class containing surface user draws on
 */
public class DrawingPanel extends JPanel {

    /** Creating array list for drawn figures */
    public ArrayList<Figures> figuresList;

    /** Gui object */
    public GUI frame;

    /** Figures objects to handle drawing and selecting */
    public Figures tempFigure;
    public Figures activeFigure;
    public Figures selectedFigure;

    /** Color menu object */
    final JColorChooser colorPalette = new JColorChooser(); 

    /**
     * DrawingPanel class constructor
     */
    public DrawingPanel(GUI gui) {

        /** Preventing NullPointerException */
        frame = gui;

        figuresList = new ArrayList<Figures>();

        setSize(1280, 720);
        setBackground(new Color(190, 180, 130));

        /** Creating mouse listeners */
        MovingHandler moveHandle = new MovingHandler();
        ScalingHandler scaleHandle = new ScalingHandler();
        addMouseMotionListener(moveHandle);
        addMouseListener(moveHandle);
        addMouseWheelListener(scaleHandle); 

        frame.setMode(0);
    }

    /**
     * Adding figure to the array list
     * @param figure given figure
     */
    public void addFigure(Figures figure) {
        
        figuresList.add(figure);
        repaint();
    }

    /**
     * Drawing preview of the figure while dragging the mouse
     */
    public void drawPreview(Figures figure) {

        activeFigure = figure;
        repaint();
    }

    /**
     * Drawing an outline around selected figure
     */
    public void highlightSelected(Figures figure) {

        selectedFigure = figure;
        repaint();
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

        /** Preparing figure outline styles */
        float[] previewDash = {4f, 0f, 2f};
        float[] selectedDash = {1f, 1f, 1f};

        /** Enabling anti-aliasing */
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHints(rh);

        /** Creating outlines for each state of the figure */
        BasicStroke figureStroke = new BasicStroke(1);
        BasicStroke previewStroke = new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 1.0f, previewDash, 2f);
        BasicStroke selectedStroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 1.0f, selectedDash, 2f);

        /** Drawing figures from the list */
        if(figuresList != null) {
            for(Figures figure : figuresList)
            {
                g2d.setPaint(Color.BLACK);
                g2d.setStroke(figureStroke);
                g2d.draw(figure.returnShape());
                g2d.setPaint(figure.getColor());
                g2d.fill(figure.returnShape());
            }
        }

        /** Drawing preview of the figure */
        if(activeFigure != null) {
            g2d.setPaint(Color.BLACK);
            g2d.setStroke(previewStroke);
            g2d.draw(activeFigure.returnShape());
        }

        /** Adding border to selected figure */
        if(selectedFigure != null) {
            g2d.setPaint(Color.RED);
            g2d.setStroke(selectedStroke);
            g2d.draw(selectedFigure.returnShape());
        }
    }

    /**
     * Handling actions performed by mouse
     */
    class MovingHandler extends MouseAdapter {

        private int x1, x2, clickX;
        private int y1, y2, clickY;
        private int dx, dy;
        
        private double p1, p2, width, height;

        private boolean isSelected;

        /**
         * Mouse clicked events handler
         */
        @Override
        public void mouseClicked(MouseEvent event) {

            clickX = event.getX();
            clickY = event.getY();
            
            isSelected = false;

            if(event.getButton() == MouseEvent.BUTTON1) {
                for(Figures figure : figuresList) { 
                    if(figure.isHit(clickX, clickY)) { 
                        System.out.println("New figure selected");
                        isSelected = true;
                        selectedFigure = figure;
                    
                        highlightSelected(figure);
                    } 
                }
            }
            if(isSelected == false) {
                selectedFigure = null;
                repaint();
            }
        }

        /** 
         * Mouse pressed events handler
         */
        @Override
        public void mousePressed(MouseEvent event) {

            x1 = event.getX();
            y1 = event.getY();

            if(event.getButton() == MouseEvent.BUTTON3) {
                for(Figures figure : figuresList) { 
                    if(figure.isHit(clickX, clickY) && isSelected == true) { 
                        selectedFigure = figure;
                        
                        Color chosenColor = JColorChooser.showDialog(frame, "Choose figure color", Color.BLACK);  
                        if (chosenColor != null) {  
                            selectedFigure.setColor(chosenColor);
                            repaint();
                        }
                    }
                }
                if(isSelected == false) {
                    Color chosenColor = JColorChooser.showDialog(frame, "Choose background color", Color.BLACK);  
                    if (chosenColor != null) {  
                        setBackground(chosenColor);
                        repaint();
                    }
                } 
            }
        }

        /**
         * Mouse dragged events handler
         */
        @Override
        public void mouseDragged(MouseEvent event) {

            x2 = event.getX();
            y2 = event.getY();

            if(frame.mode == 0) {
                dx = event.getX() - clickX;
                dy = event.getY() - clickY;

                if(selectedFigure != null && selectedFigure.isHit(clickX, clickY)) {
                    selectedFigure.addX(dx);
                    selectedFigure.addY(dy);
                    clickX += dx;
                    clickY += dy;

                    repaint();
                }
            }
            else if(frame.mode == 1) {
                p1 = Math.min(x1, x2);
                p2 = Math.min(y1, y2);
                width = Math.abs(x1 - x2);
                height = Math.abs(y1 - y2);

                tempFigure = new MyRectangle(p1, p2, width, height);

                drawPreview(tempFigure);
            }
            else if(frame.mode == 2) {
                p1 = Math.min(x1, x2);
                p2 = Math.min(y1, y2);
                width = Math.abs(x1 - x2);
                height = Math.abs(y1 - y2);

                tempFigure = new MyEllipse(p1, p2, width, height);

                drawPreview(tempFigure);
            }
            else if(frame.mode == 3) {               
                tempFigure = new MyTriangle(x1, y1, x2, y2);

                drawPreview(tempFigure);
            }
        }
        
        /**
         * Mouse released events handler
         */
        @Override
        public void mouseReleased(MouseEvent event) {
            
            x2 = event.getX();
            y2 = event.getY();
            
            if(frame.mode == 1) {
                p1 = Math.min(x1, x2);
                p2 = Math.min(y1, y2);
                width = Math.abs(x1 - x2);
                height = Math.abs(y1 - y2);

                addFigure(new MyRectangle(p1, p2, width, height));

                repaint();
            }
            else if(frame.mode == 2) {
                p1 = Math.min(x1, x2);
                p2 = Math.min(y1, y2);
                width = Math.abs(x1 - x2);
                height = Math.abs(y1 - y2);

                addFigure(new MyEllipse(p1, p2, width, height));

                repaint();
            }
            else if(frame.mode == 3) {                
                addFigure(new MyTriangle(x1, y1, x2, y2));

                repaint();
            }

            tempFigure = null;
            activeFigure = null;  
        }
    }

    /**
     * Handling actions performed by mouse scroll
     */
    class ScalingHandler implements MouseWheelListener {
        
        /**
         * Mouse scroll moved events handler
         */
        @Override
        public void mouseWheelMoved(MouseWheelEvent event) {

            double scale = event.getPreciseWheelRotation() * 20.0;
            
            if(frame.mode == 0) {
                if(selectedFigure != null) {
                    double shapeRatio = selectedFigure.getHeight() / selectedFigure.getWidth();

                    selectedFigure.addWidth(scale);
                    selectedFigure.addHeight(shapeRatio * scale);
                    selectedFigure.addX(-scale / 2.0);
                    selectedFigure.addY(-scale / 2.0);

                    repaint();
                }
            }
        }
    }
    
}