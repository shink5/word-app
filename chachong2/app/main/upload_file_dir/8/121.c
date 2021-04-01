#include <stdio.h>
#include <stdlib.h>
#include <math.h>
double max(double a,double b);

int main()
{
    printf("Number:190210603\n");
   printf("suject NO.2- program NO.2\n");
    double a,b,c,d,p,x,r;
    printf("input a=");
    scanf("%lf",&a);
    printf("input b=");
    scanf("%lf",&b);
    printf("input c=");
    scanf("%lf",&c);
    d = max(max(a,b),c);
    p = (a+b+c)/2;
    x = p*(p-a)*(p-b)*(p-c);
    r = sqrt(x);
    if(a+b+c-d<=d)
        printf("cant build a triangle");
    else
        printf("area=%lf",r);
    return 0;
}
double max(double a,double b)//函数先定义
{
    double max;
    if(a>b)
        max =a;
    else
        max =b;
    return max;
}
