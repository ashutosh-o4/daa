#include<stdio.h>
# define alpha 26


void countfreq(char a[],int n){
    char arr[alpha]={0};
    int maxf=0;
    char c;
    for(int i=0;i<n;i++)
    {
        arr[a[i]-'a']++;
    }

    for(int i=0;i<n;i++){
        if(maxf<arr[i]){
            maxf=arr[i];
            c=i+'a';
        }
    }
    printf("Alphabet with maximum occurrences: %c (Frequency: %d)\n", c, maxf);
}   
int main() {
    int n, q,k;
    printf("Enter TEST CASE: ");
    scanf("%d", &q);

    while (q--) {
        printf("Enter the size of array: ");
        scanf("%d", &n);
        char arr[n];
        printf("Enter the alphabets: ");
        for (int i = 0; i < n; i++) {
            scanf(" %c", &arr[i]);   
        }
        countfreq(arr,n);
    }  
    return 0;
}