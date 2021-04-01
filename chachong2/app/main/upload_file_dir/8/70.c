#include <stdio.h>
#include <stdlib.h>
#define PI 3.14159
#define A 1.33333

int main()
{
    printf("no.190210626\nprogram2\n");
    double r,s,v;
    char reply;
    do
    {

    printf("please enter a r:\n");
    scanf("%lf",&r);
    s=4*PI*r*r;
    v=A*PI*r*r*r;
    printf("s=% .4lf\n",s);
    printf("v=% .4lf\n",v);
    printf("want to continnue?\ny or n\n");
    scanf(" %c",&reply);
    }
    while(reply=='y');

    return 0;
}
