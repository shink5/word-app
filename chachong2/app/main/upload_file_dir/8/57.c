#include <stdio.h>
#include <stdlib.h>
#define PI 3.1415926
int main()
{
    float V,S,r;
    printf("请输入球的半径r:\n");
    scanf("%f",&r);
    V=4/3*PI*r*r*r;
    S=4*PI*r*r;
    printf("球面积S为：%f\n",S);
    printf("球体积V:%f\n",V);

    return 0;
}
