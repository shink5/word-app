#include <stdio.h>
#include <stdlib.h>

int main()
{
    float a,b,c;
    float p,S;
    printf("输入三角形的三边长度：a,b,c\n");
    printf("a=");
    scanf("%f",&a);
    printf("b=");
    scanf("%f",&b);
    printf("c=");
    scanf("%f",&c);
    if (a+b>c&&b+c>a&&a+c>b)
       {
         p=(a+b+c)/2;
         S=sqrt(p*(p-a)*(p-b)*(p-c));
         printf("三角形的面积为%f",S);
       }
    else {
            printf("这个三角形不存在");
    }
}
