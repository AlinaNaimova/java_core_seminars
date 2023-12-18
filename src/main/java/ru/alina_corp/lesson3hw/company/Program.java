package ru.alina_corp.lesson3hw.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        // Создаем список работников
        List<BaseWorker> workers = new ArrayList<>();
        // Добавляем в список объекты Freelancer и Worker
        workers.add(new Freelancer("Баженов Дамир", 1519.07, 160, "developer"));
        workers.add(new Worker("Жданова Виктория", 200000, "developer"));
        workers.add(new Freelancer("Казакова Амелия", 1063.35, 180, "QA"));
        workers.add(new Worker("Алексеев Илья", 150000, "QA"));


        // Создаем объект Employees и передаем список работников в конструктор
        Employees employees = new Employees(workers);

        // Выводим информацию о каждом работнике, используя цикл for-each
        for (BaseWorker worker : employees) {
            System.out.println(worker.getName() + ": " + worker.calculateAverageMonthlySalary());
        }

        // Сортируем список работников по должности, используя компаратор PositionComparator
        Collections.sort(workers, new PositionComparator());
        System.out.println("Отсортированный список работников по должности" + workers);

        // Сортируем список работников по среднему месячному заработку, используя естественный порядок сортировки (Comparable)
        Collections.sort(workers);
        System.out.println("Отсортированный список работников по среднему месячному заработку" + workers);
    }
}

