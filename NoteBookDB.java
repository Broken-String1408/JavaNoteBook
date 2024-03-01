import java.util.*;
// import java.util.List;
import java.util.stream.Collectors;

public class NoteBookDB {
    private final Set<NoteBook> noteBooks = new HashSet<>();
    private final Map<Specs.Spec, Specs> filters = new HashMap<>();
    private int maxPrice = 0;
    private int filterPrice = 0;
    
    public void addNoteBook(NoteBook... args) {
        for (NoteBook noteBook : args) {
            noteBooks.add(noteBook);
            maxPrice = Math.max(noteBook.getPrice(), maxPrice);
        }
    }


    public Set<NoteBook> getAllNoteBooks() {
        return noteBooks;
    }


    public void runUserRequest() throws InputMismatchException{

        Scanner scanner = new Scanner(System.in);

        while (true){

            try {
                System.out.println(buildMenuString());
                int option = scanner.nextInt();

                if(option == Specs.Spec.PRICE.num){
                    managePricePick(scanner);
                }
                else if(option == Specs.Spec.COLOR.num){
                    manageColorPick(scanner);
                }
                else if(option == Specs.Spec.OS.num){
                    manageOsPick(scanner);
                }
                else if(option == Specs.Spec.RAM.num){
                    manageRamPick(scanner);
                }
                else if(option == Specs.Spec.SCREEN.num){
                    manageScreenPick(scanner);
                }
                else if(option == Specs.Spec.BRAND.num){
                    manageBrandPick(scanner);
                }
                else if(option == 0){
                    break;
                }
            } catch (InputMismatchException e){
                System.out.println("Неверное значение");
                scanner.nextLine();
            }
        }


        Set<NoteBook> result = getFilteredNotebooksSet();
        printResult(result);
        scanner.close();
    }


    private String buildMenuString(){

        StringBuilder menu = new StringBuilder("Введите цифру, соответствующую критерию: ");
        menu.append(System.lineSeparator());

        for (Specs.Spec spec : Specs.Spec.values()){
            menu.append(spec.num).append(" - ").append(spec.desc);
            if(filters.get(spec) != null){
                if(spec.num == Specs.Spec.PRICE.num){
                    menu.append(" (").append(filterPrice).append(") | ");
                }
                else
                    menu.append(" (").append(filters.get(spec)).append(") | ");
            }
            else
                menu.append(" | ");
        }
        menu.append(System.lineSeparator()).append("Введите 0 для вывода результата");
        return menu.toString();
    }

    private void managePricePick(Scanner scanner){
        System.out.println("Введите значение до " + maxPrice);
        filterPrice = scanner.nextInt();
        addFilter(Specs.Spec.PRICE, Specs.PRICE.STUB);
    }

    private void manageColorPick(Scanner scanner){
        StringBuilder colorList = new StringBuilder("Выберите цвет: ");
        int num = 1;

        for (Specs.Color value : Specs.Color.values()){
            colorList.append(" | ").append(num).append(" - ").append(value).append(" | ");
            num ++;
        }
        System.out.println(colorList);
        int userChoice = scanner.nextInt() - 1;

        addFilter(Specs.Spec.COLOR, Specs.Color.values()[userChoice]);
    }

    private void manageOsPick(Scanner scanner){
        StringBuilder osList = new StringBuilder("Выберите предустановленную ОС: ");
        int num = 1;

        for (Specs.OS value : Specs.OS.values()){
            osList.append(" | ").append(num).append(" - ").append(value).append(" | ");
            num ++;
        }
        System.out.println(osList);
        int userChoice = scanner.nextInt() - 1;
        addFilter(Specs.Spec.OS, Specs.OS.values()[userChoice]);
    }

    private void manageRamPick(Scanner scanner){
        StringBuilder ramList = new StringBuilder("Выберите кол-во ОЗУ: ");
        int num = 1;

        for (Specs.RAM value : Specs.RAM.values()){
            ramList.append(" | ").append(num).append(" - ").append(value).append(" | ");
            num ++;
        }
        System.out.println(ramList);
        int userChoice = scanner.nextInt() - 1;
        addFilter(Specs.Spec.RAM, Specs.RAM.values()[userChoice]);
    }

    private void manageScreenPick(Scanner scanner){
        StringBuilder screenList = new StringBuilder("Выберите размер экрана: ");
        int num = 1;

        for (Specs.Screen value : Specs.Screen.values()){
            screenList.append(" | ").append(num).append(" - ").append(value).append(" | ");
            num ++;
        }
        System.out.println(screenList);
        int userChoice = scanner.nextInt() - 1;
        addFilter(Specs.Spec.SCREEN, Specs.Screen.values()[userChoice]);
    }

    private void manageBrandPick(Scanner scanner){
        StringBuilder brandList = new StringBuilder("Выберите производителя: ");
        int num = 1;

        for (Specs.Brand value : Specs.Brand.values()){
            brandList.append(" | ").append(num).append(" - ").append(value).append(" | ");
            num ++;
        }
        System.out.println(brandList);
        int userChoice = scanner.nextInt() - 1;
        addFilter(Specs.Spec.BRAND, Specs.Brand.values()[userChoice]);
    }

    private Set<NoteBook> getFilteredNotebooksSet(){

        Set<NoteBook> result = new HashSet<>(noteBooks);

        for (Specs.Spec filter : filters.keySet()){

            Specs option = filters.get(filter);

            if (option == null) continue;

            switch (filter) {
                case Specs.Spec.PRICE:
                    result = result
                            .stream()
                            .filter(n -> n.getPrice() <= filterPrice)
                            .collect(Collectors.toSet());
                    break;

                case Specs.Spec.COLOR:
                    Specs.Color color = (Specs.Color) option;
                    result = result
                            .stream()
                            .filter(n -> n.getColor().equals(color))
                            .collect(Collectors.toSet());
                    break;

                case Specs.Spec.OS:
                    Specs.OS os = (Specs.OS) option;
                    result = result
                            .stream()
                            .filter(n -> n.getSystem().equals(os))
                            .collect(Collectors.toSet());
                    break;

                case Specs.Spec.RAM:
                    Specs.RAM ram = (Specs.RAM) option;
                    result = result
                            .stream()
                            .filter(n -> n.getRam() == ram.capacity)
                            .collect(Collectors.toSet());
                    break;

                case Specs.Spec.SCREEN:
                    Specs.Screen res_option = (Specs.Screen) option;
                    double res = res_option.res;
                    result = result
                            .stream()
                            .filter(n -> n.getScreenSize() == res)
                            .collect(Collectors.toSet());
                    break;
                case Specs.Spec.BRAND:
                    Specs.Brand brand_option = (Specs.Brand) option;
                    result = result
                            .stream()
                            .filter(n -> n.getBrand().equals(brand_option))
                            .collect(Collectors.toSet());
                    break;
            }

            if (result.isEmpty()) break;
        }

        return result;
    }

    private void printResult(Set<NoteBook> noteBooks){
        for (NoteBook noteBook : noteBooks) {
            System.out.println(noteBook);
        }
    }
    private void addFilter(Specs.Spec filter, Specs option){
        filters.put(filter, option);
    }
}