#include <stdio.h>
#define PI1 3.14159
main()
{
    double r;
    const double PI2=3.14159;
    printf("Number:190210507\n");
    printf("subject No.2-program No.1\n");
    printf("Please input r:");
    scanf("%lf",&r);
    printf("cubical measure=%f\n",(4.0/3)*PI1*r*r*r);
    printf("surface area=%f\n",4*PI1*r*r);
}
