#include <stdio.h>
#include <stdlib.h>

int main()
{
    printf("Number:190210526\n");
    printf("subject No.2-program No.1\n\n");
    const double PI=3.1415926;
    double r;
    printf("Please input r:");
    scanf("%lf",&r);
    printf("\n表面积=%lf\n",4*PI*r*r);
    printf("体积=%lf\n",(4/3)*PI*r*r*r);
    return 0;
}
