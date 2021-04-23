public class Kolo extends Figura
{
    private double promien;

    Kolo(double promien)
    {
        this.promien = promien;
    }

    public double obwod()
    {
        return (2 * 3.14 * promien);
    }

    public double pole()
    {
        return (3.14 * Math.pow(promien, 2));
    }
}