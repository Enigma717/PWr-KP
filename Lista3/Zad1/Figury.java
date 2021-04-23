interface JednaZmiennaOblicz
{
    public double Obwod(double x);
    public double Pole(double x);
}

interface DwieZmienneOblicz
{
    public double Obwod(double x, double y);
    public double Pole(double x, double y);
}

public class Figury
{
    public enum JednaZmienna implements JednaZmiennaOblicz
    {
        KOLO
        {
            public double Obwod(double promien)
            {
                return (2 * 3.14 * promien);
            }
            public double Pole(double promien)
            {
                return (3.14 * Math.pow(promien, 2));
            }
        },
        KWADRAT
        {
            public double Obwod(double bok)
            {
                return (4 * bok);
            }
            public double Pole(double bok)
            {
                return (Math.pow(bok, 2));
            }
        },
        PIECIOKAT
        {
            public double Obwod(double bok)
            {
                return (5 * bok);
            }
            public double Pole(double bok)
            {
                return (Math.sqrt(25 + (10 * Math.sqrt(5))) * Math.pow(bok, 2)/4);
            }
        },
        SZESCIOKAT
        {
            public double Obwod(double bok)
            {
                return (6 * bok);
            }
            public double Pole(double bok)
            {
                return (3 * Math.pow(bok, 2) * Math.sqrt(3) / 2);
            }
        };
    };
    public enum DwieZmienne implements DwieZmienneOblicz
    {
        PROSTOKAT
        {
            public double Obwod(double bok1, double bok2)
            {
                return ((2 * bok1) + (2 * bok2));
            }

            public double Pole(double bok1, double bok2)
            {
                return (bok1 * bok2);
            }
        },
        ROMB
        {
            public double Obwod(double bok, double kat)
            {
                return (4 * bok);
            }

            public double Pole(double bok, double kat)
            {
                return (Math.pow(bok, 2) * Math.sin(Math.toRadians(kat)));
            }
        };
    };
}