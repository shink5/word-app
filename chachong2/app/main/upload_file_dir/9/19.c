#include <stdio.h>
#define Pi 3.1415926
int main()
{
 printf("Number:190210511\nsubject No.2-program No.1\n");
  double r,v,s;
  printf("请输入半径的值：");
  scanf("%lf",&r);
  s=4*Pi*r*r;
  v=Pi*4/3*r*r*r;
  printf("利用宏定义算出球的表面积是：%lf\n利用宏定义算出球的体积是:%lf\n",s,v);
  const double PI = 3.1415926;
  double R,S,V;
  printf("请输入半径的值：");
  scanf("%lf",&R);
  S=4*PI*R*R;
  V=4/3*PI*R*R*R;
  printf("利用const常量定义π算出圆的表面积是：%lf\n利用const常量定义π算出圆的体积是:%lf\n",S,V);
}
