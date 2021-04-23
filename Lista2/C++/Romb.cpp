#include <iostream>
#include <cmath>
#include "Romb.h"

Romb::Romb(double bok, double kat)
{
    this->bok = bok;
    this->kat = kat;
}

double Romb::obwod()
{
    return (4 * bok);
}

double Romb::pole()
{
    return (pow(bok, 2) * sin(kat * (3.14/180)));
}

Romb::~Romb()
{
    
}
