#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main()
{
    float a,b,c,s,area;
    printf("Input a,b,c:");
    scanf("%f,%f,%f",&a,&b,&c);
    if(a+b>c)
    {
        if(a+c>b)
        {
            if(c+b>a)

            {
                printf("以a,b,c为边长可构成三角形。\n");
                s=(a+b+c)/2.;
                area=(float)sqrt(s*(s-a)*(s-b)*(s-c));
                printf("area=%f\n",area);
            }
            else
                printf("以a,b,c为边长不可构成三角形。\n");
        }
        else
            printf("以a,b,c为边长不可构成三角形。\n");
    }
    else
        printf("以a,b,c为边长不可构成三角形。\n");


}

