
import java.util.Scanner;

public class CSociety {
    int n,f,r,c;
    int arr[];
    public CSociety(int n){
        this.n=n;
        arr=new int[n];
        r=0;
        f=0;
        c=0;
    }
    public void enqueue(int d){
        if(c==n){
            System.out.println("House Full");
            return;
        }
        arr[r]=d;
        r=(r+1)%n;
        c++;
        System.out.println("Food Given");
    }
    public void dequeue(){
        if(c==0){
            System.out.println("No Empty place");
        }else{
            System.out.println("Food plate taken from house No:"+f);
            f=(f+1)%n;
        }
    }
    public void display(){
        for(int i=f,j=0;j<c;j++){
            System.out.println("House Nuumber :"+i);
            i=(i+1)%n;

        }
    }
    public static void main(String[] args) {
        CSociety obj=new CSociety(10);
        while(true){
            try{
        System.out.println("1.Provide Food");
        System.out.println("2.Take Plate");
        System.out.println("3.Display House with Food");
        System.out.println("4.Exit");
        System.err.println("Enter your choice");
        Scanner sc=new Scanner(System.in);
        int ch=sc.nextInt();
        switch(ch){
            case 1:
            obj.enqueue(1);
            break;
            case 2:
            obj.dequeue();
            break;
            case 3:
            obj.display();
            break;
            case 4:
           System.exit(0);
        }
    }catch(Exception e){
        System.out.println("wrong input");
    }
    }
    }
}
