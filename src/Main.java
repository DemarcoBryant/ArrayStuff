
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int[] dataPoints = new int[100];

        Random rand = new Random();
        for (int i = 0; i < dataPoints.length; i++) {
            dataPoints[i] = rand.nextInt(100) + 1;
        }

        for (int j = 0; j < dataPoints.length; j++) {
            System.out.print(dataPoints[j]);
            System.out.print(" | ");
        }
        int sumOfArrayValues = 0;
        double averageOfArrayValues = 0;

        sumOfArrayValues = sum(dataPoints);
        averageOfArrayValues = getAverage(dataPoints);
        System.out.println("\n");
        System.out.println("The sum of the values in dataPoints is: " + sumOfArrayValues);
        System.out.println("The average of the values in dataPoints is: " + averageOfArrayValues);
        Scanner in = new Scanner(System.in);
        int userValue = SafeInput.getRangedInt(in, "Please enter a value between 1 and 100: ",100, 1);


        int countOfUserValue = occurrenceScan(dataPoints, userValue);

        System.out.println("The value " + userValue + " is found " + countOfUserValue + " times in the dataPoints array.");

        int secondUserValue = SafeInput.getRangedInt(in, "Please enter another value between 1 and 100: ",100, 1);
        int position = -1;
        if (contains(dataPoints, secondUserValue)) {
            for (int y = 0; y < dataPoints.length; y ++) {
                if (dataPoints[y] == secondUserValue) {
                    position = y;
                    break;
                }
            }
        }

        if (position != -1) {
            System.out.println("The value " + secondUserValue + " was found at array index " + position + ".");
        } else {
            System.out.println("The value " + secondUserValue + " was not found in the dataPoints array.");
        }

        int min = min(dataPoints);
        int max = max(dataPoints);

        System.out.println("The minimum value in the dataPoints array is: " + min);
        System.out.println("The maximum value in the dataPoints array is: " + max);

        double average = getAverage(dataPoints);
        System.out.println("Average of dataPoints is: " + average);

    }

    public static double getAverage(int[] values)
    {
        int sum = 0;
        for (int v = 0; v < values.length; v++) {
            sum += values[v];
        }
        return (double) sum / values.length;
    }


    public static int min(int[] values) {
        int min = values[0];
        for (int value : values) {
            if (value < min) {
                min = value;
            }
        }

        return min;
    }

    public static int max(int[] values) {
        int max = values[0];
        for (int value: values) {
            if (value > max) {
                max = value;
            }
        }

        return max;
    }

    public static int occurrenceScan(int[] values, int target) {
        int countOfUserValue = 0;
        for (int value : values) {
            if (value == target) {
                countOfUserValue++;
            }
        }

        return countOfUserValue;
    }

    public static int sum(int[] values) {
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return sum;
    }
    public static boolean contains(int[] values, int target) {
        for (int value : values) {
            if (value == target) {
                return true;
            }
        }
        return false;
    }

}