#include <stdio.h>
#include <stdlib.h>
#define PI 3.14159
int main()
{
    float r,V,S;
    printf("电信 窦文韬 190210622\n");
    printf("请输入半径：\n");
    scanf("%f",&r);
    V=(4/3)*PI*r*r*r;
    S=4*PI*r*r;
    printf("体积为%f,表面积为%f",V,S);
    return 0;
}
