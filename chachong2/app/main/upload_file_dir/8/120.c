#include <stdio.h>
#define PI 3.14159
int main()
{
    printf("Number:190210603\n");
   printf("suject NO.2- program NO.1\n");
    const double pi = 3.14159;
    double r;
    printf("输入 r：");
    scanf("%lf",&r);
    printf("宏定义体积=%f\n",PI*r*r*r*4/3);
    printf("宏定义表面积=%f\n",PI*r*r*4);
    printf("CONST定义体积=%f\n",pi*r*r*r*4/3);
    printf("CONST定义表面积=%f\n",pi*r*r*4);
    return 0;
}
