#include<stdio.h>
#define PI 3.1415
int main()
{
    double r;
    printf("input r:\n");
    scanf("%lf",&r);
    printf("v=%f\n",(4/3)*PI*r*r*r);
    printf("s=%f\n",4*PI*r*r);
}
