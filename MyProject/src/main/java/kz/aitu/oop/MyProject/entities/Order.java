package kz.aitu.oop.MyProject.entities;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

class Order {
    private int idO;
    private Customer customer;
    private List<Item> items;

    public Order(int idO, Customer customer) {
        this.idO = idO;
        this.customer = customer;
        this.items = new ArrayList<>(); // Создаём пустой список
    }

    public Order() {
        this.items = new ArrayList<>();
    }

    public Order(int idO, Customer customer, List<Item> items) {
        this.idO = idO;
        this.customer = customer;
        this.items = new ArrayList<>(items);
    }

    public void addItem(Item item) {
        this.items.add(item);
    }
    public double calculateTotal() {
        double total = 0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }


    public int getIdO() { return idO; }
    public void setIdO(int idO) { this.idO = idO; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    public List<Item> getItems() { return items; }
    public void setItems(List<Item> items) { this.items = new ArrayList<>(items); }

    @Override
    public String toString() {
        return "Order{" + "idO=" + idO + ", customer=" + customer + ", items=" + items + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return idO == order.idO;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idO);
    }
}