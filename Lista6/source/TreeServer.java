import java.io.*;
import java.net.*;

public class TreeServer {

    ServerSocket server = null;
    Socket client = null;
    BufferedReader inputBuffer = null;
    PrintWriter outputPrinter = null;

    String line = "";

    BinaryTree<Integer> treeInteger = new BinaryTree<>();
    BinaryTree<Double> treeDouble = new BinaryTree<>();
    BinaryTree<String> treeString = new BinaryTree<>();
    
    TreeServer() { 
        try {
            System.out.println("Starting new server on port 1337");
            server = new ServerSocket(1337); 
        } catch (IOException e) {
            System.out.println("Could not listen on port 1337"); 
            System.exit(-1);
        }
    }

    public void startSocket() {
        try {
            System.out.println("New connection established on port 1337");
            client = server.accept();
        } catch (IOException e) {
            System.out.println("Failed to establish connection on port 1337"); 
            System.exit(-1);
        }

        try {
            inputBuffer = new BufferedReader(new InputStreamReader(client.getInputStream()));
            outputPrinter = new PrintWriter(client.getOutputStream(), true);
        } catch (IOException e) {
            System.out.println("Connection failed on port 1337"); 
            System.exit(-1);
        }

        while(line != null) {
            try {
                line = inputBuffer.readLine();
                
                if(line.charAt(0) == 'i') {
                    if(line.charAt(2) == '0') {
                        line = line.substring(4);

                        System.out.println("Node with value " + line + " added to Integer Tree");
                        treeInteger.insert(Integer.parseInt(line));
                    }
                    else if(line.charAt(2) == '1') {
                        line = line.substring(4);

                        System.out.println("Node with value " + line + " added to Double Tree");
                        treeDouble.insert(Double.parseDouble(line));
                    }
                    else if(line.charAt(2) == '2') {
                        line = line.substring(4);

                        System.out.println("Node with value " + line + " added to String Tree");
                        treeString.insert(line);
                    }
                }
                else if(line.charAt(0) == 'd') {
                    if(line.charAt(2) == '0') {
                        line = line.substring(4);

                        System.out.println("Node with value " + line + " removed from Integer Tree");
                        treeInteger.delete(Integer.parseInt(line));
                    }
                    else if(line.charAt(2) == '1') {
                        line = line.substring(4);

                        System.out.println("Node with value " + line + " removed from Double Tree");
                        treeDouble.delete(Double.parseDouble(line));
                    }
                    else if(line.charAt(2) == '2') {
                        line = line.substring(4);

                        System.out.println("Node with value " + line + " removed from String Tree");
                        treeString.delete(line);
                    }
                }
                else if(line.charAt(0) == 's') {
                    if(line.charAt(2) == '0') {
                        line = line.substring(4);

                        if(treeInteger.search(Integer.parseInt(line))) {
                            System.out.println("Node has been found in Tree");
                        } else {
                            System.out.println("Node has not been found in Tree");
                        }
                    }
                    else if(line.charAt(2) == '1') {
                        line = line.substring(4);

                        if(treeDouble.search(Double.parseDouble(line))) {
                            System.out.println("Node has been found in Tree");
                        } else {
                            System.out.println("Node has not been found in Tree");
                        }
                    }
                    else if(line.charAt(2) == '2') {
                        line = line.substring(4);

                        if(treeString.search(line)) {
                            System.out.println("Node has been found in Tree");
                        } else {
                            System.out.println("Node has not been found in Tree");
                        }
                    }
                }
                else if(line.charAt(0) == 'p') {       
                    if(line.charAt(2) == '0') {
                        treeInteger.print();
                    }
                    else if(line.charAt(2) == '1') {
                        treeDouble.print();
                    }
                    else if(line.charAt(2) == '2') {
                        treeString.print();
                    }
                }
            } 
            catch (IOException e) {
                System.out.println("An error occured"); 
                System.exit(-1);
            } 
        }
    }


    @Deprecated
    protected void finalize() {
        try {
            inputBuffer.close();
            outputPrinter.close();
            client.close();
            server.close();
        } catch (IOException e) {
            System.out.println("An error occurred while trying to close the server");
            System.exit(-1);
        }
    }

    public static void main(String[] args) {
        TreeServer server = new TreeServer();
        server.startSocket();
    }
}
