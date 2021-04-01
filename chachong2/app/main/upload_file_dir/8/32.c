#include <stdio.h>
#define PAI1 3.14159
main()
{
    printf("Number:190210520\nsubject No.2---- project N0.1\n\n");
    double r;
    const double PAI2 = 3.14159;
    printf("请输入需要计算的球的半径:");
    scanf(" %lf",&r);
    printf("球的表面积是:%f\n",4*PAI1*r*r);
    printf("球的体积是:%f",4.0/3.0*PAI2*r*r*r);
}
