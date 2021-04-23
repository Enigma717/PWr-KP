#include "Figura.h"

class Szesciokat : public Figura
{
    private:
        double bok;
    public:
        Szesciokat(double bok);
        double obwod();
        double pole();
        ~Szesciokat();
};