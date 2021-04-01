#include <stdio.h>
#include <stdlib.h>
#include <math.h>
int main()
{
    printf("Number:190210509\nSubject2 Program1\n");
    float a,b,c,p,area;

            printf("Input a,b,c:");
            scanf("%f,%f,%f",&a,&b,&c);
            if(a+b>c&&b+c>a&&a+c>b)
                {
                    p=(a+b+c)/2;
                    area=(float)sqrt(p*(p-a)*(p-b)*(p-c));
                    printf("area=%f\n",area);
                }
            else
                printf("a,b,c构不成三角形。\n");

    return 0;
}
