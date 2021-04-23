#include <iostream>
#include <cmath>
#include "Szesciokat.h"

Szesciokat::Szesciokat(double bok)
{
    this->bok = bok;
}

double Szesciokat::obwod()
{
    return (6 * bok);
}

double Szesciokat::pole()
{
    return (3 * sqrt(3) * pow(bok, 2)/ 2 );
}

Szesciokat::~Szesciokat()
{
	
}