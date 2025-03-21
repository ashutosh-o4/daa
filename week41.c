#include<stdio.h>

void merge(int a[],int l,int m,int h){
    int i,j,k,c=0,in=0;
    int n1=m-l+1;
    int n2=h-m;

    int la[n1],ra[n2];

    for(i=0;i<n1;i++)
    la[i]=a[l+i];
    for(j=0;j<n2;j++)
    ra[j]=a[m+1+j];

    i=0,j=0,k=l;
    while(i<n1 && j<n2){
        c++;
        if(la[i]<ra[j]){
            a[k++]=la[i++];
        }
        else{
            a[k++]=ra[j++];
            in++;
        }
    }
    while (i < n1) {
        a [k] = la[i];
        i++;
        k++;
    }

     
    while (j < n2) {
        a[k] = ra[j];
        j++;
        k++;
    }
}

void mergesort(int a[],int l,int h){
    int m;
    if(l<h){
    m= l+ (h-l)/2;
    mergesort(a,l,m);
    mergesort(a,m+1,h);
    merge(a,l,m,h);
    }
}


int main() {
    int n, q;
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

        mergesort(a, 0, n - 1);
        for(int i=0;i<n;i++)
        printf("%d ",a[i]);
    }
    return 0;
}
