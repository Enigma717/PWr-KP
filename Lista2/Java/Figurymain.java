public class Figurymain
{
    public static void main(String[] args)
    {

        if(args.length == 0)
        {
            System.out.println("Nie podano żadnych parametrów!");
        }

        Figura[] TablicaFigur = new Figura[args[0].length()];
        int licznik = 1;

        try 
        {
            
            for(int i = 0; i < TablicaFigur.length; i++)
            {
                
                if(args[0].charAt(i) == 'o')
                {
                    if(Double.parseDouble(args[licznik]) > 0)
                    {
                        Kolo NowyKolo = new Kolo(Double.parseDouble(args[licznik]));
                        TablicaFigur[i] = NowyKolo;
                        System.out.println("Utowrzono koło");
                    }
                    else
                    {
                        System.out.println("Długość promienia musi być większa od 0!");
                    }

                    licznik++;
                }
                else if(args[0].charAt(i) == 'c')
                {
                    double bok1 = Double.parseDouble(args[licznik]);
                    licznik++;
                    double bok2 = Double.parseDouble(args[licznik]);
                    licznik++;
                    double bok3 = Double.parseDouble(args[licznik]);
                    licznik++;
                    double bok4 = Double.parseDouble(args[licznik]);
                    licznik++;
                    double kat = Double.parseDouble(args[licznik]);
                    licznik++;

                    if(bok1 > 0 && bok2 > 0 && bok3 > 0 && bok4 > 0 && kat > 0)
                    {

                        if(bok1 == bok2 && bok1 == bok3 && bok1 == bok4 && kat == 90)
                        {
                            Kwadrat NowyKwadrat = new Kwadrat(bok1);
                            TablicaFigur[i] = NowyKwadrat;
                            System.out.println("Utworzono kwadrat");
                        }
                        else if(bok1 == bok2 && bok1 == bok3 && bok1 == bok4)
                        {
                            Romb NowyRomb = new Romb(bok1, kat);
                            TablicaFigur[i] = NowyRomb;
                            System.out.println("Utworzono romb");
                        }
                        else if(bok1 == bok2 && bok3 == bok4 && kat == 90)
                        {
                            Prostokat NowyProstokat = new Prostokat(bok1, bok3);
                            TablicaFigur[i] = NowyProstokat;
                            System.out.println("Utworzono prostokąt");
                        }
                        else
                        {
                            System.out.println("Nieznany czworokąt!");
                        }
                    }
                    else
                    {
                        System.out.println("Długości boków i wielkości kątów muszą byc więskze od 0!");
                    }
                }
                else if(args[0].charAt(i) == 'p')
                {
                    if(Double.parseDouble(args[licznik]) > 0)
                    {
                        Pieciokat NowyPieciokat = new Pieciokat(Double.parseDouble(args[licznik]));
                        TablicaFigur[i] = NowyPieciokat;
                        System.out.println("Utworzono pięciokąt");
                    }
                    else
                    {
                        System.out.println("Długość boku musi być większa od 0!");
                    }

                    licznik++;
                }
                else if(args[0].charAt(i) == 's')
                {
                    if(Double.parseDouble(args[licznik]) > 0)
                    {
                        Szesciokat NowySzesciokat = new Szesciokat(Double.parseDouble(args[licznik]));
                        TablicaFigur[i] = NowySzesciokat;
                        System.out.println("Utworzono sześciokąt");
                    }
                    else
                    {
                        System.out.println("Długość boku musi być większa od 0!");
                    }

                    licznik++; 
                }
            }
        } 
        catch (NumberFormatException e) 
        {
            System.out.println("Błędne dane!");
        }
        catch (ArrayIndexOutOfBoundsException e) 
        {
            System.out.println("Niepoprawna liczba danych!");
        }

        for(int i = 0; i < TablicaFigur.length; i++)
        {
            try
            {
                System.out.println("Figura nr " + (i+1) + " || Obwód: " + TablicaFigur[i].obwod() + "\tPole: " + TablicaFigur[i].pole());
            }
            catch(Exception NullPointerException)
            {
                System.out.println("Figura nr " + (i+1) + " || Błędne dane!");
            }
        }
    }
}