#include <stdio.h>
#include <stdlib.h>
#include<math.h>

int main()
{
    printf("Number:190210526\n");
    printf("subject No.2-program No.2\n\n");
    double a,b,c,p,S;
    printf("请输入三角形的三边长:");
    scanf("%lf%lf%lf",&a,&b,&c);
    if(a+b<=c||a+c<=b||b+c<=a)
    {
        printf("这不是一个三角形\n");
    }
    else
        {
            p=(a+b+c)/2;
            S=sqrt(p*(p-a)*(p-b)*(p-c));
            printf("三角形面积=%lf\n",S);
        }
    return 0;
}
