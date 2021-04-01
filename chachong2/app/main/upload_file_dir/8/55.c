#include <stdio.h>
#include <stdlib.h>
#include<math.h>
int main()
{
   float a,b,c,p;
   float area;
   printf("please input three sides of triangle:");
   scanf("%f,%f,%f",&a,&b,&c);
   if ((a+b)>c&&(a+c)>b&&(b+c)>a)
   {
       p=(a+b+c)/2;
       area = sqrt(p*(p-a)*(p-b)*(p-c));
   }
   else
    {printf("triangle is not exist!\n");
    }
    printf("the area of the triangle is:%f\n",area);









}
