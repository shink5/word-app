#include <stdio.h>
#include <stdlib.h>
#define P1 3.14159
int main()
{
    double r;
    printf("Please input r:");
    scanf("%lf",&r);
    printf("volume = %f\n",4.0/3*P1*r*r*r);
    printf("superficial area = %f\n",4*P1*r*r);

    const double P2 = 3.14159;
    double a;
    printf("Please input r:");
    scanf("%lf",&a);
    printf("volume = %f\n",4.0/3*P2*a*a*a);
    printf("superficial area = %f\n",4*P2*a*a);

    return 0;
}
