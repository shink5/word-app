#include <stdio.h>
#include <stdlib.h>

int main()
{
    printf("Number : 190210518");
    printf("subject No.1 - program No.1\n\n");
    float a, b, c, p;
    printf("用户您好，请输入三角形的三条边 a,b,c:");
    scanf("%f,%f,%f", &a, &b, &c);
    p = (a + b + c)/2;
    if(a+b>c && a+c>b && b+c>a)
    {
        printf("恭喜您，您输入的三条边可以构成三角形");
        printf("且三角形的面积为 = %f\n", sqrt(p*(p-a)*(p-b)*(p-c)));
    }
    else
        printf("对不起，您输入的三条边不能构成三角形");
}
