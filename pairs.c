#include<stdio.h>
#include<stdlib.h>
#define max 100

void pairs(int [],int );

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
        pairs(a,n);
    }
    return 0;
}


void pairs(int a[],int n)
{  
    for(int k=2;k<n;k++){
        int i=0,j=k-1;
        while(i<j)
        {
            int sum=a[i]+a[j];
            if(sum==a[k])
            {
                printf("%d %d %d\n",i+1,j+1,k+1);
                i++;
                j--;
            }
            else if(sum<a[k])
            {
                i++;
            }
            else if(sum>a[k])
            {
                j--;
            }
                
        }
    }
}