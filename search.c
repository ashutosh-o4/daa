#include<stdio.h>
#define max 100
#include<stdlib.h>

int search(int [],int ,int);

int main()
{
    int a[max];
    int n,q,key,c=1;
    printf("Enter TEST CASE:");
    scanf("%d",&q);

    while(q--){
        printf("Enter the size of array:");
        scanf("%d",&n);
        for(int i=0;i<n;i++){
            scanf("%d",&a[i]);
        }
        printf("Enter key to be searched:");
        scanf("%d",&key);
        int res=search(a,n,key);
        if(res==-1)
        {
        printf("Not found");
        exit(0);
        }

        int left=res-1;
        while(left>=0)
        {
            if(a[left]==key)
            c++;
            left--;
        }

        int right=res+1;
        while(right<n)
        {
            if(a[right]==key)
            c++;
            right++;
        }

        printf("Total count:%d",c);
    }
}


int search(int a[],int n,int t)
{
    int l=0,h=n-1;
    while(l<h)
    {
        int mid=l+(h-l)/2;
        if(a[mid]==t)
        return mid;
        else if(a[mid]>t)
        h=mid-1;
        else
        l=mid+1;
    }
    return -1;
}