#include<stdio.h>
main()
{
    printf("student number 190210620\n");
    const double IP = 3.14159;
    double r;
    printf("please input r:");
    scanf("%lf",&r);
    printf("circumference = %f\n",4*IP*r*r);
    printf("volume = %f\n",(4.0/3)*IP*r*r*r);
}
