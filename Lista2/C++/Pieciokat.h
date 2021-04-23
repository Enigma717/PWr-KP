#include "Figura.h"

class Pieciokat : public Figura
{
    private:
        double bok;
    public:
        Pieciokat(double bok);
        double obwod();
        double pole();
        ~Pieciokat();
};