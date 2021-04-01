#include <stdio.h>
#include <stdlib.h>
#include <math.h>
int main()
{
    float a,b,c;
    float p;
    printf("请输入三边长度;");
    scanf("%f %f %f",&a,&b,&c);
    p=(a+b+c)/2;
    if(a+b>c && a+c>b && b+c>a)
    {
        printf("三角形的面积=%lf",sqrt(p*(p-a)*(p-b)*(p-c)));
    }
    else
    {
        printf("三角形不存在 DNMD");
    }
}
