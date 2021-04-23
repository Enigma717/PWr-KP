#include <iostream>
#include <cmath>
#include "Kolo.h"

Kolo::Kolo(double promien)
{
    this->promien = promien;
}

double Kolo::obwod()
{
    return (2 * 3.14 * promien);
}

double Kolo::pole()
{
    return (3.14 * pow(promien, 2));
}

Kolo::~Kolo()
{
    
}