#include <stdio.h>
#include <stdlib.h>
int main()
{
    const double PI = 3.141592;
    double r;
    printf("Input r:");
    scanf("%lf",&r);
    printf("area=%f\n",4*PI*r*r);
    printf("V=%f\n",(4*PI*r*r*r)/3);
    return(0);
}



