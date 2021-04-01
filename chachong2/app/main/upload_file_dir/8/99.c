#include <stdio.h>
#include <stdlib.h>

int main()
{
    const double pi=3.1415;
    float a,b,c;
    printf("输入半径:");
    scanf("%f",&a);
    b=a*a*a*pi*4/3;
    c=4*pi*a*a;
    printf("球的体积=%f\n",b);
    printf("球的表面积=%f\n4",c);
    system("pause");
    return 0;
}
