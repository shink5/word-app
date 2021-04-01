#include <stdio.h>
#include <stdlib.h>
#include <math.h>
int main()
{
    printf ("Number 190210607\n");
    printf ("subject No.2-Program No.2\n\n");
    double a,b,c,p,area;
    printf ("input:a,b,c\n");
    scanf ("%lf,%lf,%lf",&a,&b,&c);
    if (a+b>c&&a+c>b&&b+c>a)
        {
            p=(a+b+c)/2;
            area=sqrt(p*(p-a)*(p-b)*(p-c));
            printf ("area=%f\n",area);
        }
    else
        {
        printf ("wrong number\n");
        }
}
