#include <stdio.h>
#include <stdlib.h>
#define PI1 3.14159
int main()
{
    printf("Number:190210509\nSubject2 Program1\n");
    const double PI2 =3.14159;
    double r;
    printf("Input r:");
    scanf("%lf",&r);
    printf("宏定义体积=%f\n",(4./3)*PI1*r*r*r);
    printf("const常量体积=%f\n",(4./3)*PI2*r*r*r);
    printf("宏定义表面积=%f\n",4.*PI1*r*r);
    printf("const常量表面积=%f\n",4.*PI2*r*r);
    return 0;
}
