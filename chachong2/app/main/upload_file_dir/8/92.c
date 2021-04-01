#include <stdio.h>
#include <stdlib.h>
#define PI 3.141592

int main()
{
    printf("Number:190210505\n");
    printf("Subject NO.2-program NO.1\n");

    const double pi = 3.141592;
    double r;
    printf("Input r:");
    scanf("%lf",&r);
    printf ("the ball's V=%f\n",PI*r*r*r*4/3);
    printf ("the ball's S=%f\n",4*pi*r*r);


}
