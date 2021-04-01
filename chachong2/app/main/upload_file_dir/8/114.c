#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#define Pi 3.14159
int main()
{
    double r;
    printf("请输入半径:");
    scanf("%lf",&r);
    printf("球的体积=%f,球的表面积=%f\n",4/3*Pi*r*r*r,4*Pi*r*r);
}
