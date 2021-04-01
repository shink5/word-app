#include <stdio.h>
#include <stdlib.h>
#define PI 3.14159

int main()
{
    printf("Number : 190210518 ");
    printf("subject No.1 - program No.1\n\n");
    const double PI1 = 3.14159;
    double r;
    printf("Input r:");
    scanf("%lf", &r);
    printf("球的体积 = %f\n", 4*PI*r*r*r/3);
    printf("球的表面积 = %f\n", 4*PI*r*r);
}
