#include <stdio.h>
#include <stdlib.h>
#include <math.h>
int main()
{
    float a,b,c,C;
    printf("Input a,b,c=");
    scanf("%f%f%f",&a,&b,&c);
    C=0.5*(a+b+c);
    if(a+b>c && a+c>b && b+c>a)
        printf("S=%f\n",sqrt(C*(C-a)*(C-b)*(C-c)));
    else
        printf("error,try again.\n");
        return 0;

}
