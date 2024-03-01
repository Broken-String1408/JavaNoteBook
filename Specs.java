public interface Specs {



    enum Spec implements Specs {
        PRICE(1, "Макс. цена"),
        OS(2, "Операционная система"),
        COLOR(3, "Цвет"),
        RAM(4, "Оперативная память"),
        SCREEN(5, "Разрешение экрана"),

        BRAND(6, "Производитель");

        public final int num;
        public final String desc;

        Spec (int num, String desc)  {
            this.num = num;
            this.desc = desc;
        }

    }

    enum PRICE implements Specs {
        STUB
    }
    enum OS implements Specs {
        WINDOWS, LINUX, MAC
    }
    enum Color implements Specs {
        SILVER, BLACK, WHITE, BLUE, GREY
    }

    enum RAM implements Specs {
        RAM_2_GB(2),
        RAM_4_GB(4),
        RAM_8_GB(8),
        RAM_16_GB(16),
        RAM_32_GB(32);

        public final int capacity;

        RAM (int capacity)  {
            this.capacity = capacity;
        }
    }

    enum Screen implements Specs {
        RES_14_INCH(14.0),
        RES_15_6_INCH(15.6),
        RES_17_INCH(17);

        public final double res;

        Screen (double res) {
            this.res = res;
        }
    }

    enum Brand implements Specs {
        APPLE,
        ACER,
        DEL,
        LENOVO;
    }
}