#include <stdio.h>
#include <stdlib.h>

int main()
{
    double a,b,c,p,S;
    printf("欢迎使用本软件\n请输入三个正数，之间用空格连接");
    scanf("%lf%lf%lf",&a,&b,&c);
    if(a+b>=c&&b+c>=a&&c+a>=b)
    {
      p=(a+b+c)/2;
      S=sqrt(p*(p-a)*(p-b)*(p-c));
      printf("S=%lf\n",S);
    }
    else
      printf("对不起，您输入的三角形不存在\n");
    return 0;
}
