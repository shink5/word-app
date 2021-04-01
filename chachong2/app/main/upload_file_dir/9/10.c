#include <stdio.h>
#include <stdlib.h>
#define PI1 3.14159

int main()
{
    printf("Number:190210506\nsubject NO.2-program NO.1\n\n");


    double r,V,S;/*半径，体积，表面积*/
    const double PI2 = 3.14159;

    printf("请输入球的半径：");
    scanf("%lf",&r);

    V=4.0/3*PI1*r*r*r;
    S=4*PI2*r*r;

    printf("球的体积是%7.3f,球的表面积是%7.3f。\n",V,S);/*为了输出结果更加整齐,保留了三位小数*/

    getchar();
    getchar();

    return 0;
}
