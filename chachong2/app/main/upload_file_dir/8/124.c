#include <stdio.h>
#include <stdlib.h>
#define Pi 3.14159
int main()
{
    printf("Number:190210604\n");
    printf("subject No.2 - program No.1\n");
    const double PI = 3.14159;
    double r;
    printf("Input r:");
    scanf("%lf",&r);
    printf("volume = %f\n",(4*PI*r*r*r)/3);
    printf("area = %f\n",4*PI*r*r);
    double R;
    printf("Input R:");
    scanf("%lf",&R);
    printf("area = %f\n",4*Pi*R*R);
    printf("volume = %f\n",(4*Pi*R*R*R)/3);
    return 0;
}
