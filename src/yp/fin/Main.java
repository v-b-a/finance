package yp.fin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        HashMap<String, ArrayList<Double>> category = new HashMap<>();
        ArrayList<Double> supermarket = new ArrayList<>();
        ArrayList<Double> movie = new ArrayList<>();
        ArrayList<Double> coffee = new ArrayList<>();
        category.put("Супермаркет", supermarket);
        category.put("Кино", movie);
        category.put("Кафе", coffee);
        for (int i = 0; i < 7; i++) {
            supermarket.add(0.0);
            movie.add(0.0);
            coffee.add(0.0);
        }
        System.out.println(movie);



        ArrayList<Double> expenses = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            expenses.add(0.0);
        }

        double rateUSD = 78.5;
        double rateEUR = 85;
        double rateJPY = 0.74;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Сколько денег у вас осталось до зарплаты?");
        double moneyBeforeSalary = scanner.nextDouble();

        System.out.println("Сколько дней до зарплаты?");
        int daysBeforeSalary = scanner.nextInt();

        while (true) {
            System.out.println("Что вы хотите сделать?");
            System.out.println("1 - Конвертировать валюту");
            System.out.println("2 - Получить совет");
            System.out.println("3 - Ввести трату");
            System.out.println("4 - Показать траты за неделю");
            System.out.println("5 — Показать самую большую сумму расходов за неделю");
            System.out.println("0 - Выход");

            int command = scanner.nextInt();

            if (command == 1) {
                System.out.println("Ваши сбережения: " + moneyBeforeSalary + " RUB");
                System.out.println("В какую валюту хотите конвертировать? Доступные варианты: 1 - USD, 2 - EUR, 3 - JPY.");
                int currency = scanner.nextInt();
                if (currency == 1) {
                    System.out.println("Ваши сбережения в долларах: " + moneyBeforeSalary / rateUSD);
                } else if (currency == 2) {
                    System.out.println("Ваши сбережения в евро: " + moneyBeforeSalary / rateEUR);
                } else if (currency == 3) {
                    System.out.println("Ваши сбережения в иенах: " + moneyBeforeSalary / rateJPY);
                } else {
                    System.out.println("Неизвестная валюта");
                }
            } else if (command == 2) {
                if (moneyBeforeSalary < 3000) {
                    System.out.println("Сегодня лучше поесть дома. Экономьте, и вы дотянете до зарплаты!");
                } else if (moneyBeforeSalary < 10000) {
                    if (daysBeforeSalary < 10) {
                        System.out.println("Окей, пора в Макдак!");
                    } else {
                        System.out.println("Сегодня лучше поесть дома. Экономьте, и вы дотянете до зарплаты!");
                    }
                } else if (moneyBeforeSalary < 30000) {
                    if (daysBeforeSalary < 10) {
                        System.out.println("Неплохо! Прикупите долларов и зайдите поужинать в классное место. :)");
                    } else {
                        System.out.println("Окей, пора в Макдак!");
                    }
                } else {
                    if (daysBeforeSalary < 10) {
                        System.out.println("Отлично! Заказывайте крабов!");
                    } else {
                        System.out.println("Неплохо! Прикупите долларов и зайдите поужинать в классное место. :)");
                    }
                }
            } else if (command == 3) {
                System.out.println("За какой день вы хотите ввести трату: 1-ПН, 2-ВТ, 3-СР, 4-ЧТ, 5-ПТ, 6-СБ, 7-ВС?");
                int day = scanner.nextInt();
                System.out.println("В какой категории трата: 1 - супермаркет, 2 - кино, 3- кафе");
                int userCategory = scanner.nextInt();
                System.out.println("Введите размер траты:");
                Double expense = scanner.nextDouble();
                moneyBeforeSalary = moneyBeforeSalary - expense;
                if (userCategory == 1) {
                    supermarket.set((day - 1), supermarket.get(day - 1) + expense);
                } else if (userCategory == 2) {
                    movie.set((day - 1), movie.get(day - 1) + expense);
                } else if (userCategory == 3) {
                    coffee.set((day - 1), coffee.get(day - 1) + expense);
                }

//                expenses.add((day - 1), expense); //добавил значение в список
                System.out.println("Значение сохранено! Ваш текущий баланс в рублях: " + moneyBeforeSalary);
                if (moneyBeforeSalary < 1000) {
                    System.out.println("На вашем счету осталось совсем немного. Стоит начать экономить!");
                }
            } else if (command == 4) {
                for (int i = 0; i < supermarket.size()-1; i++) {
                    System.out.println("День " + (i + 1));
                    for (String catName : category.keySet()){
                        System.out.println("__Категория " + catName +": " + category.get(catName).get(i));
                    }
                }
            }
            else if (command == 5) {
                /* Объявляем переменную maxExpense для хранения самой большой суммы расходов.
                   Сначала её значение неизвестно, поэтому равно нулю */
                double maxExpense = 0;
                for (Double exp : expenses) {
                    if (maxExpense < exp) {
                        maxExpense = exp;
                    }
                }
                // Печатаем максимум расходов:
                System.out.println("Самая большая сумма расходов на этой неделе составила " + maxExpense + " руб.");

            } else if (command == 0) {
                System.out.println("Выход");
                break;
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }
        }
    }
}
