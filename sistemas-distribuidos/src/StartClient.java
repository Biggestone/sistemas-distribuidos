
public class StartClient {
    public static void main(String [] args){
 	   try{
 	        System.out.println("Hello ");        	        
                 Client c=new Client("Renan");
                 Thread t1=new Thread(c);
                 t1.start();
 	   }catch(Exception e){e.printStackTrace();}
    }
}
