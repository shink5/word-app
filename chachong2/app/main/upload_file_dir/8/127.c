#include <stdio.h>
#include <stdlib.h>

main()
{
    const double PI =3.14159;

    float r,s,v;
    printf("请输入球的半径:\n");
    scanf("%f",&r);
    s=4*PI*r*r;
    v=(4*PI*r*r*r)/3;
    printf("球的表面积为:%f\n",s);
    printf("球的体积为:%f\n",v);
    return 0;
}
