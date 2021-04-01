#include<stdio.h>
int main()
{
    const double PI=3.1415;
    double r;
    printf("input r:\n");
    scanf("%lf",&r);
    printf("v=%f\n",(4/3)*PI*r*r*r);
    printf("s=%f\n",4*PI*r*r);
}

