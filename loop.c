#include<stdio.h>

int main(){
int i, j, k = 0;
int n = 20;
    for( i = 0; i < n; i++)
        for(j = i -1 ; j < n; j++)
            k+= 1;

printf("\n%d\n", k);

k = 0;
    for( i = 0; i < n; i++)
        for(j = 0; j < i + 2 ; j++)
            k+= 1;
            
printf("\n%d\n", k);
}