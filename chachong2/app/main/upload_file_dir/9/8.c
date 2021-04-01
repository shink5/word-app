#include <stdio.h>
#include <stdlib.h>
#define pi 3.1415926
int main()
{
    const double ppi = pi;
    double r;

    printf("num:190210504\n exp_2\n");
    printf("please input r:");
    scanf("%lf",&r);
    double ti = 4.0/3.0;
    ti*=r*r*r*pi;
    double tj=4.0;
    tj*=pi*r*r;
    printf("the volume of sphere is %lf\n",ti);
    printf("the surface area of sphere is %lf\n",tj);
    return 0;
}
