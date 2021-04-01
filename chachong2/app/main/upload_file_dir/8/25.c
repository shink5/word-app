#include <stdio.h>
#include <stdlib.h>
#define PI 3.141592
int main()
{
    double r;
    printf("Input r:");
    scanf("%lf",&r);
    printf("area=%f\n",4*PI*r*r);
    printf("V=%f\n",(4*PI*r*r*r)/3);
    return(0);
}
