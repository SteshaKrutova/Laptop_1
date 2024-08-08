package com.geekbrains.sem1;

import java.util.*;

public class Search {
    //функция для красивого вывода списков
    public void list_output(ArrayList<Notebook> list){
        for (int i = 0; i < list.size(); i++) {
            System.out.print((i+1)+". ");
            System.out.println("Производитель - "+list.get(i).return_Name()+"; ОЗУ - "+list.get(i).return_Ram()+"; Объём ЖД - "+list.get(i).return_HardDiskSpace()+
                    "; Операционная система - "+list.get(i).return_OS()+"; Цвет - "+list.get(i).return_Color());
        }
    }

    //функция для красивого вывода списка (словаря) критериев
    public void dictionary_output(Map <String,ArrayList<Object>> dictionary){
        System.out.println("Производитель - "+dictionary.get("Name")+"; ОЗУ - "+dictionary.get("RAM")+"; Объём ЖД - "+dictionary.get("HardDisk")+
                "; Операционная система - "+dictionary.get("OS")+"; Цвет - "+dictionary.get("Color"));
    }

    // функция для создания списка рандомных
    public ArrayList create_random_list(int interpreter) {
        interpreter-=1;
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
            if (randomNumber>interpreter/4) randomNumber=interpreter/4;
            if (randomNumber<interpreter/6) randomNumber=interpreter/6;
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

            System.out.println("1 - Производитель");
            System.out.println("2 - Оперативная память");
            System.out.println("3 - Объем ЖД");
            System.out.println("4 - Операционная система");
            System.out.println("5 - Цвет");
            System.out.println("0 - Завершить ввод");
            int choice = scanner.nextInt();
            if (choice == 0) break;
            switch (choice) {
                case 1:
                    System.out.print("Введите допустимого производителя (Huawei, Honor, Apple, MAIBENBEN): ");
                    Object object_Name = scanner.next();
                    List_Name.add(object_Name);
                    filters.put("Name", List_Name);
                    break;
                case 2:
                    System.out.print("Введите минимальный объем оперативной памяти(2, 4, 8, 16, 32): ");
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
                    System.out.print("Введите минимальный объем жёсткого диска(128, 256, 512, 1024, 2048): ");
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
                    System.out.print("Введите допустимую операционную систему (Linux, Windows, Mac): ");
                    Object object = scanner.next();
                    List_OS.add(object);
                    filters.put("OS", List_OS);
                    break;
                case 5:
                    System.out.print("Введите допустимый цвет (black, red, blue, white, gray, pink): ");
                    Object object_color = scanner.next();
                    List_Color.add(object_color);
                    filters.put("Color", List_Color);
                    break;
            }
        }
        return filters;
    }

    public ArrayList result(Map <String,ArrayList<Object>> filters,ArrayList<Notebook> list) {
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
        System.out.println("По вашим запросам найдено "+ result.size()+" ноутбук(ов).");
        System.out.println("Отсортированный список:");
        return result;
    }

}