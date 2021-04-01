#include <stdio.h>
#include <stdlib.h>
#include <math.h>
int main()
{
    float a,b,c,s,p;
    RE:printf("请输入三角形的三条边：\n");
    scanf("%f,%f,%f",&a,&b,&c);
    if(a+b>c&&b+c>a&&a+c>b)
    {
      p=(a+b+c)/2;
      s=sqrt(p*(p-a)*(p-b)*(p-c));
      printf("三角形面积为:%f\n",s);
    }
    else
    {
       printf("输入三边有错\n");
       goto RE;
    }

    return 0;
}
