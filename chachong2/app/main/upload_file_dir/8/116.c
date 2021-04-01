#include <stdio.h>
#define a 3.14159
int main()
{
    printf("Number190210601\n");
    printf("subject2 program1\n");
    const double PI=3.14159;
    double r;
    printf("Input r:");
    scanf("%lf",&r);
    printf("area in define=%f\n",4*a*r*r);
    printf("volume in define=%f\n",4.0/3.0*a*r*r*r);
    printf("area in const=%f\n",4*PI*r*r);
    printf("volume in const=%f\n",4.0/3.0*PI*r*r*r);//不是整形4/3，是浮点型4.0/3.0
    return 0;
}
