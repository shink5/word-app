#include <stdio.h>
#include <stdlib.h>
#include<math.h>

int main()
{
    printf("Number:190210506\nsubject NO.2-program NO.2\n\n");


    double a,b,c,L,S;
    printf("请输入三角形的三边长，用空格隔开：\n");
    scanf("%lf %lf %lf",&a,&b,&c);

    if((a+b>c)&&(b+a>c)&&(a+c>b))
    {
        L=1.0/2*(a+b+c);
        S = sqrt(L*(L-a)*(L-b)*(L-c));
        printf("你输入的三边能构成三角形，其面积为：%7.3f。\n",S);/*为了输出结果更整齐，我将结果保留3位小数*/
    }
    else
    {
        printf("你输入的三边不能构成三角形。\n");
    }

    getchar();
    getchar();
    return 0;
}
