#include <stdio.h>
#include<math.h>
int main()
{
   printf("Number:190210511\nsubject No.2-program No.2\n");
   double a,b,c,S,p;
   start:printf("请输入三角形第一条边的值：");
   scanf("%lf",&a);
   printf("请输入三角形第二条边的值：");
   scanf("%lf",&b);
   printf("请输入三角形第三条边的值：");
   scanf("%lf",&c);
   if(a+b>c&&b+c>a&&a+c>b)
   {
       p=(a+b+c)/2;
       S=sqrt(p*(p-a)*(p-b)*(p-c));
       printf("三角形的面积是：%lf",S);
   }
   else
   {
       printf("a、b、c三条边无法构成三角形，请重新输入。\n");
       goto start;
   }
}
