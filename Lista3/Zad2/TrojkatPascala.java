import java.awt.*;
import java.awt.event.*;

public class TrojkatPascala
{
    
    static Label Wydruk(int numer) 
    {
		Label Wyjscie = new Label(numer + " ", Label.CENTER);
		Wyjscie.setForeground(new Color(0, 0, 0));
        Wyjscie.setFont(new Font(Font.DIALOG, Font.PLAIN, 25));
		return Wyjscie;
	}
    public static void main(String[] args)
    {
        Frame Okno = new Frame("Trojkąt Pascala");
        
        Label Info = new Label("Wprowadź liczbę wierszy Trójkąta Pascala:", Label.CENTER);
        Info.setFont(new Font(Font.DIALOG, Font.PLAIN, 40));
        Info.setBackground(new Color(230, 180, 50));

        TextField Wejscie = new TextField();
        Wejscie.setBackground(new Color(155, 165, 170));
		Wejscie.setForeground(new Color(0, 0, 0));
		Wejscie.setFont(new Font(Font.DIALOG, Font.PLAIN, 40));

        Button Przycisk = new Button("Wygeneruj trójkąt");
        Przycisk.setBackground(new Color(110, 110, 110));
		Przycisk.setForeground(new Color(0, 0, 0));
		Przycisk.setFont(new Font(Font.DIALOG, Font.PLAIN, 40));

		Przycisk.addActionListener(new ActionListener()
        {
		    public void actionPerformed(ActionEvent e)
            { 
		        if(Integer.parseInt(Wejscie.getText()) < 0)
                    Info.setText("Nieprawidłowa dana!");
                else
                {
                    int dane = Integer.parseInt(Wejscie.getText());
                    int wspolczynnik[][] = new int[dane+1][];
                    
                    Okno.removeAll();

                    for(int i = 0; i < dane + 1; i++) 
                    {
                        Panel Pole = new Panel();

                        wspolczynnik[i] = new int[i+1];
                        wspolczynnik[i][0] = 1;
                        wspolczynnik[i][i] = 1;
                        
                        Pole.add(Wydruk(wspolczynnik[i][0]));
                        
                        if(i > 0) 
                        {
                            for(int k = 1; k < i; k++) 
                            {
                                wspolczynnik[i][k] = wspolczynnik[i-1][k-1] + wspolczynnik[i-1][k];
                                Pole.add(Wydruk(wspolczynnik[i][k]));
                            }
                            Pole.add(Wydruk(wspolczynnik[i][i]));
                        }

                        Okno.add(Pole);
                    }

                    Okno.setLayout(new GridLayout(0,1));
                    Okno.setVisible(true);
                    Okno.pack();
                }
            }
        });

        Okno.add(Info, BorderLayout.NORTH);
        Okno.add(Wejscie, BorderLayout.CENTER);
        Okno.add(Przycisk, BorderLayout.SOUTH);
        Okno.setLayout(new GridLayout(0,1));
        Okno.setSize(1200, 800);
		Okno.setVisible(true);
        Okno.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}