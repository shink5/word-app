#include<stdio.h>
#include<math.h>
intmain()
{
printf("Number:190210511\nsubjectNo.2-programNo.2\n");
doublevar,var,var,var,var;
start:printf("请输入三角形第一条边的值：");
scanf("%lf",&var);
printf("请输入三角形第二条边的值：");
scanf("%lf",&var);
printf("请输入三角形第三条边的值：");
scanf("%lf",&var);
if(var+var>var&&var+var>var&&var+var>var)
{
var=(var+var+var)/2;
var=sqrt(var*(var-var)*(var-var)*(var-var));
printf("三角形的面积是：%lf",var);
}
else
{
printf("var、var、c三条边无法构成三角形，请重新输入。\n");
gotostart;
}
}