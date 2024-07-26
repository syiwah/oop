// INSYIRAH BINTI HAMZAH
// 24000157

import java.util.ArrayList;
import java.util.List;

public class Clients {
    private static final String URL = "jdbc:mysql://localhost:3306/Java_Chip";
    private static final String USERNAME = "syirahh.hamzah@gmail.com"; 
    private static final String PASSWORD = "Shinystar10@";
    private List<Client> clients;

    public Clients() {
        clients = new ArrayList<>();
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public void removeClient(String name) {
        clients.removeIf(client -> client.getName().equals(name));
    }

    public List<Client> getClients() {
        return new ArrayList<>(clients); // Return a copy to protect the internal list
    }

    public String getClientsDetails() {
        StringBuilder details = new StringBuilder();
        for (Client client : clients) {
            details.append("Client Name: ").append(client.getName()).append("\n");
            details.append("Phone Number: ").append(client.getPhoneNumber()).append("\n");

            details.append("Orders: ");
            if (client.getOrders() != null && !client.getOrders().isEmpty()) {
                for (Order order : client.getOrders()) {
                    details.append(order.getItemName()).append(" (Price: RM ").append(order.getPrice()).append("), ");
                }
                // Remove the trailing comma and space
                details.setLength(details.length() - 2);
            } else {
                details.append("No orders");
            }
            details.append("\n\n");
        }
        return details.toString();
    }
}
