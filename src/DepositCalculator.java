import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double amount, double yearRate, int period) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * period);
        return getRandom(pay, 2);
    }

    double calculateSimplePercent(double doubleAmount, double yearRate, int depositPeriod) {
        return getRandom(doubleAmount + doubleAmount * yearRate * depositPeriod, 2);
    }

    double getRandom(double value, int places) {
        double random = Math.pow(10, places);
        return Math.round(value * random) / random;
    }

    void makeMoneyOperations() {
        int period, action;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double finalSavings = 0;
        if (action == 1) {
            finalSavings = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            finalSavings = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + finalSavings);
    }

    public static void main(String[] args) {
        DepositCalculator depositCalculator = new DepositCalculator();
        depositCalculator.makeMoneyOperations();
    }
}
