#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#define Pi 3.14159
int main()
{
    printf("Number:190210602\n");
    printf("subject No.2 - program No.1\n\n");
    const double PI = 3.14159;
    double r;
    printf("Please input R1:");
    scanf("%lf",&r);
    printf("S=%f\n",4*PI*r*r);
    printf("V=%f\n",4*PI*r*r*r/3);
    double a;
    printf("Please input R2:");
    scanf("%lf",&a);
    printf("S=%f\n",4*Pi*a*a);
    printf("V=%f\n",4*Pi*a*a*a/3);
    return 0;
}
