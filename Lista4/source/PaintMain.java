/**
 * Main class of the program
 */
public class PaintMain {
	
    /**
	 * Create new GUI
	 */
	public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GUI app = new GUI();
                app.setVisible(true);
            }
        });
    }
}