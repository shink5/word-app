#include <stdio.h>
#include<math.h>
 main()
{
   float a,b,c,p,area;
   printf("please input a,b,c;");
   scanf("%f,%f,%f",&a,&b,&c);
   if(a+b>c&&a+c>b&&b+c>a)
   {
   p=(a+b+c)/2;
   area=(float)sqrt(p*(p-a)*(p-b)*(p-c));
    printf("area=%f\n",area);
   }
   else
    printf("it is not a triangle\n");
}
