#include <iostream>
#include <cmath>
#include "Pieciokat.h"

Pieciokat::Pieciokat(double bok)
{
    this->bok = bok;
}

double Pieciokat::obwod()
{
    return (5 * bok);
}

double Pieciokat::pole()
{
    return (sqrt(25 + 10 * sqrt(5))  * pow(bok, 2) / 4);
}

Pieciokat::~Pieciokat()
{
	
}