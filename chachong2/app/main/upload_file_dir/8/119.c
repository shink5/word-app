#include <stdio.h>
#include <stdlib.h>
#include <math.h>
int main()
{
  float a,b,c,p,s;
  printf("input a,b,c:");
  scanf("%f%f%f",&a,&b,&c);
  if(a+b>c&&a+c>b&&b+c>a)
  {
      p=(a+b+c)/2.0;
      s=sqrt(p*(p-a)*(p-b)*(p-c));
      printf("s=%f\n",s);
  }
  else printf("不是三角形\n");
      return 0;
}
