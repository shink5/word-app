#include <stdio.h>
#include <math.h>
#define PI1 3.14159
main()
{
    double r,S,V;
    printf("Please input r:");
    scanf("%lf",&r);
    V=4./3.*PI1*r*r*r;
    S=4.*PI1*r*r;
    printf("V=%f,S=%f\n",V,S);
    const double PI2=3.14159;
    double e,C,P;
    printf("Please input e:");
    scanf("%lf",&e);
    C=4./3.*PI2*e*e*e;
    P=4.*PI2*e*e;
    printf("C=%f,P=%f",C,P);
    return 0;
}

