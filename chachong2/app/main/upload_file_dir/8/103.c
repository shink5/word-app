#include <stdio.h>
#include <math.h>
#define EPS  1e-1
main()
{
    float a,b,c,area;
    printf("Input a,b,c:");
    scanf("%f,%f,%f",&a,&b,&c);
    s=(a+b+c)/2;
    if(a+b>c && b+c>a && a+c>b);
    {
        printf("是三角形");
        area=(float)sqrt(s*(s-a)*(s-b)*(s-c));
        printf("area = %f\n",area);
    }
    else
    {
        printf("不是三角形")；
    }
}
