#include <stdio.h>
#include <stdlib.h>
#include<math.h>
int main()
{
    printf ("number:190210508\n实验2.2\n");
    double a,b,c;
    double s;
        printf("input a b c");
        scanf("%lf,%lf,%lf",&a,&b,&c);
        if((a+b>c)&&(a+c>b)&&(b+c>a))
        {
            s=(a+b+c)/2;
            printf("area=%lf",(double)sqrt(s*(s-a)*(s-b)*(s-c)));
            exit(0);
        }
        else
                printf("不是三角形");


}
