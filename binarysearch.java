import java.util.*;
public class binarysearch {
    public static int search(int [] a, int low,int high, int key){
        if(low > high)
        return -1;
        else
        {
            int mid=low + (high-low)/2;
            if(a[mid]==key)
            return mid;
            else if(a[mid]>key)
            return search(a,low,mid-1,key);
            else
            return search(a, mid+1, high, key);
        }
    }
    public static void main(String [] args)
    {
        Scanner sc=new Scanner(System.in);
        int arr[]={10,20,30,40,50};
        int key;    
        System.out.print("Enter a key:");
        key=sc.nextInt();
        
        int res=search(arr,0,arr.length,key);

        if(res != -1)
        System.out.println("Found");
        else
        System.out.println("Not found");
        sc.close();
    }
}
