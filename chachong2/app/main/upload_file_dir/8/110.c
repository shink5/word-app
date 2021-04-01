#include <stdio.h>
#include<math.h>
int main()
{
    printf("Number:190210618\n");
    printf("subject No.2 - program No.3\n");
    double a,b,c,s,h;
    printf("请输入三角形的三个边长（中间用空格分隔）：");
    scanf("%lf %lf %lf",&a,&b,&c);
    if((a+b)>c && (a+c)>b && (c+b)>a)
    {
        s=(a+b+c)/2;
        h=sqrt(s*(s-a)*(s-b)*(s-c));
        printf("%lf",h);
    }
    else printf("输入的三边无法构成三角形");
    return 0;
}
