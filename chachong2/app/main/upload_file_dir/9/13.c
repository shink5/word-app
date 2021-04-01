#include <stdio.h>
#include <math.h>
int main()
{
    float a,b,c,x,s;
    printf("Number:190210507\n");
    printf("subject No.2-program No.2");
    printf("Please input a b c:");
    scanf("%f %f %f",&a,&b,&c);
    if ((a+b>c)&&(b+c>a)&&(a+c>b))
    {
        x=(a+b+c)/2;
        s=sqrt(x*(x-a)*(x-b)*(x-c));
        printf("area=%f",s);
    }
    else
        printf("Error!");
}
