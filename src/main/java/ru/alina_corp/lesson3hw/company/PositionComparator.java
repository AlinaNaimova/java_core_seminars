package ru.alina_corp.lesson3hw.company;

import java.util.Comparator;


/** Класс PositionComparator реализует интерфейс Comparator<BaseWorker>
* для сравнения объектов типа BaseWorker по полю position
*/
public class PositionComparator implements Comparator<BaseWorker> {

    /* Метод compare сравнивает два объекта типа BaseWorker
    на основе значения поля position*/
    @Override
    public int compare(BaseWorker worker1, BaseWorker worker2) {
        /* Используем метод compareTo класса String для сравнения значений полей position
         и возвращаем результат сравнения*/
        return worker1.getPosition().compareTo(worker2.getPosition());
    }
}
