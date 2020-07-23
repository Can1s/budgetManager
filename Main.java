package budget;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void chooseAction() {
        System.out.println("Choose your action:");
        System.out.println("1) Add income");
        System.out.println("2) Add purchase");
        System.out.println("3) Show list of purchases");
        System.out.println("4) Balance");
        System.out.println("5) Save");
        System.out.println("6) Load");
        System.out.println("7) Analyze (Sort)");
        System.out.println("0) Exit");
    }
    public static void chooseSort() {
        System.out.println("How do you want to sort?\n" +
                "1) Sort all purchases\n" +
                "2) Sort by type\n" +
                "3) Sort certain type\n" +
                "4) Back");
    }
    public static void printTypesOfPurchases() {
        System.out.println("Choose the type of purchase\n" +
                "1) Food\n" +
                "2) Clothes\n" +
                "3) Entertainment\n" +
                "4) Other\n" +
                "5) Back");
    }
    public static void printListOfPurchases() {
        System.out.println("Choose the type of purchases\n" +
                "1) Food\n" +
                "2) Clothes\n" +
                "3) Entertainment\n" +
                "4) Other\n" +
                "5) All\n" +
                "6) Back");
    }
    public static List<String> bubbleSort(List<String> purchases, List<String> price) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < price.size() - 1; i++) {
            for (int j = 0; j < price.size() - i - 1; j++) {
                if(Double.parseDouble(price.get(j)) < Double.parseDouble(price.get((j+1)))) {
                    String temp = price.get(j);
                    price.set(j, price.get(j+1));
                    price.set(j+1, temp);

                    String tmp = purchases.get(j);
                    purchases.set(j, purchases.get(j+1));
                    purchases.set(j+1, tmp);
                }
            }
        }
        for (int i = 0; i < purchases.size(); i++) {
            list.add(purchases.get(i) +  " $" + price.get(i));
        }
        return list;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double balance = 0;
        boolean trueOrFalse = true;

        double allSum = 0;
        double foodSum = 0;
        double clothesSum = 0;
        double entertainmentSum = 0;
        double otherSum = 0;

        List<String> allPurchaseList = new ArrayList<>();
        List<String> allPriceList = new ArrayList<>();

        List<String> foodPurchaseList = new ArrayList<>();
        List<String> foodPriceList = new ArrayList<>();

        List<String> clothesPurchaseList = new ArrayList<>();
        List<String> clothesPriceList = new ArrayList<>();

        List<String> entertainmentPurchaseList = new ArrayList<>();
        List<String> entertainmentPriceList = new ArrayList<>();

        List<String> otherPurchaseList = new ArrayList<>();
        List<String> otherPriceList = new ArrayList<>();

        while(trueOrFalse) {
            chooseAction();
            int action = scanner.nextInt();
            System.out.println();
            switch (action) {
                case 0:
                    trueOrFalse = false;
                    System.out.println("Bye!");
                    break;
                case 1:
                    System.out.println("Enter income:");
                    int income = scanner.nextInt();
                    balance += income;
                    System.out.println("Income was added!");
                    System.out.println();
                    break;
                case 2:
                    Scanner scanner1 = new Scanner(System.in);
                    boolean tf = true;
                    while(tf) {
                        printTypesOfPurchases();
                        int typeOfPurchase = scanner1.nextInt();
                        Scanner scanner2 = new Scanner(System.in);
                        System.out.println();
                        switch (typeOfPurchase) {
                            case 1:
                                System.out.println("Enter purchase name:");
                                String foodPurchaseName = scanner2.nextLine();
                                foodPurchaseList.add(foodPurchaseName);
                                allPurchaseList.add(foodPurchaseName);
                                System.out.println("Enter its price:");
                                double foodPrice = scanner2.nextDouble();
                                foodPriceList.add(String.valueOf(foodPrice));
                                allPriceList.add(String.valueOf(foodPrice));
                                foodSum += foodPrice;
                                allSum += foodPrice;
                                balance -= foodPrice;
                                System.out.println("Purchase was added!");
                                System.out.println();
                                break;
                            case 2:
                                System.out.println("Enter purchase name:");
                                String clothesPurchaseName = scanner2.nextLine();
                                clothesPurchaseList.add(clothesPurchaseName);
                                allPurchaseList.add(clothesPurchaseName);
                                System.out.println("Enter its price:");
                                double clothesPrice = scanner2.nextDouble();
                                clothesPriceList.add(String.valueOf(clothesPrice));
                                allPriceList.add(String.valueOf(clothesPrice));
                                clothesSum += clothesPrice;
                                allSum += clothesPrice;
                                balance -= clothesPrice;
                                System.out.println("Purchase was added!");
                                System.out.println();
                                break;
                            case 3:
                                System.out.println("Enter purchase name:");
                                String entertainmentPurchaseName = scanner2.nextLine();
                                entertainmentPurchaseList.add(entertainmentPurchaseName);
                                allPurchaseList.add(entertainmentPurchaseName);
                                System.out.println("Enter its price:");
                                double entertainmentPrice = scanner2.nextDouble();
                                entertainmentPriceList.add(String.valueOf(entertainmentPrice));
                                allPriceList.add(String.valueOf(entertainmentPrice));
                                entertainmentSum += entertainmentPrice;
                                allSum += entertainmentPrice;
                                balance -= entertainmentPrice;
                                System.out.println("Purchase was added!");
                                System.out.println();
                                break;
                            case 4:
                                System.out.println("Enter purchase name:");
                                String otherPurchaseName = scanner2.nextLine();
                                otherPurchaseList.add(otherPurchaseName);
                                allPurchaseList.add(otherPurchaseName);
                                System.out.println("Enter its price:");
                                double otherPrice = scanner2.nextDouble();
                                otherPriceList.add(String.valueOf(otherPrice));
                                allPriceList.add(String.valueOf(otherPrice));
                                otherSum += otherPrice;
                                allSum += otherPrice;
                                balance -= otherPrice;
                                System.out.println("Purchase was added!");
                                System.out.println();
                                break;
                            case 5:
                                tf = false;
                                break;
                        }
                    }
                    break;
                case 3:
                    boolean trueFalse = true;
                    if(allPurchaseList.isEmpty()) {
                        System.out.println("Purchase list is empty!");
                    } else {
                        while (trueFalse) {
                            printListOfPurchases();
                            int typeOfPurchases = scanner.nextInt();
                            System.out.println();
                            switch (typeOfPurchases) {
                                case 1:
                                    System.out.println("Food:");
                                    if(foodPurchaseList.isEmpty()) {
                                        System.out.println("Purchase list is empty!");
                                    } else {
                                        for (int i = 0; i < foodPurchaseList.size(); i++) {
                                            System.out.println(foodPurchaseList.get(i) + " $" + foodPriceList.get(i));
                                        }
                                        System.out.println("Total sum: $" + foodSum);
                                    }
                                    System.out.println();
                                    break;
                                case 2:
                                    System.out.println("Clothes:");
                                    if(clothesPurchaseList.isEmpty()) {
                                        System.out.println("Purchase list is empty!");
                                    } else {
                                        for (int i = 0; i < clothesPurchaseList.size(); i++) {
                                            System.out.println(clothesPurchaseList.get(i) + " $" + clothesPriceList.get(i));
                                        }
                                        System.out.println("Total sum: $" + clothesSum);
                                    }
                                    System.out.println();
                                    break;
                                case 3:
                                    System.out.println("Entertainment:");
                                    if(entertainmentPurchaseList.isEmpty()) {
                                        System.out.println("Purchase list is empty!");
                                    } else {
                                        for (int i = 0; i < entertainmentPurchaseList.size(); i++) {
                                            System.out.println(entertainmentPurchaseList.get(i) + " $" + entertainmentPriceList.get(i));
                                        }
                                        System.out.println("Total sum: $" + entertainmentSum);
                                    }
                                    System.out.println();
                                    break;
                                case 4:
                                    System.out.println("Other:");
                                    if(otherPurchaseList.isEmpty()) {
                                        System.out.println("Purchase list is empty!");
                                    } else {
                                        for (int i = 0; i < otherPurchaseList.size(); i++) {
                                            System.out.println(otherPurchaseList.get(i) + " $" + otherPriceList.get(i));
                                        }
                                        System.out.println("Total sum: $" + otherSum);
                                    }
                                    System.out.println();
                                    break;
                                case 5:
                                    System.out.println("All:");
                                    for (int i = 0; i < allPurchaseList.size(); i++) {
                                        System.out.println(allPurchaseList.get(i) + " $" + allPriceList.get(i));
                                    }
                                    System.out.println("Total sum: $" + allSum);
                                    System.out.println();
                                    break;
                                case 6:
                                    trueFalse = false;
                                    break;
                            }
                        }
                    }
                    break;
                case 4:
                    System.out.println("Balance: $" + balance);
                    System.out.println();
                    break;
                case 5:
                    try{
                        File file = new File(String.valueOf(Paths.get("purchases.txt")));
                        FileOutputStream fileOutputStream = new FileOutputStream(file);

                        fileOutputStream.write("ALL\n".getBytes());
                        for(int i = 0; i < allPurchaseList.size(); i++) {
                            fileOutputStream.write(allPurchaseList.get(i).getBytes());
                            fileOutputStream.write("=".getBytes());
                            if(String.valueOf(allPriceList.get(i)).
                                    substring(String.valueOf(allPriceList.get(i)).indexOf('.')).length() == 2) {
                                fileOutputStream.write((allPriceList.get(i) + "0").getBytes());
                            } else {
                                fileOutputStream.write(String.valueOf(allPriceList.get(i)).getBytes());
                            }
                            if(i+1 != allPurchaseList.size()) fileOutputStream.write("=".getBytes());
                        }
                        fileOutputStream.write("\n".getBytes());


                        fileOutputStream.write("FOOD\n".getBytes());
                        for(int i = 0; i < foodPurchaseList.size(); i++) {
                            fileOutputStream.write(foodPurchaseList.get(i).getBytes());
                            fileOutputStream.write("=".getBytes());
                            if(String.valueOf(foodPriceList.get(i)).
                                    substring(String.valueOf(foodPriceList.get(i)).indexOf('.')).length() == 2) {
                                fileOutputStream.write((foodPriceList.get(i) + "0").getBytes());
                            } else {
                                fileOutputStream.write(String.valueOf(foodPriceList.get(i)).getBytes());
                            }
                            if(i+1 != foodPurchaseList.size()) fileOutputStream.write("=".getBytes());
                        }
                        fileOutputStream.write("\n".getBytes());


                        fileOutputStream.write("ENTERTAINMENT\n".getBytes());
                        for(int i = 0; i < entertainmentPurchaseList.size(); i++) {
                            fileOutputStream.write(entertainmentPurchaseList.get(i).getBytes());
                            fileOutputStream.write("=".getBytes());
                            if(String.valueOf(entertainmentPriceList.get(i)).
                                    substring(String.valueOf(entertainmentPriceList.get(i)).indexOf('.')).length() == 2) {
                                fileOutputStream.write((entertainmentPriceList.get(i) + "0").getBytes());
                            } else {
                                fileOutputStream.write(String.valueOf(entertainmentPriceList.get(i)).getBytes());
                            }
                            if(i+1 != entertainmentPurchaseList.size()) fileOutputStream.write("=".getBytes());
                        }
                        fileOutputStream.write("\n".getBytes());


                        fileOutputStream.write("OTHER\n".getBytes());
                        for(int i = 0; i < otherPurchaseList.size(); i++) {
                            fileOutputStream.write(otherPurchaseList.get(i).getBytes());
                            fileOutputStream.write("=".getBytes());
                            if(String.valueOf(otherPriceList.get(i)).
                                    substring(String.valueOf(otherPriceList.get(i)).indexOf('.')).length() == 2) {
                                fileOutputStream.write((otherPriceList.get(i) + "0").getBytes());
                            } else {
                                fileOutputStream.write(String.valueOf(otherPriceList.get(i)).getBytes());
                            }
                            if(i+1 != otherPurchaseList.size()) fileOutputStream.write("=".getBytes());
                        }
                        fileOutputStream.write("\n".getBytes());


                        fileOutputStream.write("CLOTHES\n".getBytes());
                        for(int i = 0; i < clothesPurchaseList.size(); i++) {
                            fileOutputStream.write(clothesPurchaseList.get(i).getBytes());
                            fileOutputStream.write("=".getBytes());
                            if(String.valueOf(clothesPriceList.get(i)).
                                    substring(String.valueOf(clothesPriceList.get(i)).indexOf('.')).length() == 2) {
                                fileOutputStream.write((clothesPriceList.get(i) + "0").getBytes());
                            } else {
                                fileOutputStream.write(String.valueOf(clothesPriceList.get(i)).getBytes());
                            }
                            if(i+1 != clothesPurchaseList.size()) fileOutputStream.write("=".getBytes());
                        }
                        fileOutputStream.write("\n".getBytes());


                        fileOutputStream.write(String.valueOf(balance).getBytes());
                        fileOutputStream.close();
                        System.out.println("Purchases were saved!");
                        System.out.println();
                    } catch (IOException e) {
                        System.out.println("Exception");
                        System.out.println();
                    }
                    break;
                case 6:
                    try {
                        Scanner in = new Scanner(new File(String.valueOf(Paths.get("purchases.txt"))));
                        String all = in.nextLine();
                        String allList = in.nextLine();
                        String food = in.nextLine();
                        String foodList = in.nextLine();
                        String entertainment = in.nextLine();
                        String entertainmentList = in.nextLine();
                        String other = in.nextLine();
                        String otherList = in.nextLine();
                        String clothes = in.nextLine();
                        String clothesList = in.nextLine();
                        String bal = in.nextLine();
                        String[] allPurchases = allList.split("=");
                        String[] foodPurchases = foodList.split("=");
                        String[] entertainmentPurchases = entertainmentList.split("=");
                        String[] otherPurchases = otherList.split("=");
                        String[] clothesPurchases = clothesList.split("=");

                        for (int i = 0; i < allPurchases.length - 1; i+=2) {
                            allPurchaseList.add(allPurchases[i]);
                            allPriceList.add(allPurchases[i+1]);
                            allSum += Double.parseDouble(allPurchases[i+1]);
                        }
                        for (int i = 0; i < foodPurchases.length - 1; i+=2) {
                            foodPurchaseList.add(foodPurchases[i]);
                            foodPriceList.add(foodPurchases[i+1]);
                            foodSum += Double.parseDouble(foodPurchases[i+1]);
                        }
                        for (int i = 0; i < entertainmentPurchases.length - 1; i+=2) {
                            entertainmentPurchaseList.add(entertainmentPurchases[i]);
                            entertainmentPriceList.add(entertainmentPurchases[i+1]);
                            entertainmentSum += Double.parseDouble(entertainmentPurchases[i+1]);
                        }
                        for (int i = 0; i < otherPurchases.length - 1; i+=2) {
                            otherPurchaseList.add(otherPurchases[i]);
                            otherPriceList.add(otherPurchases[i+1]);
                            otherSum += Double.parseDouble(otherPurchases[i+1]);
                        }
                        for (int i = 0; i < clothesPurchases.length - 1; i+=2) {
                            clothesPurchaseList.add(clothesPurchases[i]);
                            clothesPriceList.add(clothesPurchases[i+1]);
                            clothesSum += Double.parseDouble(clothesPurchases[i+1]);
                        }
                        balance = Double.parseDouble(bal);
                        in.close();
                        System.out.println("Purchases were loaded!");
                        System.out.println();
                    } catch (IOException e) {
                        System.out.println("Exception");
                        System.out.println();
                    }
                    break;
                case 7:
                    Scanner scanner2 = new Scanner(System.in);
                    boolean bool = true;
                    while(bool) {
                        chooseSort();
                        int sort = scanner2.nextInt();
                        System.out.println();
                        switch (sort) {
                            case 1:
                                if (allPurchaseList.isEmpty()) {
                                    System.out.println("Purchase list is empty!");
                                } else {
                                    System.out.println("All:");
                                    List<String> list = bubbleSort(allPurchaseList, allPriceList);
                                    for (String s : list) {
                                        System.out.println(s);
                                    }
                                    System.out.println("Total sum: $" + allSum);
                                }
                                System.out.println();
                                break;
                            case 2:
                                System.out.println("Types:\n" +
                                        "Food - $" + String.format("%.2f", foodSum) + "\n" +
                                        "Entertainment - $" + String.format("%.2f", entertainmentSum) + "\n" +
                                        "Clothes - $" + String.format("%.2f", clothesSum) + "\n" +
                                        "Other - $" + String.format("%.2f", otherSum) + "\n" +
                                        "Total sum: $" + (allSum));
                                System.out.println();
                                break;
                            case 3:
                                System.out.println("Choose the type of purchase\n" +
                                        "1) Food\n" +
                                        "2) Clothes\n" +
                                        "3) Entertainment\n" +
                                        "4) Other");
                                int tp = scanner2.nextInt();
                                switch (tp) {
                                    case 1:
                                        System.out.println();
                                        System.out.println("Food:");
                                        if (foodPurchaseList.isEmpty()) {
                                            System.out.println("Purchase list is empty!");
                                        } else {
                                            List<String> list = bubbleSort(foodPurchaseList, foodPriceList);
                                            for(String s : list) {
                                                System.out.println(s);
                                            }
                                            System.out.println("Total sum: $" + foodSum);
                                        }
                                        System.out.println();
                                        break;
                                    case 2:
                                        System.out.println();
                                        System.out.println("Clothes:");
                                        if (clothesPurchaseList.isEmpty()) {
                                            System.out.println("Purchase list is empty!");
                                        } else {
                                            List<String> list = bubbleSort(clothesPurchaseList, clothesPriceList);
                                            for(String s : list) {
                                                System.out.println(s);
                                            }
                                            System.out.println("Total sum: $" + clothesSum);
                                        }
                                        System.out.println();
                                        break;
                                    case 3:
                                        System.out.println();
                                        System.out.println("Entertainment:");
                                        if (entertainmentPurchaseList.isEmpty()) {
                                            System.out.println("Purchase list is empty!");
                                        } else {
                                            List<String> list = bubbleSort(entertainmentPurchaseList,
                                                    entertainmentPriceList);
                                            for(String s : list) {
                                                System.out.println(s);
                                            }
                                            System.out.println("Total sum: $" + entertainmentSum);
                                        }
                                        System.out.println();
                                        break;
                                    case 4:
                                        System.out.println();
                                        System.out.println("Other:");
                                        if (otherPurchaseList.isEmpty()) {
                                            System.out.println("Purchase list is empty!");
                                        } else {
                                            List<String> list = bubbleSort(otherPurchaseList, otherPriceList);
                                            for(String s : list) {
                                                System.out.println(s);
                                            }
                                            System.out.println("Total sum: $" + otherSum);
                                        }
                                        System.out.println();
                                        break;
                                }
                                break;
                            case 4:
                                bool = false;
                                break;
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
