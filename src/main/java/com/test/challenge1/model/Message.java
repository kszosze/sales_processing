package com.test.challenge1.model;

public abstract class Message {

    private String product;
    private Integer price;

    public Message(String product, Integer price) {
        this.product = product;
        this.price = price;
    }

    public String getProduct() {
        return product;
    }

    public Integer getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;

        Message message = (Message) o;

        return getProduct() != null ? getProduct().equals(message.getProduct()) : message.getProduct() == null;
    }

    @Override
    public int hashCode() {
        return getProduct() != null ? getProduct().hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Message{");
        sb.append("product='").append(product).append('\'');
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }
}
