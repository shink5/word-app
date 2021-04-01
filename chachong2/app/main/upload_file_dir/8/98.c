#include <stdio.h>
#include<math.h>
int main()
{
    double s,p,x;
    int a,b,c;
    printf("input a,b,c\n");
    scanf("%d %d %d",&a,&b,&c);
    if((a+b)>c&&(a+c)>b&&(b+c)>a)
    {
        p=(a+b+c)/2;
        x=p*(p-a)*(p-b)*(p-c);
        s=sqrt(x);
        printf("s=%lf",s);
    }
}
