#include <stdio.h>
#include <stdlib.h>

int main()
{
    printf("Number:190210501\n Subject:No.2  -  Program:No.1\n");
    const double PI=3.14159;
    double r;
    printf("Input r:");
    scanf("%lf",&r);
    printf("Area=%f\nVolume=%f\n",PI*r*r*4,PI*r*r*r*4/3);
    return 0;
}
