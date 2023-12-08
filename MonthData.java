public class MonthData {
    int[] days = new int[30];

    void printDaysAndStepsFromMonth() {
        for (int i = 0; i < days.length; i++) {
            System.out.println("За " + (i + 1) + " день, Вы прошли " + days[i] + " шагов. ");
        }
    }

    int sumStepsFromMonth() {
        int sumSteps = 0;
        for (int i = 0; i < days.length; i++) {
            sumSteps += days[i];
        }
        return sumSteps;
    }

    int maxSteps() {
        int maxSteps = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i] > maxSteps) {
                maxSteps = days[i];
            }
        }
        return maxSteps;
    }

    int bestSeries(int goalByStepsPerDay) {


        int currentSeries = 0;
        int finalSeries = 0;


        for (int i = 0; i < days.length; i++) {
            // поиск максимальной серии:
            if (days[i] >= goalByStepsPerDay) {
                currentSeries = currentSeries + 1;
            } else {
                if (currentSeries > finalSeries) {
                    finalSeries = currentSeries;
                    currentSeries = 0;
                }
            }
        }


        // условие, для случаев, когда лучшая серия заканчиваеться на последнем дне месяца:
        if (currentSeries > finalSeries) {
            finalSeries = currentSeries;
        }


        return finalSeries;
    }
}
