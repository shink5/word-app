#include <stdio.h>
#include <stdlib.h>
#define PI 3.1415926535
int main()
{
    const double Pi=3.1415926;
    double r;
    printf("请输入半径r:");
    scanf("%lf",&r);
    printf("球的体积(宏定义的PI）=%f\n",4*PI*r*r*r/3);
    printf("球的表面积(宏定义的PI）=%f\n",4*PI*r*r);
    printf("球的体积(const定义的Pi）=%f\n",4*Pi*r*r*r/3);
    printf("球的表面积(const定义的Pi）=%f\n",4*Pi*r*r);
    return 0;
}
