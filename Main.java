
public class Main {
    public static void main(String[] args) {
        NoteBookDB db = new NoteBookDB();
        db.addNoteBook(
            new NoteBook("Asus", 15_000, 2, NoteBook.Color.BLUE, NoteBook.OS.WINDOWS, 15.6),
            new NoteBook("IMac", 60_000, 4, NoteBook.Color.WHITE, NoteBook.OS.MAC, 14.0),
            new NoteBook("IMac", 60_000, 4, NoteBook.Color.BLACK, NoteBook.OS.MAC, 14.0),
            new NoteBook("Acer", 40_000, 8, NoteBook.Color.SILVER, NoteBook.OS.LINUX, 15.6)
        );
        // System.out.println(db.getAllNoteBooks());
        NoteBookDB.runUserRequest();
    }
}
