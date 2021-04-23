public class Szesciokat extends Figura
{
    private double bok;

    Szesciokat(double bok)
    {
        this.bok = bok;
    }

    public double obwod()
    {
        return (6 * bok);
    }

    public double pole()
    {
        return (3 * Math.pow(bok, 2) * Math.sqrt(3) / 2);
    }
}