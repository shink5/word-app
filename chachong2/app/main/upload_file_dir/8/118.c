#include <stdio.h>
#include <stdlib.h>

int main()
{
   const double pi=3.1415;
   double r,s,v;
   printf("input r:");
   scanf("%lf",&r);
   s=4*pi*r*r;
   v=(4/3)*pi*r*r*r;
   printf("s=%f\n",s);
   printf("v=%f\n",v);

    return 0;
}
