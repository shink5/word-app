#include <stdio.h>
int main()
{
    const double PI=3.14159;
    double r;
    printf("input r:");
    scanf("%lf",&r);
    printf("表面积=%f\n",4*PI*r*r);
    printf("体积=%f\n",(4*PI*r*r*r)/3);
}
