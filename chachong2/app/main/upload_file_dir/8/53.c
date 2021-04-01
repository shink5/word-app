#include <stdio.h>
#define PI 3.1415926
int main()
{
    double r;
    printf("input r");
    scanf("%lf",&r);
    printf("表面积=%f\n",4*PI*r*r);
    printf("体积=%f\n",(4*PI*r*r*r)/3);
}
