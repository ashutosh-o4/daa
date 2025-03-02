#include <stdio.h>
#include <math.h>
#define max 100

int jumpsearch(int [], int ,int,int);

int min(int a, int b) {
    return (a < b) ? a : b;
}

int main()  
{
    int a[max];
    int n,q,js,key;
    printf("Enter TEST CASE:");
    scanf("%d",&q);

    while(q--){
        printf("Enter the size of array:");
        scanf("%d",&n);
        js=(int)sqrt(n);
        for(int i=0;i<n;i++){
            scanf("%d",&a[i]);
        }
        printf("Enter key to be searched:");
        scanf("%d",&key);
        int r=jumpsearch(a,n,js,key);
        if(r!=-1)
        printf("Found");
        else
        printf("No");
    }
}

int jumpsearch(int a[], int n, int j,int key)
{
    int prev=0;
    while( a[min(j,n)-1]<key)
    {
        prev=j;
        j+=sqrt(n);
        if(prev>=n)
        return -1;
    }
    for(int i=0 ;i<min(j,n);i++){
        if(a[i]==key)
        return i;
    }
    return -1;
}