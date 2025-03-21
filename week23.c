#include<stdio.h>
#include<stdlib.h> 


int pairs(int a[],int n, int key)
{
    int c=0;
       
    for (int j = 1; j < n; j++) {
        for (int i = 0; i < j; i++) {   
            if (abs(a[i] - a[j]) == key) {
                c++;
            }
        }
    }

    return c;
     
}
int main()
{
    int n,q,key;
    printf("Enter TEST CASE:");
    scanf("%d",&q);

    while(q--){
        printf("Enter the size of array:");
        scanf("%d",&n);
        int a[n];
        for(int i=0;i<n;i++){
            scanf("%d",&a[i]);
        }
        scanf("%d",&key);
        printf("Count:%d",pairs(a,n,key));
    }
    return 0;
}