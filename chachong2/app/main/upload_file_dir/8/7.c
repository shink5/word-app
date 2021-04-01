#include<stdio.h>
#include<math.h>

main()
{
    printf("Number:190210503\nSubject:No.2  -  Program:No.2\n");
	float a,b,c,p,area;
    printf("input a,b,c:");
    scanf("%f,%f,%f",&a,&b,&c);
    p=(a+b+c)/2;
    if(a+b>c&&b+c>a&&a+c>b)
    {
        area=(float)sqrt(p*(p-a)*(p-b)*(p-c));
        printf("area=%f\n",area);
    }
    else
    printf("无法构成三角形!\n");
}
