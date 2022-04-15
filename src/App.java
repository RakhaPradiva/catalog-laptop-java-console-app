import java.util.*;

public class App {

    Scanner sc = new Scanner(System.in);

    ArrayList<String> ListLaptop = new ArrayList<String>();
    ArrayList<String> ListLaptopID = new ArrayList<String>();
    ArrayList<Integer> Listprice = new ArrayList<Integer>();
    ArrayList<Integer> ListStock = new ArrayList<Integer>();

    public static void main(String[] args) {
        new App();
    }

    public App() {

        int menu;
        do {
            menu();
            try {
                menu = sc.nextInt();
            } catch (Exception e) {
                menu = 0;
                System.out.println("Invalid Input");
            }
            sc.nextLine();

            switch (menu) {

                case 1:
                    AddLaptop();
                    break;

                case 2:
                    CatalogLaptop();
                    break;

                case 3:
                    SearchLaptop();
                    break;

                case 4:
                    System.out.println("Thank You");
                    break;

            }

        } while (menu != 4);

    }

    public void menu() {
        System.out.println("+==================================+");
        System.out.println("|    Welcome to Maju Jaya Store    |");
        System.out.println("+==================================+");
        System.out.println("|       <------------------>       |");
        System.out.println("|       |1. Add Laptop     |       |");
        System.out.println("|       |2. Catalog Laptop |       |");
        System.out.println("|       |3. Search Laptop  |       |");
        System.out.println("|       |4. Exit           |       |");
        System.out.println("|       <------------------>       |");
        System.out.println("+==================================+");
        System.out.print("Choose >> ");

    }

    // Menu 1 (Add Laptop)
    private void AddLaptop() {
        String brand, LaptopID;
        int price, stock;
        do {
            System.out.print("Add Laptop Brand [2 - 20 character] : ");
            brand = sc.nextLine().toUpperCase();
        } while (brand.length() < 2 || brand.length() > 20);

        LaptopID = "LAP-" + brand.charAt(0) + brand.charAt(brand.length() - 1);
        System.out.println("Laptop ID for this brand is : " + LaptopID);
        System.out.println("Press ENTER to continue");
        sc.nextLine();

        do {
            System.out.print("Add Laptop Price [Min - 3000000] : ");
            try {
                price = sc.nextInt();
            } catch (Exception e) {
                price = 0;
                System.out.println("Invalid Input!");
            }
            sc.nextLine();
        } while (price < 3000000);

        do {
            System.out.print("Add Laptop Stock [1 - 100] : ");
            try {
                stock = sc.nextInt();
            } catch (Exception e) {
                stock = 0;
                System.out.println("Invalid Input!");
            }
            sc.nextLine();
        } while (stock < 1 || stock > 100);

        ListLaptop.add(brand);
        Listprice.add(price);
        ListStock.add(stock);
        ListLaptopID.add(LaptopID);
        System.out.println();
        System.out.print("Laptop added, press ENTER to continue");
        sc.nextLine();
    }

    // Menu 2 (Catalog Laptop)
    private void CatalogLaptop() {
        int set;

        if (ListLaptop.isEmpty()) {
            System.out.println();
            System.out.println("+=============+");
            System.out.println("| No data yet |");
            System.out.println("+=============+");
            System.out.println();
        } else {
            System.out.println();
            System.out.println("+==================+");
            System.out.println("|  Catalog Laptop  |");
            System.out.println("+==================+");
            System.out.println();
            System.out.printf("\n| %-2s | %-10s | %-15s | %-15s | %-5s |\n", "No", "Laptop ID", "Brand", "Price",
                    "Stock");

            for (int i = 0; i < ListLaptop.size(); i++) {
                System.out.printf("\n| %-2d | %-10s | %-15s | %-15d | %-5d |\n", (i + 1), ListLaptopID.get(i),
                        ListLaptop.get(i), Listprice.get(i), ListStock.get(i));
            }
            System.out.println();

            do {
                System.out.println();
                System.out.println("+=============================+");
                System.out.println("|  Catalog Menu & Setting     |");
                System.out.println("+=============================+");
                System.out.println("| 1. Sort Brand to Ascending  |");
                System.out.println("| 2. Sort Brand to Descending |");
                System.out.println("| 3. Sort Price to Ascending  |");
                System.out.println("| 4. Sort Price to Descending |");
                System.out.println("| 5. Back to menu             |");
                System.out.println("+=============================+");
                System.out.print(">> ");

                try {
                    set = sc.nextInt();
                } catch (Exception e) {
                    set = 0;
                    System.out.println("Invalid Input");
                }
                sc.nextLine();

                switch (set) {

                    case 1:
                        sortBrandAc();
                        System.out.print("Brand sorted to ASCENDING order ! press ENTER to continue");
                        sc.nextLine();
                        System.out.printf("\n| %-2s | %-10s | %-15s | %-15s | %-5s |\n", "No", "Laptop ID", "Brand",
                                "Price", "Stock");
                        for (int i = 0; i < ListLaptop.size(); i++) {

                            System.out.printf("\n| %-2d | %-10s | %-15s | %-15d | %-5d |\n", (i + 1),
                                    ListLaptopID.get(i), ListLaptop.get(i), Listprice.get(i), ListStock.get(i));
                        }
                        break;

                    case 2:
                        sortBrandDc();
                        System.out.print("Brand sorted to DESCENDING order ! press ENTER to continue");
                        sc.nextLine();
                        System.out.printf("\n| %-2s | %-10s | %-15s | %-15s | %-5s |\n", "No", "Laptop ID", "Brand",
                                "Price", "Stock");
                        for (int i = 0; i < ListLaptop.size(); i++) {
                            System.out.printf("\n| %-2d | %-10s | %-15s | %-15d | %-5d |\n", (i + 1),
                                    ListLaptopID.get(i), ListLaptop.get(i), Listprice.get(i), ListStock.get(i));
                        }
                        break;

                    case 3:
                        sortPriceAc();
                        System.out.print("Price sorted to ASCENDING order ! press ENTER to continue");
                        sc.nextLine();
                        System.out.printf("\n| %-2s | %-10s | %-15s | %-15s | %-5s |\n", "No", "Laptop ID", "Brand",
                                "Price", "Stock");
                        for (int i = 0; i < ListLaptop.size(); i++) {
                            System.out.printf("\n| %-2d | %-10s | %-15s | %-15d | %-5d |\n", (i + 1),
                                    ListLaptopID.get(i), ListLaptop.get(i), Listprice.get(i), ListStock.get(i));
                        }
                        break;
                    case 4:
                        sortPriceDc();
                        System.out.print("Price sorted to DESCENDING order ! press ENTER to continue");
                        sc.nextLine();
                        System.out.printf("\n| %-2s | %-10s | %-15s | %-15s | %-5s |\n", "No", "Laptop ID", "Brand",
                                "Price", "Stock");
                        for (int i = 0; i < ListLaptop.size(); i++) {

                            System.out.printf("\n| %-2d | %-10s | %-15s | %-15d | %-5d |\n", (i + 1),
                                    ListLaptopID.get(i), ListLaptop.get(i), Listprice.get(i), ListStock.get(i));
                        }
                        break;
                    case 5:

                        break;
                }
            } while (set != 5);

        }

    }

    // Sort Ascending
    public void sortBrandAc() {
        String temp, temp3;
        int temp2, temp4;
        for (int i = 0; i < ListLaptop.size(); i++) {
            for (int j = 0; j < ListLaptop.size() - i - 1; j++) {
                if (ListLaptop.get(j).compareTo(ListLaptop.get(j + 1)) > 0) {
                    temp = ListLaptop.get(j);
                    ListLaptop.set(j, ListLaptop.get(j + 1));
                    ListLaptop.set(j + 1, temp);

                    temp2 = ListStock.get(j);
                    ListStock.set(j, ListStock.get(j + 1));
                    ListStock.set(j + 1, temp2);

                    temp3 = ListLaptopID.get(j);
                    ListLaptopID.set(j, ListLaptopID.get(j + 1));
                    ListLaptopID.set(j + 1, temp3);

                    temp4 = Listprice.get(j);
                    Listprice.set(j, Listprice.get(j + 1));
                    Listprice.set(j + 1, temp4);

                }
            }
        }
    }

    public void sortPriceAc() {
        String temp3, temp4;
        int temp, temp2;
        for (int i = 0; i < Listprice.size(); i++) {
            for (int j = 0; j < Listprice.size() - i - 1; j++) {
                if (Listprice.get(j) > Listprice.get(j + 1)) {
                    temp = Listprice.get(j);
                    Listprice.set(j, Listprice.get(j + 1));
                    Listprice.set(j + 1, temp);

                    temp2 = ListStock.get(j);
                    ListStock.set(j, ListStock.get(j + 1));
                    ListStock.set(j + 1, temp2);

                    temp3 = ListLaptopID.get(j);
                    ListLaptopID.set(j, ListLaptopID.get(j + 1));
                    ListLaptopID.set(j + 1, temp3);

                    temp4 = ListLaptop.get(j);
                    ListLaptop.set(j, ListLaptop.get(j + 1));
                    ListLaptop.set(j + 1, temp4);

                }
            }
        }
    }

    // Sort Descending
    public void sortBrandDc() {
        String temp, temp3;
        int temp2, temp4;
        for (int i = 0; i < ListLaptop.size(); i++) {
            for (int j = 0; j < ListLaptop.size() - i - 1; j++) {
                if (ListLaptop.get(j).compareTo(ListLaptop.get(j + 1)) < 0) {
                    temp = ListLaptop.get(j);
                    ListLaptop.set(j, ListLaptop.get(j + 1));
                    ListLaptop.set(j + 1, temp);

                    temp2 = ListStock.get(j);
                    ListStock.set(j, ListStock.get(j + 1));
                    ListStock.set(j + 1, temp2);

                    temp3 = ListLaptopID.get(j);
                    ListLaptopID.set(j, ListLaptopID.get(j + 1));
                    ListLaptopID.set(j + 1, temp3);

                    temp4 = Listprice.get(j);
                    Listprice.set(j, Listprice.get(j + 1));
                    Listprice.set(j + 1, temp4);

                }
            }
        }
    }

    public void sortPriceDc() {
        String temp3, temp4;
        int temp, temp2;
        for (int i = 0; i < Listprice.size(); i++) {
            for (int j = 0; j < Listprice.size() - i - 1; j++) {
                if (Listprice.get(j) < Listprice.get(j + 1)) {
                    temp = Listprice.get(j);
                    Listprice.set(j, Listprice.get(j + 1));
                    Listprice.set(j + 1, temp);

                    temp2 = ListStock.get(j);
                    ListStock.set(j, ListStock.get(j + 1));
                    ListStock.set(j + 1, temp2);

                    temp3 = ListLaptopID.get(j);
                    ListLaptopID.set(j, ListLaptopID.get(j + 1));
                    ListLaptopID.set(j + 1, temp3);

                    temp4 = ListLaptop.get(j);
                    ListLaptop.set(j, ListLaptop.get(j + 1));
                    ListLaptop.set(j + 1, temp4);

                }
            }
        }
    }

    // Menu 3 (Search Laptop)
    public void SearchLaptop() {
        String search;
        System.out.println();
        System.out.println("=============================");
        System.out.print("Search Laptop by brand or ID : ");
        search = sc.nextLine().toUpperCase();
        for (int i = 0; i < ListLaptop.size() -1; i++) {

            if (search.equals(ListLaptop.get(i)) || search.equals(ListLaptopID.get(i))) {
                System.out.println("Brand " + ListLaptop.get(i) + " with ID " + ListLaptopID.get(i)
                        + " found, press ENTER for more details");
                sc.nextLine();
                System.out.println("+==============+");
                System.out.println("|Search details|");
                System.out.println("+==============+");
                System.out.printf("\n| %-10s | %-15s | %-15s | %-5s |\n", "Laptop ID", "Brand",
                        "Price", "Stock");
                System.out.printf("\n| %-10s | %-15s | %-15d | %-5d |\n",
                        ListLaptopID.get(i), ListLaptop.get(i), Listprice.get(i), ListStock.get(i));
                System.out.println();
                System.out.print("press ENTER to go back menu");
                sc.nextLine();
            }

        }

    }

}