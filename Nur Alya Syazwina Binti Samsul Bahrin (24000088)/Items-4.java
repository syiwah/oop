public class Items{
     List<Item> itemList = new ArrayList<>();
    
    public void add(Item item){
       itemList.add(item);
    }
    
    public void remove(Item item){
       itemList.remove(item);
    }

    public void print(Item item){
       for (Item item: itemList){
           System.out.println("Item Name: " + item.name + ", Quantity: " + item.quantity + ", Price: " + item.price + ", Supplier Name: " + item.supplierName);
       }
    } 
    
    public void find(Item item){
       for (Item item: itemList){
         if(item.name.equals(itemName)){
             return order;
         }
       }
       return 0;
    }
   
}