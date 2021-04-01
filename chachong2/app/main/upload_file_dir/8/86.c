#include <stdio.h>
#include<math.h>
main()
{
    double s,a,b,c,area;
    printf("Number:190210528\n");
    printf("Project:2 Program:2\n");
    printf("PLEASE INPUT a,b,c:");
    scanf("%lf,%lf,%lf",&a,&b,&c);
    if((a+b>c)&&(a+c>b)&&(b+c>a))
    {
        s = (a+b+c)/2;
        area = sqrt(s*(s-a)*(s-b)*(s-c));
        printf("area = %lf\n",area);
    }
    else
    {
        printf("IT'S INVALID");
    }
}
