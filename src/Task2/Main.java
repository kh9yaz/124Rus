package Task2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Profession create() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите название профессии");
        String name = scanner.nextLine();

        System.out.println("Введите категорию");
        String category = scanner.nextLine();

        System.out.println("Введите средний возраст");
        int avgAge = Integer.parseInt(scanner.nextLine());

        System.out.println("Введите среднюю зарплату");
        double avgSalary = Double.parseDouble(scanner.nextLine());

        System.out.println("Введите кол-во людей");
        int countPeople = Integer.parseInt(scanner.nextLine());

        return new Profession(name, avgSalary, avgAge, countPeople, category);
    }

    static void edit(Profession profession) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Что редактировать? 1.Название 2.Категория 3.Средний возраст 4.Средняя зарплата 5.Кол-во людей");
        int p = Integer.parseInt(scanner.nextLine());

        switch (p) {
            case 1: {
                String name = scanner.nextLine();
                profession.setName(name);
                break;
            }
            case 2: {
                String category = scanner.nextLine();
                profession.setCategory(category);
                break;
            }
            case 3: {
                int avgAge = Integer.parseInt(scanner.nextLine());
                profession.setAverageAge(avgAge);
                break;
            }
            case 4: {
                double avgSalary = Double.parseDouble(scanner.nextLine());
                profession.setAverageSalary(avgSalary);
                break;
            }
            case 5: {
                int countPeople = Integer.parseInt(scanner.nextLine());
                profession.setCountPeople(countPeople);
                break;
            }
        }
    }

    static void show(ArrayList<Profession> professions) {
        int i = 1;
        for(Profession profession : professions) {
            System.out.println(i + ". Название: " + profession.getName() + ", Категория: " + profession.getCategory() +
                    ", Зарплата: " + profession.getAverageSalary() + ", Возраст: " + profession.getAverageAge() +
                    ", Кол-во людей: " + profession.getCountPeople() + ", Общая зарплата: " + profession.calcTotalSalary());
            i++;
        }
        System.out.println();
    }

    static int compareByName(Profession p1, Profession p2) {
        return p1.getName().compareTo(p2.getName());
    }

    static int compareByCategory(Profession p1, Profession p2) {
        return p1.getCategory().compareTo(p2.getCategory());
    }

    static int compareByAge(Profession p1, Profession p2) {
        return Integer.compare(p1.getAverageAge(), p2.getAverageAge());
    }

    static int compareBySalary(Profession p1, Profession p2) {
        return Double.compare(p1.getAverageSalary(), p2.getAverageSalary());
    }

    static int compareByCountPeople(Profession p1, Profession p2) {
        return Integer.compare(p1.getCountPeople(), p2.getCountPeople());
    }

    static void sortList(ArrayList<Profession> professions) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("По чему сортировать? 1.Название 2.Категория 3.Средний возраст 4.Средняя зарплата 5.Кол-во людей");
        int p = Integer.parseInt(scanner.nextLine());

        switch (p) {
            case 1 -> professions.sort(Main::compareByName);
            case 2 -> professions.sort(Main::compareByCategory);
            case 3 -> professions.sort(Main::compareByAge);
            case 4 -> professions.sort(Main::compareBySalary);
            case 5 -> professions.sort(Main::compareByCountPeople);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Profession> list = new ArrayList<>();

        int action = 1;
        do {
            System.out.println("1.Добавление пустого объекта");
            System.out.println("2.Добавление объекта с данными");
            System.out.println("3.Редактирование объекта");
            System.out.println("4.Вывод");
            System.out.println("5.Сортировка");
            System.out.println("0.Выход");

            try {
                action = Integer.parseInt(scanner.nextLine());

                switch (action) {
                    case 1:
                        list.add(new Profession());
                        break;
                    case 2:
                        list.add(create());
                        break;
                    case 3: {
                        System.out.println("Введите индекс");
                        int index = Integer.parseInt(scanner.nextLine());
                        if (index > 0 && index <= list.size()) {
                            edit(list.get(index - 1));
                        } else {
                            System.out.println("Неверный индекс");
                        }
                        break;
                    }
                    case 4: {
                        show(list);
                        break;
                    }
                    case 5: {
                        sortList(list);
                        break;
                    }
                }
            }
            catch (Exception exc) {
                System.out.println("Неверно введенные данные");
            }
        }
        while (action != 0);
    }
}
