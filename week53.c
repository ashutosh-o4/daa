#include<stdio.h>


void findcommonelement(int a[],int n,int b[],int m){
    int i=0,j=0;
    while(i<n && j<m){
        if(a[i]==b[j]){
            printf("%d",a[i]);
            return;
        }
        else if(a[i]<b[j]) i++;
        else j++; 
    }
}


int main()
{
    int n, q,m;
    printf("Enter TEST CASE: ");
    scanf("%d", &q);

    while (q--) {
        printf("Enter the size of array: ");
        scanf("%d", &n);
        int a[n];
        scanf("%d", &m);
        int b[m];
        
        for (int i = 0; i < n; i++) {
            scanf(" %d", &a[i]);   
        }
        for (int i = 0; i < m; i++) {
            scanf(" %d", &b[i]);   
        }
         
        findcommonelement(a,n,b,m);
    }  
    return 0;
}