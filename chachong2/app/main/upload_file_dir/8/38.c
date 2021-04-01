#include<stdio.h>
int main()
{
    double r;
    double s,v;
    printf("YOU CAN INPUT A R TO GET ONE SPHERE'S S&V\n");
    const double pi=3.14159;
    printf("input r:");
    scanf("%lf",&r);
    s=pi*r*r*4;
    v=pi*r*r*r*4*pi/3;
    printf("s=%lf\n",s);
    printf("v=%lf\n",v);
}
