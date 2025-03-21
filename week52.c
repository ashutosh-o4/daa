#include<stdio.h>

void findpair(int a[],int n,int k)
{
    int sum;
    int i=0,j=n-1;
    while(i<j){
        sum=a[i]+a[j];
        if(sum==k) {
            printf("%d %d",i,j);
            return;
        }
        else if(sum<k) i++;
        else j--;
    }
    printf("nope");
}

void merge(int a[],int l,int m,int h){
    int i,j,k;
    int n1=m-l+1;
    int n2=h-m;

    int la[n1],ra[n2];
    for(i=0;i<n1;i++)
    la[i]=a[l+i];
    for(j=0;j<n2;j++)
    ra[j]=a[m+j+1];

    i=0,j=0,k=l;
    while(i<n1 && j<n2){
        if(la[i]<ra[j]){
            a[k++]=la[i++];
        }
        else
        a[k++]=ra[j++];
    }
    while(i<n1){
        a[k++]=la[i++];
    }
    while(j<n2){
        a[k++]=ra[j++];
    }
}

void mergesort(int a[],int l,int h){
    if(l<h){
        int mid=l+(h-l)/2;
        mergesort(a,l,mid);
        mergesort(a,mid+1,h);
        merge(a,l,mid,h);
    }
}
int main()
{
    int n, q,k;
    printf("Enter TEST CASE: ");
    scanf("%d", &q);

    while (q--) {
        printf("Enter the size of array: ");
        scanf("%d", &n);
        int a[n];
        printf("Enter the alphabets: ");
        for (int i = 0; i < n; i++) {
            scanf(" %d", &a[i]);   
        }
        scanf("%d",&k);
        mergesort(a,0,n-1);
        findpair(a,n,k);
    }  
    return 0;
}