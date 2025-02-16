import java.util.*;
public class linearsearch
{
    public static int search(int [] arr , int key)
    {   
        for(int i=0; i < arr.length ; i++)
        
            if(arr[i]==key)
            return 1;
        return -1;
    }
    public static void main(String [] args)
    {
        Scanner sc=new Scanner(System.in);
        int arr[]={7,69,11,10,3444};
        int key;    
        System.out.print("Enter a key:");
        key=sc.nextInt();
        
        int res=search(arr,key);

        if(res != 1)
        System.out.println("Not Found");
        else
        System.out.println("found");
        
        sc.close();
    }
}