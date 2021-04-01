#include <stdio.h>
#include <math.h>
main()
{
    double a,b,c,S,p;
    printf("Please input a,b,c:");
    scanf("%lf,%lf,%lf",&a,&b,&c);
    if(a+b>c && fabs(a-b)<c)
    {
        printf("Right!\n");
        p=(a+b+c)/2.0;
        S=sqrt(p*(p-a)*(p-b)*(p-c));
        printf("S=%f\n",S);
}
    else
    {
        printf("Wrong!");
    }
    return 0;
}
