import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.net.*;

class TreeClient extends JFrame implements ActionListener {

    JTextField inputField;
    JButton buttonInsert;
    JButton buttonDelete;
    JButton buttonSearch;
    JButton buttonDraw;

    Socket socket = null;
    BufferedReader inputBuffer = null;
    PrintWriter outputPrinter = null;

    public int treeType;

    TreeClient() {
        chooseTreeType();
        createFrame();

        setFont(new Font(Font.SANS_SERIF,Font.PLAIN,40));

        inputField = new JTextField(20);
   
        buttonInsert = new JButton("Insert given node");
        buttonInsert.addActionListener(this);
        buttonDelete = new JButton("Delete given node");
        buttonDelete.addActionListener(this);
        buttonSearch = new JButton("Search for given node");
        buttonSearch.addActionListener(this);
        buttonDraw = new JButton("Draw tree with given nodes");
        buttonDraw.addActionListener(this);


        setLayout(new GridLayout(5,1));
        add(inputField);
        add(buttonInsert);
        add(buttonDelete);
        add(buttonSearch);
        add(buttonDraw);
        setVisible(true);
    }

    public void chooseTreeType() {
        String[] types = {"Integer", "Double", "String"};

        treeType = JOptionPane.showOptionDialog(
            null,
            "Choose type of the tree: ",
            "Type of tree",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null, types, types[0]);
    }

    public void createFrame() {
        setTitle("Binary Tree Client Interface");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 300);
        setResizable(false);
        setLocationRelativeTo(null); 
        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == buttonInsert) {
            outputPrinter.println("i:" + treeType + ":" + inputField.getText());
        }
        else if(event.getSource() == buttonDelete) {
            outputPrinter.println("d:" + treeType + ":" + inputField.getText());
        }
        else if(event.getSource() == buttonSearch) {
            outputPrinter.println("s:" + treeType + ":" + inputField.getText());
        }
        else if(event.getSource() == buttonDraw) {
            outputPrinter.println("p:" + treeType + ":" + inputField.getText());
        }

        inputField.setText("");
        inputField.requestFocus();
    }

    public void startSocket() {
        try {
            socket = new Socket("localhost", 1337);
            outputPrinter = new PrintWriter(socket.getOutputStream(), true);
            inputBuffer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (UnknownHostException e) {
            System.out.println("Unknown host: localhost");
			System.exit(1);
        } catch  (IOException e) {
            System.out.println("No I/O");
			System.exit(1);
        }
    }

    public static void main(String[] args) {
        TreeClient frame = new TreeClient();
        frame.startSocket();
    }
}

