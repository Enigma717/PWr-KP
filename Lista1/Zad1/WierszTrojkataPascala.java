public class WierszTrojkataPascala
{
    private int[] wiersz;

    public WierszTrojkataPascala(int n)
    {
        wiersz = new int[n+1];

        wiersz[0] = 1;

        for (int i = 0; i < n; i++)
        {
            for (int j = i + 1; j > 0; j--)
            {
                wiersz[j] += wiersz[j-1];   
            }      
        }

    }

    public int wspolczynnik(int m)
    {
       return wiersz[m];
    }
}
