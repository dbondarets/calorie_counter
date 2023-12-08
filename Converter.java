public class Converter {

    int caloriesPerKilocalories = 1_000;
    int centimeterPerKilometers = 100_000;
    int stepPerCentimeter = 75;
    int caloriesPerStep = 50;
    // Я оставил int, так как в задании к ТЗ, указано оставить int.
    int convertToKm(int sumSteps) {
        return (stepPerCentimeter * sumSteps) / centimeterPerKilometers;
    }

    int convertStepsToKilocalories(int sumSteps) {
        return sumSteps * caloriesPerStep / caloriesPerKilocalories;
    }
}
