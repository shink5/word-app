#include <stdio.h>
#include <stdlib.h>

int main()
{
    double a,b,c,area,s;
    printf("Please input a:");
    scanf("%lf",&a);
    printf("Please input b:");
    scanf("%lf",&b);
    printf("Please input c:");
    scanf("%lf",&c);
    if(a+b>c)
    {
        s = (a+b+c)/2;
        area = (float)sqrt(s*(s-a)*(s-b)*(s-c));
        printf("area = %lf\n",area);
    }
    else
    {
        printf("NO");
    }

    return 0;
}
