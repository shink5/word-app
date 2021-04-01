#include <stdio.h>
#include<math.h>
main()
{
    float a,b,c;
    double p,area;
    printf("number 190210621\n");
    printf("subject 2\n");
    printf("Please input a,b,c:");
    scanf("%f,%f,%f",&a,&b,&c);
    p=(a+b+c)/2.0;
    if(a+b>c&&b+c>a&&a+c>b)
    {
        area=sqrt(p*(p-a)*(p-b)*(p-c));
        printf("area=%f\n",area);
    }
    else
    {
        printf("不能构成三角形");
    }
}
