package com.test.challenge1.model;

import com.test.challenge1.model.enums.OperationTypeEnum;

public class Sale {

    private String product;
    private Integer price;
    private Integer amount;

    public Sale(String product, Integer price, Integer amount) {
        this.product = product;
        this.price = price;
        this.amount = amount;
    }

    public String getProduct() {
        return product;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getAmount() {
        return amount;
    }

    public Integer executeOperation(OperationTypeEnum operation, Integer amount) {
        if (OperationTypeEnum.ADD.equals(operation)) {
            price = price + amount;
        } else if (OperationTypeEnum.MULTIPLY.equals(operation)) {
            price = price * amount;
        } else if (OperationTypeEnum.SUBSTRACT.equals(operation)) {
            price = price - amount;
        }
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sale)) return false;

        Sale sale = (Sale) o;

        if (!getProduct().equals(sale.getProduct())) return false;
        if (!getPrice().equals(sale.getPrice())) return false;
        return getAmount().equals(sale.getAmount());
    }

    @Override
    public int hashCode() {
        int result = getProduct().hashCode();
        result = 31 * result + getPrice().hashCode();
        result = 31 * result + getAmount().hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Sale{");
        sb.append("product='").append(product).append('\'');
        sb.append(", price='").append(price).append('\'');
        sb.append(", amount='").append(amount).append('\'');
        sb.append('}');
        return sb.toString();
    }


}
