#include <stdio.h>
#include <stdlib.h>
#include<math.h>

int main()
{
    int i;double s;double p;double a[4];
    int flag=0;
    a[3]=0;
    for(i=0;i<=2;i++)
    printf("请输入三角形边长:"),scanf("%lf",&a[i]),a[3]+=a[i];
    p=a[3]/2.0;
    for(i=0;i<=2;i++)
    if(a[3]>2*a[i])flag++;
    if(flag==3) s=sqrt(p*(p-a[0])*(p-a[1])*(p-a[2])),printf("%lf",s);
    else        printf("不能构成三角形");
    return 0;
}
