#include <stdio.h>
#include <stdlib.h>

int main()
{
    printf("NO.190210624\n");
    printf("project2----program2\n");

    float a,b,c;
    printf("input a,b,c:");
    scanf("%f%f%f",&a,&b,&c);
    if((a+b<c)||(a+c<b)||(b+c<a))
        {
            printf("不是三角形！");
        }
        else
        {
            if(a==b||b==c||a==c)
            {
                if((a*a+b*b==c*c)||(a*a+c*c==b*b)||(b*b+c*c==a*a))
                {
                    printf("等腰直角三角形！");
                }
                else
                {
                    printf("等腰三角形！");
                }
            }
            else
            {
              if((a*a+b*b==c*c)||(a*a+c*c==b*b)||(b*b+c*c==a*a))
                {
                    printf("直角三角形！");
                }
                else
                {
                    printf("普通三角形！");
                }
            }
            float p,S;
            p=(a+b+c)/2;
            S=sqrt(p*(p-a)*(p-b)*(p-c));
            printf("S=%f",S);

        }

    return 0;
}
