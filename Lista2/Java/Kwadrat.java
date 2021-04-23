public class Kwadrat extends Czworokat
{
    private double bok;

    Kwadrat(double bok)
    {
        this.bok = bok;   
    }

    public double obwod()
    {
        return (4 * bok);
    }

    public double pole()
    {
        return (Math.pow(bok, 2));
    }
}