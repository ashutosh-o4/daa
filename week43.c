#include<stdio.h>

void swap(int *x,int *y){
    int t=*x;
    *x=*y;
    *y=t;
}

int partition(int a[],int l,int h){
    int pivot=a[h];
    int j=l-1;
    for(int i=l;i<h;i++){
        if(a[i]<pivot){
            j++;
            swap(&a[i],&a[j]);
        }
    }
    swap(&a[h],&a[j+1]);
    return j+1;
}


int Quickselect(int a[],int l,int h,int k){
    int pi;
    if(l<=h){
        pi=partition(a,l,h);
        int len=pi-l+1;
        if(len==k) return a[pi];
        else if(k<len) return Quickselect(a,l,pi-1,k);
        else return Quickselect(a,pi+1,h,k-len);
    }
    return -1;
}

int main() {
    int n, q,k;
    printf("Enter TEST CASE: ");
    scanf("%d", &q);

    while (q--) {
        printf("Enter the size of array: ");
        scanf("%d", &n);
        int a[n];

        printf("Enter elements: ");
        for (int i = 0; i < n; i++) {
            scanf("%d", &a[i]);
        }
        scanf("%d",&k);

        printf("Kth Smallest:%d",Quickselect(a, 0,n-1, k));
        printf("Kth Largest:%d",Quickselect(a, 0,n-1, n-k+1));

        printf("\n");
    }
    return 0;
}
