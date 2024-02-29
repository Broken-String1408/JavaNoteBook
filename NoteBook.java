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
    
    public enum OS{
        WINDOWS, LINUX, MAC
    }  
    public enum Color{
        SILVER, BLACK, WHITE, BLUE, GREY
    }  
    private int price;
    private int ram;
    private Color color;
    private OS system;
    private double screenSize;
    private String name;

    public NoteBook (String name, int price, int ram, Color color, OS system, double screenSize) {
        this.price = price;
        this.ram = ram;
        this.color = color;
        this.system = system;
        this.screenSize = screenSize;
        this.name = name;
    }
        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name = name;
        }
        public int getPrice() {
            return price;
        }
    
        public void setPrice(int price) {
            this.price = price;
        }
    
        public int getRam() {
            return ram;
        }
    
        public void setRam(int ram) {
            this.ram = ram;
        }
    
        public Color getColor() {
            return color;
        }
    
        public void setColor(Color color) {
            this.color = color;
        }
    
        public OS getSystem() {
            return system;
        }
    
        public void setSystem(OS system) {
            this.system = system;
        }
    
        public double getScreenSize() {
            return screenSize;
        }
    
        public void setScreenSize(double screenSize) {
            this.screenSize = screenSize;
        }
        @Override
    public String toString() {
        return "NoteBook{" +
                "name = " + name +
                ", price = " + price +
                ", ram = " + ram +
                ", color = " + color +
                ", system = " + system +
                ", screenSize = " + screenSize +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NoteBook noteBook = (NoteBook) o;

        if (price != noteBook.price) return false;
        if (ram != noteBook.ram) return false;
        if (screenSize != noteBook.screenSize) return false;
        if (color != noteBook.color) return false;
        return system == noteBook.system;
    }

    @Override
    public int hashCode() {
    return Objects.hash(name, price, ram, color, system, screenSize);
    }
}
