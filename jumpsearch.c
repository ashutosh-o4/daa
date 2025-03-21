#include<stdio.h>
#include<stdlib.h>
#include<math.h>


void jumpsearch(int a[],int n,int t)
{
    int js = sqrt(n);   
    int prev = 0;

     
    while (prev < n && a[prev] < t) {
        prev += js;
    }

     
    int start = prev - js;   
    if (start < 0) start = 0;   

    for (int i = start; i < n && i <= prev; i++) {
        if (a[i] == t) {
            printf("Found\n");
            return;
        }
    }

    printf("Not found\n");
}

int main(){

    int t;
    scanf("%d",&t);
    while(t--){
        int n,key;
        scanf("%d",&n);
        int a[n];
        for(int i=0;i<n;i++){
            scanf("%d",&a[i]);
        }
        scanf("%d",&key);
        jumpsearch(a,n,key);
    }
}