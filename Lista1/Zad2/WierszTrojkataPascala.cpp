class WierszTrojkataPascala
{
    private:
        int* wiersz = NULL;

    public: 
        WierszTrojkataPascala(int n)
        {
            wiersz = new int[n + 1];

            wiersz[0] = 1;

            for (int i = 0; i < n; i++)
            {
                for (int j = i + 1; j > 0; j--)
                {
                    wiersz[j] += wiersz[j-1];   
                }      
            }
        }

        int wspolczynnik(int m)
        {
            return wiersz[m];
        } 

    ~WierszTrojkataPascala()
    {
        delete[] wiersz;
    }
};