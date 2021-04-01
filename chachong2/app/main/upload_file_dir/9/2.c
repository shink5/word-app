#include <stdio.h>
#include <stdlib.h>
#include<math.h>

int main()
{
    float a,b,c;//定义三角形的三个边长
    float area;//三角形的面积
    float p;//海伦公式中的p
    printf("Number:180210129\n");
    printf("Subject.2.program.2\n\n");
    printf("请输入三角形的三个边长a,b,c:");
    scanf("%f,%f,%f",&a,&b,&c);
    if(a+b>c && a+c>b && b+c>a)
    {
        p=(a+b+c)/2;
        area=sqrt(p*(p-a)*(p-b)*(p-c));
        printf("这个三角形的面积是：%f",area);
    }
    else
    {
        printf("这三边无法构成一个三角形");
    }
    return 0;
}
