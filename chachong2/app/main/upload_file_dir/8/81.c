#include <stdio.h>
#include <stdlib.h>
#define PI 3.1415926
int main()
{
    float r,S,V;
    printf("输入球的半径r=");
    scanf("%f",&r);
    S=4*PI*r*r;
    V=PI*r*r*r*4/3;
    printf("球的体积为%f，球的表面积为%f\n",V,S);

}
