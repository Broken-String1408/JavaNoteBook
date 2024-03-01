
public class Main {
    public static void main(String[] args) {
        NoteBookDB db = new NoteBookDB();

        db.addNoteBook(
            new NoteBook(Specs.Brand.LENOVO, 15_000, Specs.RAM.RAM_2_GB, Specs.Color.BLUE, Specs.OS.WINDOWS, Specs.Screen.RES_15_6_INCH),
            new NoteBook(Specs.Brand.APPLE, 60_000, Specs.RAM.RAM_4_GB, Specs.Color.WHITE, Specs.OS.MAC, Specs.Screen.RES_14_INCH),
            new NoteBook(Specs.Brand.APPLE, 60_000, Specs.RAM.RAM_4_GB, Specs.Color.BLACK, Specs.OS.MAC, Specs.Screen.RES_14_INCH),
            new NoteBook(Specs.Brand.ACER, 40_000, Specs.RAM.RAM_8_GB, Specs.Color.SILVER, Specs.OS.LINUX, Specs.Screen.RES_17_INCH),
            new NoteBook(Specs.Brand.DEL, 120_000, Specs.RAM.RAM_16_GB, Specs.Color.GREY, Specs.OS.WINDOWS, Specs.Screen.RES_17_INCH)
        );

        db.runUserRequest();
    }
}
