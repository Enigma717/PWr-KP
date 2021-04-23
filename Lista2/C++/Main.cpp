#include <iostream>
#include <cmath>
#include <string>
#include "Kwadrat.h"
#include "Romb.h"
#include "Prostokat.h"
#include "Kolo.h"
#include "Pieciokat.h"
#include "Szesciokat.h"

using namespace std;

int main(int argc, char* args[])
{

    if(argc == 1)
    {
        cout << "Nie podano żadnych argumentów!";
        return 1;
    }

    string typyfigur = args[1];
    int licznik = 2;

    try
    {

        for(int i = 0; i < typyfigur.length(); i++)
        {
            if(typyfigur[i] == 'o')
            {
                if(atof(args[licznik]) > 0)
                {
                    Kolo *NowyKolo = new Kolo(atof(args[licznik]));
                    cout << "Utworzono koło\n\t";
                    cout << "Obwód: " << NowyKolo->obwod() << "\tPole: " << NowyKolo->pole() << "\n";
                }
                else
                {
                    cout << "Długość promienia musi być większa od 0!\n";
                }

                licznik++;
            }
            else if(typyfigur[i] == 'c')
            {
                double bok1 = atof(args[licznik]);
                licznik++;
                double bok2 = atof(args[licznik]);
                licznik++;
                double bok3 = atof(args[licznik]);
                licznik++;
                double bok4 = atof(args[licznik]);
                licznik++;
                double kat = atof(args[licznik]);
                licznik++;

                if(bok1 > 0 && bok2 > 0 && bok3 > 0 && bok4 > 0 && kat > 0 && kat < 180)
                {
                    if(bok1 == bok2 && bok1 == bok3 && bok1 == bok4 && kat == 90)
                        {
                            Kwadrat *NowyKwadrat = new Kwadrat(bok1);
                            cout << "Utworzono kwadrat\n\t";
                            cout << "Obwód: " << NowyKwadrat->obwod() << "\tPole: " << NowyKwadrat->pole() << "\n";
                        }
                        else if(bok1 == bok2 && bok1 == bok3 && bok1 == bok4)
                        {
                            Romb *NowyRomb = new Romb(bok1, kat);
                            cout << "Utworzono romb\n\t";
                            cout << "Obwód: " << NowyRomb->obwod() << "\tPole: " << NowyRomb->pole() << "\n";
                        }
                        else if(bok1 == bok2 && bok3 == bok4 && kat == 90)
                        {
                            Prostokat *NowyProstokat = new Prostokat(bok1, bok3);
                            cout << "Utworzono prostokąt\n\t";
                            cout << "Obwód: " << NowyProstokat->obwod() << "\tPole: " << NowyProstokat->pole() << "\n";
                        }
                        else
                        {
                            cout << "Nieznany czworokąt!\n";
                        }
                }
                else
                {
                    cout << "Długości boków i wielkości kątów muszą byc więskze od 0!\n";
                }
            }
            else if(typyfigur[i] == 'p')
            {
                if(atof(args[licznik]) > 0)
                {
                    Pieciokat *NowyPieciokat = new Pieciokat(atof(args[licznik]));
                    cout << "Utworzono pięciokąt\n\t";
                    cout << "Obwód: " << NowyPieciokat->obwod() << "\tPole: " << NowyPieciokat->pole() << "\n";
                }
                else
                {
                    cout << "Długość boku musi być większa od 0!\n";
                }
                
                licznik++;
            }
            else if(typyfigur[i] == 's')
            {
                if(atof(args[licznik]) > 0)
                {
                    Szesciokat *NowySzesciokat = new Szesciokat(atof(args[licznik]));
                    cout << "Utworzono sześciokąt\n\t";
                    cout << "Obwód: " << NowySzesciokat->obwod() << "\tPole: " << NowySzesciokat->pole() << "\n";
                }
                else
                {
                    cout << "Długość boku musi być większa od 0!\n";
                }
                
                licznik++;
            }
            else
            {

            }
        }
    }
    catch(bad_array_new_length)
    {
        cout << "Niepoprawna liczba danych!";
    }
    catch(invalid_argument)
    {
        cout << "Nieprawidłowe dane!";
    }

    return 0;
}