public  class Orders{
    List<Order> orderList = new ArrayList<>();
    
    public void add(Order order){
       orderList.add(order);
    }
    
    public void remove(Order order){
       orderList.remove(order);
    }

    public void print(Order order){
       for (Order order: orderList){
           System.out.println("Item: " + order.item + ", Price: " + order.price + ", Date: " + order.date + ", Time: " + order.time);
       }
    } 
    
    public void find(Order order){
       for (Order order: orderList){
         if(order.item.equals(itemName)){
             return order;
         }
       }
       return 0;
    }
   
}