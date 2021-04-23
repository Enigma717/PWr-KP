public class FiguryMain
{
    public static void main(String[] args)
    {
        Figury.JednaZmienna Jedna;
        Figury.DwieZmienne Dwie;
        if(args.length == 0)
        {
            System.out.println("Nie podano żadnych parametrów!");
        }

        Figury[] TablicaFigur = new Figury[args[0].length()];
        int licznik = 1;

        try 
        {
            
            for(int i = 0; i < TablicaFigur.length; i++)
            {
                
                if(args[0].charAt(i) == 'o')
                {
                    if(Double.parseDouble(args[licznik]) > 0)
                    {
                        Jedna = Figury.JednaZmienna.KOLO;
                        double promien = Double.parseDouble(args[licznik]);
                        System.out.println("Utworzono koło");
                        System.out.print("\tPole: " + Jedna.Pole(promien));
                        System.out.println("\tObwod " + Jedna.Obwod(promien));

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
                            Jedna = Figury.JednaZmienna.KWADRAT;
                            System.out.println("Utworzono kwadrat");
                            System.out.print("\tPole: " + Jedna.Pole(bok1));
                            System.out.println("\tObwod " + Jedna.Obwod(bok1));
                        }
                        else if(bok1 == bok2 && bok1 == bok3 && bok1 == bok4)
                        {
                            Dwie = Figury.DwieZmienne.ROMB;
                            System.out.println("Utworzono romb");
                            System.out.print("\tPole: " + Dwie.Pole(bok1, kat));
                            System.out.println("\tObwod " + Dwie.Obwod(bok1, kat));
                        }
                        else if(bok1 == bok2 && bok3 == bok4 && kat == 90)
                        {
                            Dwie = Figury.DwieZmienne.PROSTOKAT;
                            System.out.println("Utworzono prostokąt");
                            System.out.print("\tPole: " + Dwie.Pole(bok1, kat));
                            System.out.println("\tObwod " + Dwie.Obwod(bok1, kat));
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
                        Jedna = Figury.JednaZmienna.PIECIOKAT;
                        double bok1 = Double.parseDouble(args[licznik]);
                        System.out.println("Utworzono pięciokąt");
                        System.out.print("\tPole: " + Jedna.Pole(bok1));
                        System.out.println("\tObwod " + Jedna.Obwod(bok1));
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
                        Jedna = Figury.JednaZmienna.SZESCIOKAT;
                        double bok1 = Double.parseDouble(args[licznik]);
                        System.out.println("Utworzono sześciokąt");
                        System.out.print("\tPole: " + Jedna.Pole(bok1));
                        System.out.println("\tObwod " + Jedna.Obwod(bok1));
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
        System.out.println("");
    }
}