package ru.alina_corp.lesson3hw.company;

import java.util.Iterator;
import java.util.List;


/**
 * Класс Employees представляет собой контейнер для хранения сотрудников компании.
 */
public class Employees implements Iterable<BaseWorker> {
    private final List<BaseWorker> workers;


    /**
     * Конструктор, принимающий список сотрудников компании.
     * @param workers список сотрудников компании
     */
    public Employees(List<BaseWorker> workers) {
        this.workers = workers;
    }

    /**
     * Возвращает итератор для обхода коллекции сотрудников.
     * @return итератор для обхода коллекции сотрудников
     */
    @Override
    public Iterator<BaseWorker> iterator() {
        return new WorkerIterator();
    }



    /**
     * Внутренний класс, реализующий итератор для коллекции сотрудников.
     */
    private class WorkerIterator implements Iterator<BaseWorker> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < workers.size();
        }

        @Override
        public BaseWorker next() {
            return workers.get(currentIndex++);
        }
    }
}

