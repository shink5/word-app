#include <stdio.h>
#include <math.h>

int main()
{
    printf("Number:190210504\n");
    printf("calculate_triangle\n");
    float a,b,c,p,area;
    printf("Input a,b,c:");
    scanf("%f,%f,%f",&a,&b,&c);
    if ((a+b)>c && (b+c)>a && (c+a)>b){
        p = (a+b+c)/2;
        area = sqrt(p*(p-a)*(p-b)*(p-c));
        printf("area =%f\n",area);
    }
    else{
        printf("they could not combine a triangle\n");
    }
    return 0;
}

