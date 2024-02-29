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
        private NoteBook.Color color;
        public Color(NoteBook.Color color) {
            this.color = color;
        }
        public NoteBook.Color getColor() {
            return color;
        }
        public void setColor(NoteBook.Color price){
            this.color = price;
        }
    }

    public static final class OS extends FilterOptions {
        private NoteBook.OS os;
        public OS(NoteBook.OS os) {
            this.os = os;
        }
        public NoteBook.OS getOs() {
            return os;
        }
        public void setOs(NoteBook.OS os){
            this.os = os;
        }
    }

}