import java.util.ArrayList;
import java.util.List;

public class Clients {
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
        return clients;
    }

    public String getClientsDetails() {
        StringBuilder details = new StringBuilder();
        for (Client client : clients) {
            details.append("Client Name: ").append(client.getName()).append("\n");
            details.append("Phone Number: ").append(client.getPhoneNumber()).append("\n");
            details.append("Address: ").append(client.getAddress()).append("\n");
            details.append("Orders: ");
            for (Order order : client.getOrders()) {
                details.append(order.getItemName()).append(", ");
            }
            details.append("\n\n");
        }
        return details.toString();
    }

    public static class Client {
        private String name;
        private String phoneNumber;
        private List<Order> orders;
        private Address address;

        public Client(String name, String phoneNumber, List<Order> orders, Address address) {
            this.name = name;
            this.phoneNumber = phoneNumber;
            this.orders = orders;
            this.address = address;
        }

        public String getName() {
            return name;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public List<Order> getOrders() {
            return orders;
        }

        public Address getAddress() {
            return address;
        }
    }

    public static class Order {
        private String itemName;

        public Order(String itemName) {
            this.itemName = itemName;
        }

        public String getItemName() {
            return itemName;
        }
    }

    public static class Address {
        private String address;

        public Address(String address) {
            this.address = address;
        }

        @Override
        public String toString() {
            return address;
        }
    }
}
