package com.powernode.model;

import java.util.Objects;

/**
 * @Author : HD
 * @create 2021/12/9 15:42
 */
public class Car {
    private int id;
    private String brand;
    private String color;
    private String number;
    private String size;
    private int    status;

    public Car() {
    }

    public Car(int id, String brand, String color, String number, String size, int status) {
        this.id = id;
        this.brand = brand;
        this.color = color;
        this.number = number;
        this.size = size;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id && status == car.status && Objects.equals(brand, car.brand) && Objects.equals(color, car.color) && Objects.equals(number, car.number) && Objects.equals(size, car.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, color, number, size, status);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", number='" + number + '\'' +
                ", size='" + size + '\'' +
                ", status=" + status +
                '}';
    }
}
