#pragma once
#include "Czworokat.h"

class Romb: public Czworokat
{
    private:
        double bok;
        double kat;
    public:
        Romb(double bok, double kat);
        double obwod();
        double pole();
        ~Romb();
};