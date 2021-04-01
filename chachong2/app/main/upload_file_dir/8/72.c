#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main()
{
    printf("no.190210626\nprogram2\n");
    double a,b,c,p,s;
    char reply;
    do
    {

    printf("please input the sides of triangle:a b c\n");
    scanf("%lf %lf %lf",&a, &b, &c);
    if(a+b>c&&a+c>b&&b+c>a)
    {
        printf("it is a triangle!\n");
        p=(a+b+c)/2;
        s=sqrt(p*(p-a)*(p-b)*(p-c));
        printf("s=% .4lf\n",s);

    }
    else
    {
        printf("it is not a triangle!\n");
    }
    printf("want to continnue?\ny or n\n");
    scanf(" %c", &reply);
    }while(reply=='y');
    return 0;
}
