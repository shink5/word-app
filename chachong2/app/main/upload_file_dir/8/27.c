#include <stdio.h>
#include <stdlib.h>

#define pi1 3.1415926

int main()
{
    printf("Number:190210516 \n");
    printf("subject No.2 - program No.1\n\n");

    const double pi2 = 3.1415926;
    double r = 0;

    printf("请输入球的半径:");
    scanf("%lf", &r);
    printf("球的表面积是: %f\n", 4 * pi1 * r * r);
    printf("球的体积是: %f\n", 4.0 * pi2 * r * r * r / 3.0);
    return 0;
}
