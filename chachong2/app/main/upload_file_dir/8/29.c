#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main()
{
    double a,b,c,p,S;
    scanf("%lf,%lf,%lf",&a,&b,&c);
    if(a+b>c)
    {
        if(a+c>b)
        {
            if(b+c>a)
            {
                p=(a+b+c)/2;
                printf("可以构成三角形");
                S = sqrt(p*(p-a)*(p-b)*(p-c));
                printf("S = %lf",S);
            }
            else
                printf("不可以构成三角形");
        }
        else
                printf("不可以构成三角形");
    }
    else
                printf("不可以构成三角形");

}
