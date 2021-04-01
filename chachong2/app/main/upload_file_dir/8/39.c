#include<stdio.h>
#include<math.h>
int main()
{
    double a,b,c;
    double p,r1,r2;
    printf("请输入三角形的三边\n");
    printf("input a,b,c\n");
    scanf("%lf %lf %lf",&a,&b,&c);
    if (a+b>c&&a+c>b&&b+c>a)
    {
        p=a/2+b/2+c/2;
        r1=p*(p-a)*(p-b)*(p-c);
        r2=sqrt(r1);
        printf("area=%lf",r2);
    }
    else
    {
        printf("三角形不存在");
    }
}
