public class Test
{
    public static void main(String args[])
    {
        try
        {
            if(Integer.parseInt(args[0]) < 0)
            {
                System.out.println("Nieprawidłowy numer wiersza");
            }
            else
            {
                WierszTrojkataPascala Obj = new WierszTrojkataPascala(Integer.parseInt(args[0]));
                    
                System.out.println("Wiersz numer: " + args[0] + "\n");
                    
                for(int i = 1; i < args.length; i++)
                {
                    try
                    {
                        System.out.println("Element numer " + (Integer.parseInt(args[i]) + 1) + ": " + Obj.wspolczynnik(Integer.parseInt(args[i])));
                    }
                    catch(ArrayIndexOutOfBoundsException e)
                    {
                        System.out.println("Liczba spoza zakresu");
               
                    }
                }
            }
        }
        catch(NumberFormatException e)
        {
            System.out.println("Nieprawidłowa dana");
        }
        
    }
}