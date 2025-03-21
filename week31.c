#include<stdio.h>

void swap(int *i,int *j){
    int temp=*i;
    *i=*j;
    *j=temp;
}

void  insertionsort(int a[],int n){
    int c=0;
    for(int i=0;i<n;i++){
        int j=i;
        while(j>0 && a[j]<a[j-1])
        {
            swap(&a[j], &a[j-1]);
            j--;
            c++;
        }
    }
    for(int i=0;i<n;i++)
    printf("%d ",a[i]);
    printf("\nNo. of Comparision and no of shift=%d",c);
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
        insertionsort(a,n); 
    }
    return 0;
}