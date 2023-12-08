import java.util.Scanner;
public class StepTracker {
    Converter converter = new Converter();
    // MonthData monthData = new MonthData();

    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    public int goalByStepsPerDay = 10_000;

    StepTracker(Scanner scan) {
        scanner = scan;
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца.(От 1 до 12) ");
        int month = scanner.nextInt();

        if (month < 1 || month > 12) {
            System.out.println("Ошибка, некорректный номер месяца! ");
            return;
        } else {
            System.out.println("Введите день. (От 1 до 30 включительно) ");
        }
        int day = scanner.nextInt();

        if (day <= 0 || day > 30) {
            System.out.println("Ошибка, некорректный номер дня! ");
            return;
        } else {
            System.out.println("Введите количество шагов. ");
        }
        int steps = scanner.nextInt();

        if (steps <= 0) {
            System.out.println("Ошибка, некорректное количество шагов! ");
            return;
        } else {
            System.out.println("Значения сохранены! ");
        }
        MonthData monthData = monthToData[month - 1];
        monthData.days[day - 1] = steps;
    }

    void changeStepGoal() {
        System.out.println("Какова Ваша цель шагов на день? ");
        int goal = scanner.nextInt();
        if (goal > 0) {
            System.out.println("Ваше цель сохранена! ");
            goalByStepsPerDay = goal;
        } else {
            System.out.println("Ошибка! Введите цель больше 0 ;) ");
        }
        System.out.println(goal);
    }

    void printStatistic() {

        System.out.println("Введите число месяца");
        int month = scanner.nextInt();
        if (month < 1 || month > 12) {
            System.out.println("Ошибка! Некорректный ввод месяца! ");
            return;
        } else {
            System.out.println("Вы выбрали показать статистику за " + month + " месяц. ");

        }

        MonthData monthData  = monthToData[month - 1];
        int sumSteps = monthData.sumStepsFromMonth();
        monthData.printDaysAndStepsFromMonth();
        System.out.println("За этот месяц Вы прошли " + sumSteps + " шагов. ");
        int maxSteps = monthData.maxSteps();
        System.out.println("За месяц Ваше максимальное количество шагов = " + maxSteps);
        int distSteps = converter.convertToKm(sumSteps);
        System.out.println("За месяц Вы прошли дистанцию в " + distSteps + " км ");
        int kilokal = converter.convertStepsToKilocalories(sumSteps);
        System.out.println("За месяц Вы сожгли " + kilokal + " килокалорий ");
        int finalSeries = monthData.bestSeries(goalByStepsPerDay);
        System.out.println("Ваша лучшая серия шагов за месяц ");
        System.out.println(finalSeries);
        System.out.println();

    }


}
