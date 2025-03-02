#include<stdio.h>
#include<stdlib.h>
#define max 100

int pairs(int [],int );

int main()
{
    int a[max];
    int n,q;
    printf("Enter TEST CASE:");
    scanf("%d",&q);

    while(q--){
        printf("Enter the size of array:");
        scanf("%d",&n);
        for(int i=0;i<n;i++){
            scanf("%d",&a[i]);
        }
    }
    return 0;
}
