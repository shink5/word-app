#include <stdio.h>
#include <stdlib.h>

int main()
{
    printf ("Number:190210607\n");
    printf ("subject NO.2-program NO.1\n\n");
    double r,S1,V1;
    #define PI 3.14159
    printf ("Input r:\n");
    scanf ("%lf",&r);
    printf ("S1=%f\n",4*PI*r*r);
    printf ("V1=%f\n",4.0/3*PI*r*r*r);
    const double Pi=3.14159;
    double R,S2,V2;
    printf ("Input R:\n");
    scanf ("%lf",&R);
    printf ("S2=%f\n",4*Pi*R*R);
    printf ("V2=%f\n",4.0/3*Pi*R*R*R);
}
