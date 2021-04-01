#include <stdio.h>
#include <stdlib.h>

int main()
{
    printf("Number190210601\n");
    printf("subject2 program2\n\n");
    float a,b,c;
    float area;
    float p;//海伦公式
    printf("Input a,b,c:");
    scanf("%f,%f,%f",&a,&b,&c);
    if(a+b>c && b+c>a && a+c>b)
    {
        p=(a+b+c)/2;
        area=sqrt(p*(p-a)*(p-b)*(p-c));
        printf("三角形面积是：%f",area);
    }
        else
    {

           printf("a,b,c不构成三角形");
    }
    return 0;


}
