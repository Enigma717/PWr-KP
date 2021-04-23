public class Prostokat extends Czworokat
{
    private double bok1, bok2;

    Prostokat(double bok1, double bok2)
    {
        this.bok1 = bok1;
        this.bok2 = bok2;
   }

    public double obwod()
    {
        return ((2 * bok1) + (2 * bok2));
    }

    public double pole()
    {
        return (bok1 * bok2);
    }
}