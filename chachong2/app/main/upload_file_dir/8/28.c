#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main()
{
    printf("Number:190210516 \n");
    printf("subject No.2 - program No.2\n\n");

    double a = 0, b = 0, c = 0;
    double p = 0;

    printf("请输入三角形的三条边:");
    scanf("%lf %lf %lf", &a, &b, &c);
    if (!(a > 0 && b > 0 && c > 0)){
        printf("请输入正数");
        exit(-1);
    }
    if(a + b > c && a + c > b && b + c > a){
        p = (a + b + c) / 2.0;
        printf("三角形的面积是：%f", sqrt(p * ( p - a) * (p - b) * (p - c)));
    }
    else{
        printf("输入三边不成三角");
    }
    return 0;
}
