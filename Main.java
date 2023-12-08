import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StepTracker steptracker = new StepTracker(scanner);

        while (true) {
            printMenu();

            int i = scanner.nextInt();
            if (i == 1) {
                steptracker.addNewNumberStepsPerDay();

            } else if (i == 2) {
                steptracker.changeStepGoal();

            } else if (i == 3) {
                steptracker.printStatistic();

            } else if (i == 4) {
                System.out.println("Пока! ");
                scanner.close();
                return;

            } else {
                System.out.println("Такой команды нет! ");
            }
        }
    }
    private static void printMenu() {
        System.out.println("Введите команду ");
        System.out.println("1 - Ввести количество шагов за определенный день. ");
        System.out.println("2 - Изменить цель по количеству шагов в день. ");
        System.out.println("3 - Напечатать статистику за определенный месяц. ");
        System.out.println("4 - Выход.");
    }

}