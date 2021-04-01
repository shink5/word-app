#include <stdio.h>


int main()
{
    printf("no.190210626\nprogram2\n");
    const double PI=3.14159;
    const double A=1.33333;
    double r,s,v;
    char reply;
    do
    {

    printf("please enter a r:\n");
    scanf("%lf",&r);
    s=4*PI*r*r;
    v=A*PI*r*r*r;
    printf("s=%lf\n",s);
    printf("v=%lf\n",v);
    printf("want to continnue?\ny or n\n");
    scanf(" %c",&reply);
    }
    while(reply=='y');

    return 0;
}
