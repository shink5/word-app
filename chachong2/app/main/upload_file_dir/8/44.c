#include <stdio.h>
#define PI 3.14159
#include <stdlib.h>

int main()
{ printf("Number:190210606\nsubject No.2- program No.1\n");
    int r;
    float S,V;
    printf("input r  \n");
    scanf("%d",&r);
    S=4*PI*(r^2);
    V=(4*PI*r*r*r)/3;
    printf("S=%f,V=%f\n",S,V);
    return 0;

}
