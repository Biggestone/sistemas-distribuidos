    import java.io.*;
    import java.net.*;
         
    class Server implements Runnable{
        	Socket connectionSocket;        	
        	public Server(Socket s){
        		try{
        			System.out.println("Client Got Connected  " );
        			connectionSocket=s;
        		}catch(Exception e){e.printStackTrace();}
        	}     
        	public void run(){
        		try{
        		        BufferedReader reader =
        		        		new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
        		        BufferedWriter writer= 
        		        		new BufferedWriter(new OutputStreamWriter(connectionSocket.getOutputStream()));
                            while(true){
                                String data1 = reader.readLine().trim();
                                System.out.println("Received : "+data1);                            
                            }
        		}catch(Exception e){e.printStackTrace();}
           }
           public static void main(String argv[]) throws Exception{
                System.out.println("Threaded Chat Server is Running  " );
                ServerSocket mysocket = new ServerSocket(5555);
                 while(true){
                    Socket sock = mysocket.accept();
                    Server server=new Server(sock);
                    Thread serverThread=new Thread(server);
                    serverThread.start();
                 }
              }
    }