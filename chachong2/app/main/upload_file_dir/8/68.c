#include <stdio.h>
#define  PI  3.14159
main()
{
    int r;
    double s,v;
    printf("Input r:");
    scanf("%d",&r);
    s=4*PI*r*r;
    v=(4*PI*r*r*r)/3.0;
    printf("s=%f,v=%f\n",s,v);
}
