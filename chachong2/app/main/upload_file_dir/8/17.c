#include <stdio.h>
#include <stdlib.h>
#define PI 3.14159

int main()
{
    double r;
    printf("Input r:");
    scanf("%lf",&r);
    printf("volume=%f\n",4./3*PI*r*r*r);
    printf("surface area=%f\n",4*PI*r*r);
}
