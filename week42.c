#include<stdio.h>

void swap(int *i, int *j) {
    int temp = *i;
    *i = *j;
    *j = temp;
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
    swap(&a[j+1],&a[h]);
    return j+1;
}
void QuickSort(int a[],int l,int h){
    int pi;
    if(l<h){
    pi=partition(a,l,h);
    QuickSort(a,l,pi-1);
    QuickSort(a,pi+1,h);
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

        QuickSort(a, 0, n - 1);

        for (int i = 0; i < n; i++)
        {
            printf("%d ",a[i]);
        }

        printf("\n");
    }
    return 0;
}
