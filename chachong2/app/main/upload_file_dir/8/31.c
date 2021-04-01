#include <stdio.h>
#include <math.h>

int main()
{
    printf("Number:190210519\nprojectNo.2-programNo.2\n");
    double a,b,c,p;
    printf("请输入3个边长:a=");
    scanf("%lf",&a);
    printf("b=");
    scanf("%lf",&b);
    printf("c=");
    scanf("%lf",&c);
    if(a+b>c&&a+c>b&&b+c>a){
        p=(a+b+c)/2.0;
        printf("可以构成三角形，三角形面积为：%f",sqrt(p*(p-a)*(p-b)*(p-c)));}
    else{
    printf("无法构成三角形");
    }
    return 0;
}
