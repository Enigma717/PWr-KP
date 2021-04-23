#include "Figura.h"

class Kolo : public Figura
{
    private:
        double promien;
    public:
        Kolo(double promien);
        double obwod();
        double pole();
        ~Kolo();
};
