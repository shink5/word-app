#include <stdio.h>
#include <stdlib.h>
#include<math.h>

int main()
{
    printf("Number:190210606\nsubject No.2- program No.2\n");
  int a,b,c,p;
  float s;
  printf("input the side length of the triangular,a=  ,b=  ,c=   \n");
  scanf("%d,%d,%d",&a,&b,&c);

  if(a+b>c&&a+c>b&&b+c>a)
   {
     p=a+b+c;
     s=sqrt(p*(p-a)*(p-b)*(p-c));
    printf("s=%f\n",s);
   }
  else
    printf("error");

return 0;
}
