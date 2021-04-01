#include <stdio.h>
#include <stdlib.h>
#define PI 3.1415926575898 //宏定义写法
int main()
{
    //const double pi=3.1415926575898
    //以上为const定义写法
    double r;
    printf("Number:190210605\n");
    printf("subject No.2-program No.1\n");
    printf("Please input r:\n");
    scanf("%lf",&r);
    printf("V=%lf\n",PI*r*r*r*4/3);
    printf("S=%lf\n",4*PI*r*r);
}
