#include <stdio.h>
main()
{
    const double PI=3.14159;
    double r;
    printf("please input r:");
    scanf("%lf",&r);
    printf("volume=%f\n",4.0/3*PI*r*r*r);
    printf("circumference=%f\n",4*PI*r*r);

}
