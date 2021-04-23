public class Pieciokat extends Figura
{
    private double bok;

    Pieciokat(double bok)
    {
        this.bok = bok;
    }

    public double obwod()
    {
        return (5 * bok);
    }

    public double pole()
    {
        return (Math.sqrt(25 + (10 * Math.sqrt(5))) * Math.pow(bok, 2)/4);
    }
}