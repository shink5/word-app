#include <stdio.h>
#include <stdlib.h>

int main()
{
    const double PI=3.14159;
    double r;
    printf("Input r:");
    scanf("%lf",&r);
    printf("volume=%f\n",4./3*PI*r*r*r);
    printf("surface area=%f\n",4*PI*r*r);

}
