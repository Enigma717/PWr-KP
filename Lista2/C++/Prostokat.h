#pragma once
#include "Czworokat.h"

class Prostokat : public Czworokat
{
    private:
        double bok1;
        double bok2;
    public:
        Prostokat(double bok1, double bok2);
        double obwod();
        double pole();
        ~Prostokat();
};