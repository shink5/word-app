#include <stdio.h>
#include <stdlib.h>
#define PI1 3.141592
int main()
{
    printf("Number:190210508\n实验2.1\n");
    const double PI2=3.14;
    double r;
    printf("输入半径=");
    scanf("%lf",&r);
    printf("球体积为：%lf\n",(4.0/3)*PI1*r*r*r);
    printf("球面积为:%lf\n",4.0*PI1*r*r);

    return 0;
}
