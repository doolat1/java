package kz.aitu.oop.MyProject.entities;

import java.util.*;


class Item {
    private int idI;
    private String name;
    private double price;

    public Item() {}

    public Item(int idI, String name, double price) {
        this.idI = idI;
        this.name = name;
        this.price = price;
    }

    public int getIdI() { return idI; }
    public void setIdI(int idI) { this.idI = idI; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return "Item{" + "idI=" + idI + ", name='" + name + '\'' + ", price=" + price + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return idI == item.idI;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idI);
    }
}