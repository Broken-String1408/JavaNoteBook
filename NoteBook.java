// Задание
// -Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в
// java.
// -Создать множество ноутбуков.
// -Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и
// выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например:
// “Введите цифру, соответствующую необходимому критерию: 1 - ОЗУ
// 2 - Объем ЖД
// 3 - Операционная система
// 4 - Цвет …
// -Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации
// можно также в Map.
// -Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.

import java.util.Objects;

public class NoteBook {

    private int price;
    private Specs.RAM ram;
    private Specs.Color color;
    private Specs.OS system;
    private Specs.Screen screenSize;
    private Specs.Brand brand;

    public NoteBook (Specs.Brand brand, int price, Specs.RAM ram, Specs.Color color, Specs.OS system, Specs.Screen screenSize) {
        this.price = price;
        this.ram = ram;
        this.color = color;
        this.system = system;
        this.screenSize = screenSize;
        this.brand = brand;
    }
        public Specs.Brand getBrand(){
            return brand;
        }
        public void setBrand(Specs.Brand brand){
            this.brand = brand;
        }
        public int getPrice() {
            return price;
        }
    
        public void setPrice(int price) {
            this.price = price;
        }
    
        public int getRam() {
            return ram.capacity;
        }
    
        public void setRam(Specs.RAM ram) {
            this.ram = ram;
        }
    
        public Specs.Color getColor() {
            return color;
        }
    
        public void setColor(Specs.Color color) {
            this.color = color;
        }
    
        public Specs.OS getSystem() {
            return system;
        }
    
        public void setSystem(Specs.OS system) {
            this.system = system;
        }
    
        public double getScreenSize() {
            return screenSize.res;
        }
    
        public void setScreenSize(Specs.Screen screenSize) {
            this.screenSize = screenSize;
        }
        @Override
    public String toString() {
        return "NoteBook {" +
                "производитель = " + brand +
                ", цена = " + price +
                ", озу = " + ram +
                ", цвет = " + color +
                ", ОС = " + system +
                ", экран = " + screenSize +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NoteBook noteBook = (NoteBook) o;

        if (price != noteBook.price) return false;
        if (brand != noteBook.brand) return false;
        if (ram != noteBook.ram) return false;
        if (screenSize != noteBook.screenSize) return false;
        if (color != noteBook.color) return false;
        return system == noteBook.system;
    }

    @Override
    public int hashCode() {
    return Objects.hash(brand, price, ram, color, system, screenSize);
    }
}
