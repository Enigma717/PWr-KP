#include <iostream>
#include <cmath>
#include "Prostokat.h"

Prostokat::Prostokat(double bok1, double bok2) 
{
    this->bok1 = bok1;
    this->bok2 = bok2;
}

double Prostokat::obwod()
{
    return ((2 * bok1) + (2 * bok2));
}

double Prostokat::pole()
{
    return (bok1 * bok2);
}

Prostokat::~Prostokat()
{
    
}