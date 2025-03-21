#include<stdio.h>

void swap(int *i,int *j){
    int temp=*i;
    *i=*j;
    *j=temp;
}

void selectionsort(int a[],int n){
    int c=0,s=0;
    int i,j;
    for(i=0;i<n-1;i++){
        int min=i;
        for(j=i+1;j<n;j++)
        c++;
        if(a[j]<a[min]) 
        min=j;
       
        if(min!=i){
            swap(&a[i],&a[min]);
            s++;
        }
    }
    for(int i=0;i<n;i++)
    printf("%d ",a[i]);
    printf("\nNo. of Comparision and no of shift=%d %d" ,c,s);
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
        selectionsort(a,n); 
    }
    return 0;
}