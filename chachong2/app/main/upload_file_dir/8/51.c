#include <stdio.h>
#include <stdlib.h>
#include<math.h>

int main()
{
    printf("Number:190210612\nsubject No.1 - program No.1\n\n");
    float a,b,c,p,s;
	printf("请输入三角形的三边长：");
	scanf("%f%*c%f%*c%f", &a, &b, &c);
    if( a+b > c && b+c > a && a+c > b)
    {
        p = (a+b+c)/2;
        s = sqrt(p * (p-a) * (p-b) * (p-c));
        printf("三角形的面积为：%f",s);
    }
    else
        printf("这不是一个三角形！");
    return 0;
}
