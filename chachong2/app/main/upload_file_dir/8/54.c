#include <stdio.h>
#include<math.h>
int main()
{
    float a,b,c,p,area;
    printf("input a,b,c");
    scanf("%f,%f,%f",&a,&b,&c);
    if(a+b>c&&a-b<c)
    {
        p=(a+b+c)/2;
        area=(float)sqrt(p*(p-a)*(p-b)*(p-c));
        printf("area=%f\n",area);
    }
    else
    {
        printf("这三条边无法构成三角形\n");
    }

}
