#include <iostream>
#include "WierszTrojkataPascala.cpp"

using namespace std;

int main(int n, char* args[])
{
    WierszTrojkataPascala *wsk = NULL;

    try
    {
        wsk = new WierszTrojkataPascala(stoi(args[1]));         

        for(int i = 2; i < n; i++)
        {
            if(args[i] == 0)
            {
                cout << "Liczba spoza zakresu" << endl;
            }
            else
            {
                cout << "Element numer " << i - 1 << ": " << wsk -> wspolczynnik(stoi(args[i])) << endl;
            }
        }
    }
    catch(bad_array_new_length)
    {
        cout << "Nieprawidlowy numer wiersza" << endl;
        return -1;
    }
    catch(invalid_argument)
    {
        cout << "Nieprawidlowy numer wiersza" << endl;
        return -1;
    }
        
    delete wsk;

    return 0;
}