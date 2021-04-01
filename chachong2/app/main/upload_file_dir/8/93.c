#include <stdio.h>
#include <math.h>

int main()
{
    printf("Number:190210505\n");
    printf("Subject NO.2-program NO.2\n");

    float a,b,c,p,area;
    printf("Input a,b,c:");
    scanf ("%f,%f,%f",&a,&b,&c);
    p=(a+b+c)/2;
    if(a+b>c && b+c>a && a+c>b)
       {
           area=(float)sqrt(p*(p-a)*(p-b)*(p-c));
           printf("area=%f\n",area);
       }
    else
        printf("无法构成三角形！\n");
}

