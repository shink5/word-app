#include <stdio.h>
#include <stdlib.h>
#include <math.h>
int main()
{
    printf("Number:190210602\n");
    printf("subject No.2 - program No.2\n\n");
    float a,b,c,n,s;
    printf("Please input a,b,c:");
    scanf("%f,%f,%f",&a,&b,&c);
    n = (a+b+c)/2;
    s = (float)sqrt(n*(n-a)*(n-b)*(n-c));
    if(a+b>c&&a+c>b&&b+c>a)
    {
        printf("能构成三角形\n");
        printf("S=%f\n",s);
    }
    else
    {
        printf("不能构成三角形\n");
    }
    return 0;
}
