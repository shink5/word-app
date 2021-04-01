#include <stdio.h>
#include <stdlib.h>

int main()
{
    printf("number:190210504\n");
    printf("subject No.2 -- program No.2\n");
    int i,j;
    char a;
    int tmp;
    scanf("%c",&a);
    a=a+'A'-'a';
    //printf("%c",a);
    for(i=1;i<=8;i++){
        for(j=1;j<=16;j++){
                tmp=j;
            if(i%2==0)
                tmp=j+1;
            if(tmp%2==1)printf("%c",a);
            else printf(" ");
        }
        printf("\n");
    }
    return 0;
}
