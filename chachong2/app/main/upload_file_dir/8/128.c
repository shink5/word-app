#include <stdio.h>
#include <stdlib.h>
#include <math.h>
main()
{
    float a,b,c,p,s;
    printf("请输入三个正数\n");
    scanf("%f%f%f",&a,&b,&c);
    if((a+b>c)&&(a+c>b)&&(b+c>a))
    {
        printf("这三个数可以充当三角形的三边\n");
        p=(a+b+c)/2;
        s=sqrt(p*(p-a)*(p-b)*(p-c));
        printf("这个三角形的面积为%f\n",s);
    }
    else
        printf("这三个数不能构成三角形\n");
    return 0;
}
