#include <stdio.h>
#include <math.h>

int main()
{
    printf("Number£º190210501\nSubject:No.2  -  Program:No.2\n");
    double a,b,c,p,area;
    printf("Input a,b,c:");
    scanf("%lf,%lf,%lf",&a,&b,&c);
    p=(a+b+c)/2;
    if(a+b>c && b+c>a && a+c>b)
         {
             area=(double)sqrt(p*(p-a)*(p-b)*(p-c));
             printf("Area of the triangle=%f\n",area);
         }
    else
         printf("the graph is not a triangle\n");
}

