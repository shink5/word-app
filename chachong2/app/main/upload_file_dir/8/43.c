#include <stdio.h>
#include <stdlib.h>

int main()
{
    printf("Number:190210605\n");
    printf("subject No.2-program No.2\n");
    double a,b,c;
    printf("Please input a,b,c:\n");
    scanf("%lf,%lf,%lf",&a,&b,&c);
    double p=(a+b+c)/2;
    double s=sqrt(p*(p-a)*(p-b)*(p-c));
    if ((a+b>c) && (a+c>b) && (b+c>a))
    {
        printf("Yes!\n");
        printf("S=%lf\n",s);
    }
    else
        printf("No!\n");
}
