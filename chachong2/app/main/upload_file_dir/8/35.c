#include <stdio.h>
#include <stdlib.h>
#define pi 3.14159

int main()
{
    const double pi2=3.14159;
    double r,a,b;
    printf("请输入半径r:");
    scanf("%lf",&r);
    a=4*pi*r*r;
    b=(4.0/3.0)*pi2*r*r*r;
    printf("球表面积:%f\n",a);
    printf("球体积:%f\n",b);
    return 0;
}
