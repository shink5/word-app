#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main()
{   printf("Number:190210521\n");
    printf("Subject No.2-Program No.2\n");
    double a=0,b=0,c=0,p=0;
    printf("a=");
    scanf("%lf",&a);
    printf("b=");
    scanf("%lf",&b);
    printf("c=");
    scanf("%lf",&c);

    if (a+b<=c||a+c<=b||b+c<=a)
{
    printf("it is not a triangle");
}
    else
{
        printf("it is a triangle\n");
        p=(a+b+c)/2;
        printf("s=%lf",sqrt(p*(p-a)*(p-b)*(p-c)));
}
    return 0;
}
