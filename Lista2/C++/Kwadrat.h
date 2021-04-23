#pragma once
#include "Czworokat.h"

class Kwadrat : public Czworokat
{
    private:
        double bok;
    public:
        Kwadrat(double bok);
        double obwod();
        double pole();
        ~Kwadrat();
};