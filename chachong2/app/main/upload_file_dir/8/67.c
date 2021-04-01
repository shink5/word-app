#include <stdio.h>
main()
{
    const double  PI=3.14159;
    int r;
    double s,v;
    printf("Input r:");
    scanf("%d",&r);
    s=4.0*PI*r*r;
    v=(4*PI*r*r*r)/3.0;
    printf("s=%lf,v=%lf\n",s,v);
}
