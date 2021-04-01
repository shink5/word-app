#include <stdio.h>
#include <stdlib.h>
#define PI 3.14159
int main()
{
    const double pi = 3.14159;
    double r;
    printf("请输入r:");
    scanf("%lf",&r);
    printf("宏定义面积 = %lf\n",4*PI*r*r);
    printf("const面积 = %lf\n",4*pi*r*r);
    printf("宏定义体积 = %lf\n",4/3*PI*r*r*r);
    printf("const体积 = %lf\n",4/3*pi*r*r*r);
    return 0;
}
