#include <stdio.h>
#include <stdlib.h>
#define PI 3.141592

int main()
{
    const pi = 3.141592;
    printf("Number:190210612\nsubject No.1 - program No.1\n\n");
    double r;
    double s;
    double v;
    printf("请输入半径r：\n");
    scanf("%lf",&r);
    v = 4.0 / 3 * PI * r*r*r;
    s = 4.0 * pi * r * r;
    printf("球的体积为：%f\n球的表面积为：%f\n",v,s);
}
