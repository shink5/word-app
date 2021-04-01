#include <stdio.h>
#include <math.h>

int main()
{
    float a,b,c,s,area;
    printf("输入三角形的三边\n a,b,c:");
    scanf("%f,%f,%f",&a,&b,&c);
    if(a+b>c&&b+c>a&&a+c>b)
    {
        s=(a+b+c)/2;
        area=sqrt(s*(s-a)*(s-b)*(s-c));
        printf("三角形的面积为%f\n",area);
    }
    else
    {
        printf("无法构成三角形\n");
    }
    return(0);
}
