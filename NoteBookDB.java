import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
// import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class NoteBookDB {
    private static final int FILTER_PRICE = 1;
    private static final int FILTER_COLOR = 2;
    private static final int FILTER_SCREEN_RES = 3;
    private static final int FILTER_OS = 4;
    private static final int FILTER_RAM = 5;
    private static Map<Integer, FilterOptions> filters = new HashMap<>();
    private static int maxPrice = 0;
    private static Set<NoteBook> noteBooks = new HashSet<>();
    public static LinkedHashMap<NoteBook.Color, Integer> colorsMap = new LinkedHashMap<>();
    public static int colorID = 1;
    
    public void addNoteBook(NoteBook... args) {
        for (NoteBook noteBook : args) {
            noteBooks.add(noteBook);
            maxPrice = Math.max(noteBook.getPrice(), maxPrice);
            if(!colorsMap.containsKey(noteBook.getColor())) {
                 colorsMap.put(noteBook.getColor(), colorID);
                 colorID++;
            }
        }
    }
    public Set<NoteBook> getAllNoteBooks() {
        return noteBooks;
    }
    public static void runUserRequest(){
        System.out.println("Введите цифру соответствующую критерию: 1 - Цена, 2 - Цвет, 3 - Разрешение экрана, 4 - Операционная система, 5 - Оперативная память, 0 - вывести результат");
        Scanner scanner = new Scanner(System.in); 
        int option = scanner.nextInt();
        switch (option) {
            case FILTER_PRICE:  
                System.out.println("Введите значение до " + maxPrice);
                int price = scanner.nextInt();
                changeFilter(FILTER_PRICE, new FilterOptions.Price(price));
                break;
            case FILTER_COLOR:
                StringBuilder builder = new StringBuilder("Выберите цвет: ");

                for (NoteBook.Color color : colorsMap.keySet()){
                    int num = colorsMap.get(color);
                    builder.append(" | " + num + " - " + color + " | ");
                }
                System.out.println(builder.toString());
                // System.out.println("Выберите цвет: 1 - %s, 2 - %s, 3 - %s, 4 - %s, 5 - %s"
                // .formatted(NoteBook.Color.BLACK, NoteBook.Color.BLUE, NoteBook.Color.GREY, NoteBook.Color.SILVER, NoteBook.Color.WHITE));
                int colorNum = scanner.nextInt();
                for (NoteBook.Color color : colorsMap.keySet()){
                    if(colorsMap.get(color) == colorNum){
                        changeFilter(FILTER_COLOR, new FilterOptions.Color(color));
                        break;
                    }
                }
                // NoteBook.Color color;
                // switch (colorNum) {
                //     case 1: 
                //         color = NoteBook.Color.BLACK;
                //         changeFilter(FILTER_COLOR, new FilterOptions.Color(color));
                //         break;
                //     case 2: 
                //         color = NoteBook.Color.BLUE;
                //         changeFilter(FILTER_COLOR, new FilterOptions.Color(color));
                //         break;
                //     case 3: 
                //         color = NoteBook.Color.GREY;
                //         changeFilter(FILTER_COLOR, new FilterOptions.Color(color));
                //         break;
                //     case 4: 
                //         color = NoteBook.Color.SILVER;
                //         changeFilter(FILTER_COLOR, new FilterOptions.Color(color));
                //         break; 
                //     case 5: 
                //         color = NoteBook.Color.WHITE;
                //         changeFilter(FILTER_COLOR, new FilterOptions.Color(color));
                //         break;       
                
                //     default: System.out.println("Неправильное значение");
                //         break;
                // }
            break;
            case FILTER_OS:

            break;
            case FILTER_RAM:
            System.out.println("Pizdec");
            break;
            case FILTER_SCREEN_RES:

            break;
            default: System.out.println("Неверное значение");
                break;
        }
        scanner.close();
        Set<NoteBook> result = applyFilters();
        printResult(result);
    }
    private static Set<NoteBook> applyFilters(){

        Set<NoteBook> result = new HashSet<>(noteBooks);

        for (Integer filter : filters.keySet()){

            FilterOptions option = filters.get(filter);

            if (option == null) continue;

            switch (filter) {
                case FILTER_PRICE:
                    FilterOptions.Price price_option = (FilterOptions.Price) option;
                    int price = price_option.getPrice();
                    result = result
                            .stream()
                            .filter(n -> n.getPrice() <= price)
                            .collect(Collectors.toSet());
                    break;

                case FILTER_COLOR:
                    FilterOptions.Color color_option = (FilterOptions.Color) option;
                    NoteBook.Color color = color_option.getColor();
                    result = result
                            .stream()
                            .filter(n -> n.getColor().equals(color))
                            .collect(Collectors.toSet());
                    break;

                case FILTER_OS:
                    FilterOptions.OS os_option = (FilterOptions.OS) option;
                    NoteBook.OS os = os_option.getOs();
                    result = result
                            .stream()
                            .filter(n -> n.getSystem().equals(os))
                            .collect(Collectors.toSet());
                    break;

                case FILTER_RAM:
                    FilterOptions.RAM ram_option = (FilterOptions.RAM) option;
                    int ram = ram_option.getRam();
                    result = result
                            .stream()
                            .filter(n -> n.getRam() == ram)
                            .collect(Collectors.toSet());
                    break;

                case FILTER_SCREEN_RES:
                    FilterOptions.ScreenResolution res_option = (FilterOptions.ScreenResolution) option;
                    double res = res_option.getRes();
                    result = result
                            .stream()
                            .filter(n -> n.getScreenSize() == res)
                            .collect(Collectors.toSet());
                    break;
            }
            if (result.isEmpty()) break;
        }

        return result;
    }

    private static void printResult(Set<NoteBook> noteBooks){
        for (NoteBook noteBook : noteBooks) {
            System.out.println(noteBook);
        }
    }
    private static void changeFilter(Integer filter, FilterOptions option){
        filters.put(filter, option);
    }
}