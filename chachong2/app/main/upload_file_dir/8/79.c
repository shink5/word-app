#include <stdio.h>
#include <stdlib.h>
#include<math.h>
int main()
{
    printf("Number:190210629\n");
    printf("subject 2-No.2\n");
    float a,b,c,p,s;
    printf("Please input three numbers");
    scanf("%f,%f,%f",&a,&b,&c);
    if((a+b>c)&&(b+c>a)&&(a+c>b))
    {
       p=(a+b+c)/2;
       s=sqrt(p*(p-a)*(p-b)*(p-c));
       printf("%lf",s);

    }
    else
    {
        printf("the trangle don't exist,");
    }
    return 0;
}
