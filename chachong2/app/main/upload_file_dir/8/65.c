#include<stdio.h>
#include<math.h>
main()
{
    printf("student number 190210620\n");
    float a,b,c,area;
    printf("please input a b c :");
    scanf("%f %f %f",&a,&b,&c);
    if((a+b)>c&&(a+c)>b&&(b+c)>a)
    {
        float p;
        p=(a+b+c)/(float)2;
        area = (float)sqrt(p*(p-a)*(p-b)*(p-c));
        printf("They can form a triangle and the area =%f",area);
    }
    else
    {
        printf("WRONG!They can not reform a triangle");
    }
}
