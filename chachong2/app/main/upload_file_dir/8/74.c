#include <stdio.h>
#include <stdlib.h>
#define PI1 3.1415926
main()
{
    const double PI2 =3.1415926;
    double r;
    printf("Input r:");
    scanf("%lf",&r);
    printf("S=%f\n",4*PI1*pow(r,2));
    printf("V=%f\n",(4.0/3)*PI2*pow(r,3));
}
