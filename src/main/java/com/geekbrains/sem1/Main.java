package com.geekbrains.sem1;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Main {
    //инструкция для пользования
    public void Instruction(){
        System.out.println("Помните: производителя, операционную систему и цвет вы можете выбрать из предложенных в скобоках  ");
        System.out.println("в любом количестве (скопировать-вставить), вводя по одному аргументу за раз, после нажатия цифры соответствующей  данному критерию.");
        System.out.println("!!!Не вводить дважды одно и то же!!!");
        System.out.println("А оператиную память и обьём жёсткого диска, вы можете вводить любыми числами (например, 333 или 456) так же в любом количестве, однако");
        System.out.println("програма будет отсеевать ноутбуки по наиболее большому, введённому вами числу");
    }

    //основная функция
    public static void main(String[] args) {
        //создание обьектов, выбор нужна ли инструкция
        Search shop = new Search();
        Main test = new Main();
        System.out.println("Магазин ноутбуков");
        System.out.println("Вам требуется инструкция?(1 - да, любая другая цифра - нет)");
        Scanner scanner = new Scanner(System.in);
        int ans = scanner.nextInt();
        if (ans ==1)  test.Instruction();

        //создание списка критериев ползователя
        System.out.println("Введите интересующие вас критерии:");
        Map <String,ArrayList<Object>> filters = shop.map_filtrs();

        //создание списска ноутбуков с рандомными атрибутами и его вывод
        System.out.print("Сколько ноутбуков будет в магазине? ");
        int size = scanner.nextInt();
        ArrayList<Notebook> random_list = shop.create_random_list(size);
        shop.list_output(random_list);
        System.out.println();

        //вывод ранее созданного списка критериев, созданиия итогового отсортированного списка и его вывод
        System.out.println("Введённые вами критерии:");
        shop.dictionary_output(filters);
        ArrayList<Notebook> search_list = shop.result(filters,random_list);
        shop.list_output(search_list);
        for (Notebook laptop_after:search_list) System.out.println(laptop_after);
    }
}