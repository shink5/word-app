#include <stdio.h>
#include <stdlib.h>
#include <math.h>
int main()
{
    float a,b,c,s,p;
    cc: printf("输入三个正数作为边长；");
    scanf("%f,%f,%f",&a,&b,&c);
    if (a+b>c&&b+c>a&&a+c>b)
    {
        p=(0.5)*(a+b+c);
        s=sqrt(p*(p-a)*(p-b)*(p-c));
        printf("三角形面积=%f\n",s);
    }
    else
    {
      printf("不能构成三角形，请重新输入\n");
      goto cc;
    }
    system("pause");


    return 0;
}
