public class Romb extends Czworokat
{
    private double bok;
    private double kat;

    Romb(double bok, double kat)
    {
        this.bok = bok;
        this.kat = kat;
    }

    public double obwod()
    {
        return (4 * bok);
    }

    public double pole()
    {
        return (Math.pow(bok, 2) * Math.sin(Math.toRadians(kat)));
    }
}