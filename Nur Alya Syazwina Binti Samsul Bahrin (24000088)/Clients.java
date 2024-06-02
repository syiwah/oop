public class Clients{
    List<Client> clientList = new ArrayList<>();
    
    public void add(Client client){
       clientList.add(client);
    }
    
    public void remove( Client Client){
       clientList.remove(client);
    }

    public void print(Client client){
       for (Client client: clientList){
           System.out.println("Name: " + client.name + ", Phone Number: " + client.phoneNum);
       }
    }
    
    public void find(Client client){
       for (Client client: clientList){
         if(client.name.equals(clientName)){
             return client;
         }
       }
       return 0;
    }
   
}
