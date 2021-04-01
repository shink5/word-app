#include <stdio.h>
#include <stdlib.h>
#define PI 3.14159
int main()
{

    double r,S,V;
    printf("input r:");
    scanf("%lf",&r);
    S=4*PI*r*r;
    V=(4/3)*PI*r*r*r;
    printf("S=%f\n",S);
    printf("V=%f\n",V);


    return 0;
}
