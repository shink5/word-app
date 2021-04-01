#include <stdio.h>
#include <stdlib.h>
#include <math.h>
int main()
{   float a,b,c,p,square;
    printf("Number: 190210628\n");
    printf("subject No.2 - program No.1\n\n");
    printf("请输入三角形的三边正数a b c:\n");
    scanf("%f %f %f",&a,&b,&c);
    if(a+b>c && a+c>b && b+c>a)
    {
        printf("这三条边可以构成一个三角形\n");
        p=(a+b+c)/2;
        square=sqrt(p*(p-a)*(p-b)*(p-c));
        printf("这个三角形的面积为%f",square);
    }
    else
        printf("这三条边不可以构成一个三角形");
        return 0;
}
