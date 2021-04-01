#include <stdio.h>
int main()
{
    printf("Number:190210618\n");
    printf("subject No.2 - program No.2\n");
    const double Pi=3.1415926;
    double r,s,v;
    scanf("%lf",&r);
    s=4*Pi*r*r;
    v=(4/3)*(Pi*r*r*r);
    printf("球的面积为：%lf，体积为：%lf",s,v);
    return 0;
}
