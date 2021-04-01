#include <stdio.h>
#include <stdlib.h>

int main()
{
    const double PI=3.1415926;
    double r,S,V;
    printf("输入球的半径");
    printf("r=");
    scanf("%lf",&r);
    S=4*PI*r*r;
    V=PI*r*r*r*4/3;
    printf("球的面积为%f，球的体积为%f",V,S);
}
