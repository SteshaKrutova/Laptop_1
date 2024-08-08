package com.geekbrains.sem1;

import java.util.*;

public class BeckUp {
    public Map map_filtrs(){
        Map <String,ArrayList<Object>> filters = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        TreeSet<Integer> Teree_RAM = new TreeSet<>();
        TreeSet<Integer> Teree_HardDisk = new TreeSet<>();
        ArrayList<Object> List_Name = new ArrayList<>();
        ArrayList<Object> List_OS = new ArrayList<>();
        ArrayList<Object> List_Color = new ArrayList<>();

        while (true) {
            System.out.println("Введите цифру, соответствующую необходимому критерию:");

            System.out.println("1 - Марка");
            System.out.println("2 - Оперативная память");
            System.out.println("3 - Объем ЖД");
            System.out.println("4 - Операционная система");
            System.out.println("5 - Цвет");
            System.out.println("0 - Завершить ввод");
            int choice = scanner.nextInt();
            if (choice == 0) break;
            switch (choice) {
                case 1:
                    System.out.println("Введите допустимую модель (Huawei, Honor, Apple, MAIBENBEN): ");
                    Object object_Name = scanner.next();
                    List_Name.add(object_Name);
                    filters.put("Name", List_Name);
                    break;
                case 2:
                    System.out.println("Введите минимальный объем оперативной памяти:");
                    System.out.println("!!!Программа защитает самое большое введённое значение!!!");
                    try {
                        Teree_RAM.add(Integer.parseInt(scanner.next()));
                        ArrayList<Object> List_RAM = new ArrayList<>();
                        Object object_RAM = Teree_RAM.last();
                        List_RAM.add(object_RAM);
                        System.out.println(Teree_RAM);
                        filters.put("RAM", List_RAM);
                    } catch (NullPointerException e) {
                        System.out.println("введите число!!!");
                    } finally {
                        break;
                    }
                case 3:
                    System.out.println("Введите минимальный объем жёсткого диска:");
                    System.out.println("!!!Программа защитает самое большое введённое значение!!!");
                    try {
                        Teree_HardDisk.add(Integer.parseInt(scanner.next()));
                        ArrayList<Object> List_HardDisk = new ArrayList<>();
                        Object object_hd = Teree_HardDisk.last();
                        List_HardDisk.add(object_hd);
                        System.out.println(Teree_HardDisk);
                        filters.put("HardDisk", List_HardDisk);
                    } catch (NullPointerException e) {
                        System.out.println("введите число!!!");
                    } finally {
                        break;
                    }
                case 4:
                    System.out.println("Введите допустимую операционную систему (Linux, Windows, Mac):");
                    Object object = scanner.next();
                    List_OS.add(object);
                    filters.put("OS", List_OS);
                    break;
                case 5:
                    System.out.println("Введите допустимый цвет (black, red, blue, white, gray, pink)");
                    Object object_color = scanner.next();
                    List_Color.add(object_color);
                    filters.put("Color", List_Color);
                    break;
            }
        }
        return filters;
    }

    public ArrayList create_random_list_1(int interpreter) {
        ArrayList<Notebook> bugatti_list = new ArrayList<>();
        ArrayList<String> Name = new ArrayList<>(Arrays.asList("Huawei", "Honor", "Apple", "MAIBENBEN"));
        ArrayList<String> RAM = new ArrayList<>(Arrays.asList("2", "4", "8", "16", "32"));
        ArrayList<String> HardDiskSpace = new ArrayList<>(Arrays.asList("128", "256", "512", "1024", "2048"));
        ArrayList<String> OS = new ArrayList<>(Arrays.asList("Linux", "Windows", "Mac"));
        ArrayList<String> Color = new ArrayList<>(Arrays.asList("black", "red", "blue", "white", "gray", "pink"));
        int counter = 0;
        while (bugatti_list.size()<interpreter) {
            if (counter>=3) counter=3;
            Random random = new Random();
            int randomNumber = random.nextInt(interpreter);

            for (int i = 0; i < randomNumber; i++) {
                if (bugatti_list.size()>interpreter) break;
                int randomNumber_OS = random.nextInt(2);
                if (counter==2) randomNumber_OS = 2;
                Notebook Test1 = new Notebook(Name.get(counter), RAM.get(random.nextInt(4)), HardDiskSpace.get(random.nextInt(4)), OS.get(randomNumber_OS), Color.get(random.nextInt(4)));
                bugatti_list.add(Test1);
            }
            counter+=1;
        }
        return bugatti_list;
    }

    public ArrayList Result(Map <String,ArrayList<Object>> filters,ArrayList<Notebook> list) {
        ArrayList<Notebook> result = new ArrayList<>();

        for (Notebook Turn:list) {
            int counter = 0;
            if (filters.get("Name")!=null) {
                for (Object i : filters.get("Name")) {
                    if (i.equals(Turn.return_Name())) counter += 1;
                }
            }
            else counter+=1;

            if (filters.get("OS")!=null) {
                for (Object i : filters.get("OS")) {
                    if (i.equals(Turn.return_OS())) counter += 1;
                }
            }
            else counter+=1;

            if (filters.get("Color")!=null) {
                for (Object i : filters.get("Color")) {
                    if (i.equals(Turn.return_Color())) counter += 1;
                }
            }
            else counter+=1;

            if (filters.get("RAM")!=null) {
                if ((int)filters.get("RAM").get(0) <= Integer.parseInt(Turn.return_Ram())){
                    counter += 1;
                }
            }
            else counter+=1;

            if (filters.get("HardDisk")!=null) {
                if ((int)filters.get("HardDisk").get(0) <= Integer.parseInt(Turn.return_HardDiskSpace())){
                    counter += 1;
                }
            }
            else counter+=1;

            if (counter == 5) result.add(Turn);
        }
        System.out.println("Итоговый список:");
        return result;
    }

    public static void main(String[] args) {
        BeckUp Test = new BeckUp();
        ArrayList<Notebook> bugatti_list = Test.create_random_list_1(10);
        Map <String,ArrayList<Object>> filters = Test.map_filtrs();

        ArrayList<Notebook> result = Test.Result(filters,bugatti_list);
        for (Notebook j:bugatti_list) System.out.println(j);
        System.out.println();
        for (Notebook i:result) System.out.println(i);

    }

    public static class TestLaptop {
        public ArrayList create_random_list_1(int interpreter) {
            ArrayList<Notebook> bugatti_list = new ArrayList<>();
            ArrayList<String> Name = new ArrayList<>(Arrays.asList("Huawei", "Honor", "Apple", "MAIBENBEN"));
            ArrayList<String> RAM = new ArrayList<>(Arrays.asList("2", "4", "8", "16", "32"));
            ArrayList<String> HardDiskSpace = new ArrayList<>(Arrays.asList("128", "256", "512", "1024", "2048"));
            ArrayList<String> OS = new ArrayList<>(Arrays.asList("Linux", "Windows", "Mac"));
            ArrayList<String> Color = new ArrayList<>(Arrays.asList("black", "red", "blue", "white", "gray", "pink"));
            int counter = 0;
            while (bugatti_list.size()<interpreter) {
                if (counter>=3) counter=3;
                Random random = new Random();
                int randomNumber = random.nextInt(interpreter);

                for (int i = 0; i < randomNumber; i++) {
                    if (bugatti_list.size()>interpreter) break;
                    int randomNumber_OS = random.nextInt(2);
                    if (counter==2) randomNumber_OS = 2;
                    Notebook Test1 = new Notebook(Name.get(counter), RAM.get(random.nextInt(4)), HardDiskSpace.get(random.nextInt(4)), OS.get(randomNumber_OS), Color.get(random.nextInt(4)));
                    bugatti_list.add(Test1);
                }
                counter+=1;
            }
            return bugatti_list;
        }

        public Map search(){
            Map <String,ArrayList<Object>> filters = new HashMap<>();
            Scanner scanner = new Scanner(System.in);

            TreeSet<Integer> Teree_RAM = new TreeSet<>();
            TreeSet<Integer> Teree_HardDisk = new TreeSet<>();
            ArrayList<Object> List_Name = new ArrayList<>();
            ArrayList<Object> List_OS = new ArrayList<>();
            ArrayList<Object> List_Color = new ArrayList<>();

            while (true) {
                System.out.println("Введите цифру, соответствующую необходимому критерию:");

                System.out.println("1 - Марка");
                System.out.println("2 - Оперативная память");
                System.out.println("3 - Объем ЖД");
                System.out.println("4 - Операционная система");
                System.out.println("5 - Цвет");
                System.out.println("0 - Завершить ввод");
                int choice = scanner.nextInt();
                if (choice == 0) break;
                switch (choice) {
                    case 1:
                        System.out.println("Введите допустимую модель (Huawei, Honor, Apple, MAIBENBEN): ");
                        Object object_Name = scanner.next();
                        List_Name.add(object_Name);
                        filters.put("Name", List_Name);
                        break;
                    case 2:
                        System.out.println("Введите минимальный объем оперативной памяти:");
                        System.out.println("!!!Программа защитает самое большое введённое значение!!!");
                        try {
                            Teree_RAM.add(Integer.parseInt(scanner.next()));
                            ArrayList<Object> List_RAM = new ArrayList<>();
                            Object object_RAM = Teree_RAM.last();
                            List_RAM.add(object_RAM);
                            System.out.println(Teree_RAM);
                            filters.put("RAM", List_RAM);
                        } catch (NullPointerException e) {
                            System.out.println("введите число!!!");
                        } finally {
                            break;
                        }
                    case 3:
                        System.out.println("Введите минимальный объем жёсткого диска:");
                        System.out.println("!!!Программа защитает самое большое введённое значение!!!");
                        try {
                            Teree_HardDisk.add(Integer.parseInt(scanner.next()));
                            ArrayList<Object> List_HardDisk = new ArrayList<>();
                            Object object_hd = Teree_HardDisk.last();
                            List_HardDisk.add(object_hd);
                            System.out.println(Teree_HardDisk);
                            filters.put("HardDisk", List_HardDisk);
                        } catch (NullPointerException e) {
                            System.out.println("введите число!!!");
                        } finally {
                            break;
                        }
                    case 4:
                        System.out.println("Введите допустимую операционную систему (Linux, Windows, Mac):");
                        Object object = scanner.next();
                        List_OS.add(object);
                        filters.put("OS", List_OS);
                        break;
                    case 5:
                        System.out.println("Введите допустимый цвет (black, red, blue, white, gray, pink)");
                        Object object_color = scanner.next();
                        List_Color.add(object_color);
                        filters.put("Color", List_Color);
                        break;
                }
            }
            return filters;
        }

        public ArrayList Result(Map <String,String> filters,ArrayList<Notebook> list) {
            ArrayList<Notebook> result = new ArrayList<Notebook>();
            for (Notebook Turn:list){
                if(filters.get("Name")==Turn.return_Name()| filters.get("Name").isEmpty()) {
                    if (filters.get("OS") == Turn.return_OS() | filters.get("OS").isEmpty()) {
                        if (filters.get("Color") == Turn.return_Color() | filters.get("Color").isEmpty()) {
                            if (Integer.parseInt(filters.get("RAM")) <= Integer.parseInt(Turn.return_Ram())) {
                                if (Integer.parseInt(filters.get("HardDiskSpace")) <= Integer.parseInt(Turn.return_HardDiskSpace()))
                                    result.add(Turn);
                            }
                        }
                    }
                }
                System.out.println(Turn);
            }
          //  System.out.println(filters.get("Name")+" "+filters.get("RAM")+" "+filters.get("HardDiskSpace")+" "+filters.get("OS")+" "+filters.get("Color"));
            System.out.println("Итоговый список:");
            return result;
        }

        public static void main(String[] args) {
            TestLaptop Test = new TestLaptop();
            //ArrayList<Notebook> Test1 = Test.create_random_list_1(10);
            Map <String,String> filters = new HashMap<>();
            Map <String,String> filtersMap = Test.search();
            filters.put("Name", "");
            filters.put("RAM", "2");
            filters.put("HardDiskSpace", "1000");
            filters.put("OS", "");
            filters.put("Color", "red");

            System.out.println(filters);
            System.out.println(filtersMap);
         //   if(filters.getClass()==filtersMap.getClass()) System.out.println("True");
         //   ArrayList<Notebook> Result = Test.Result(filters,Test1);
          //  for (Notebook i:Result) System.out.println(i);
        }
    }
}


//public ArrayList create_random_list(int interpreter){
//    ArrayList<Notebook> bugatti_list = new ArrayList<>();
//    ArrayList<String> Name = new ArrayList<>(Arrays.asList("Huawei","Honor","Apple","MAIBENBEN"));
//    ArrayList<String> RAM = new ArrayList<>(Arrays.asList("2","4","8","16","32"));
//    ArrayList<String> HardDiskSpace = new ArrayList<>(Arrays.asList("128","256","512","1024","2048"));
//    ArrayList<String> OS = new ArrayList<>(Arrays.asList("Linux","Windows","Mac"));
//    ArrayList<String> Color = new ArrayList<>(Arrays.asList("black","red","blue","white","gray","pink"));
//
//    for (int j = 0; j < interpreter; j++) {
//        Random random = new Random();
//        int randomNumber = random.nextInt(5);
//        int randomNumber1 = random.nextInt(3);
//        int randomNumber2 = random.nextInt(5);
//        int randomNumber3 = random.nextInt(5);
//        Notebook Test1 = new Notebook(Name.get(randomNumber1), RAM.get(randomNumber2),HardDiskSpace.get(randomNumber3),OS.get(randomNumber1),Color.get(randomNumber2));
//        bugatti_list.add(Test1);
//
//    }
//    return bugatti_list;
//}

//public Map data_collection(){
//    Map <String,String> filters = new HashMap<>();
//    Scanner scanner = new Scanner(System.in);
//
//    while (true) {
//        System.out.println("Введите цифру, соответствующую необходимому критерию:");
//        System.out.println("1 - оперативная память");
//        System.out.println("2 - Объем ЖД");
//        System.out.println("3 - Операционная система");
//        System.out.println("4 - Цвет");
//        System.out.println("0 - Завершить ввод");
//
//        int choice = scanner.nextInt();
//        if (choice == 0) break;
//        switch (choice) {
//            case 1:
//                System.out.println("Введите минимальный объем оперативной памяти:");
//                filters.put("RAM",scanner.next());
//                break;
//            case 2:
//                System.out.println("Введите минимальный объем жёсткого диска:");
//                filters.put("HardDiskSpace",scanner.next());
//                break;
//            case 3:
//                System.out.println("Введите допустимую операционную систему:");
//                filters.put("OS",scanner.next());
//                break;
//            case 4:
//                System.out.println("Введите допустимый цвет:");
//                filters.put("Color",scanner.next());
//                break;
//
//        }
//        //    System.out.println(filters);
//
//    }
//    return filters;
//}

//public Map Result(Map <String,String> filters,ArrayList list) {
//    for (int i = 0; i < list.size(); i++) {
//        System.out.println(list.get(i));
//    }
//    return filters;
//}
//public static void main(String[] args) {
//    Search Test = new Search();
//    ArrayList<Notebook> Test1 = Test.create_random_list(2);
//    Map <String,String> filters = new HashMap<>();
//    filters.put("Name", "Huawei");
//    filters.put("RAM", "4");
//    filters.put("HardDiskSpace", "256");
//    filters.put("OS", "Windows");
//    filters.put("Collor", "gray");
//    System.out.println(Test.Result(filters,Test1));
//
//}