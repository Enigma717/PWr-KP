#include <iostream>
#include <cmath>
#include "Kwadrat.h"

Kwadrat::Kwadrat(double bok)
{
    this->bok = bok;
}

double Kwadrat::obwod()
{
    return (4 * bok);
}

double Kwadrat::pole()
{
    return (pow(bok, 2));
}

Kwadrat::~Kwadrat()
{

}
