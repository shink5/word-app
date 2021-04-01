#include <stdio.h>
#include <stdlib.h>
#define PI 3.14159
int main()
{
    printf("please input r:");
    double r;
    scanf("%lf",&r);
    printf("superficial area=%f\n",4*PI*r*r);
    printf("volume=%f\n",4*PI*r*r*r/3);
}
