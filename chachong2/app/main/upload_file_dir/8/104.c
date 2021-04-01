#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#define PI 3.14159

int main()
{
    printf("Number:190210613\nsubject No.2 program No.1\n");
    const double pi=3.14159;
    int r;
    printf("请输入r=");
    scanf("%d",&r);
    double a,b;
    a=4.0/3*PI*pow(r,3);
    b=4*pi*pow(r,2);
    printf("球的体积为%f,球的表面积为%f\n",a,b);
    system("pause");
    return 0;
}
