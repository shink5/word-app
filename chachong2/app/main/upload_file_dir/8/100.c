#include <stdio.h>
#include <stdlib.h>
#define PI 3.14159
int main()
{
   float a,b,c;
    printf("输入半径:");
    scanf("%f",&a);
    b=a*a*a*PI*4/3;
    c=4*PI*a*a;
    printf("球的体积=%f\n",b);
    printf("球的表面积=%f\n",c);
    system("pause");
    return 0;
}
