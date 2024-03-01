public sealed class FilterOptions {
    public static final class Price extends FilterOptions {
        private int price;
        public Price(int price) {
            this.price = price;
        }
        public int getPrice() {
            return price;
        }
        public void setPrice(int price){
            this.price = price;
        }
    }

    public static final class ScreenResolution extends FilterOptions {
        private double screenPrice;
        public ScreenResolution(double price) {
            this.screenPrice = price;
        }
        public double getRes() {
            return screenPrice;
        }
        public void setRes(double price){
            this.screenPrice = price;
        }
    }

    public static final class RAM extends FilterOptions {
        private int ram;
        public RAM(int price) {
            this.ram = price;
        }
        public int getRam() {
            return ram;
        }
        public void setRam(int price){
            this.ram = price;
        }
    }

    public static final class Color extends FilterOptions {
        private Specs.Color color;
        public Color(Specs.Color color) {
            this.color = color;
        }
        public Specs.Color getColor() {
            return color;
        }
        public void setColor(Specs.Color price){
            this.color = price;
        }
    }

    public static final class OS extends FilterOptions {
        private Specs.OS os;
        public OS(Specs.OS os) {
            this.os = os;
        }
        public Specs.OS getOs() {
            return os;
        }
        public void setOs(Specs.OS os){
            this.os = os;
        }
    }

}