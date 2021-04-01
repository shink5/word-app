#include <stdio.h>
#include <stdlib.h>
#include<math.h>
int main()
{
    double a,b,c,d,e,f,g;
    printf("请输入a=");
    scanf("%lf",&a);
    printf("请输入b =");
    scanf("%lf",&b);
    printf("请输入c =");
    scanf("%lf",&c);
    if(a>b)
    {
        if(a>c)
        {
            d=a;
        }
        else
        {
            d=c;
        }
    }
    else
        {
            if(b>c)
            {
                d=b;
            }
            else
            {
                d=c;
            }
        }
    if(a+b+c-d<=d)
    {
        printf("不是三角形");
    }
    else
    {
        f=(a+b+c)/2;
        g=f*(f-a)*(f-b)*(f-c);
        e=sqrt(g);
        printf("S=%lf",e);
    }
    return 0;
}
