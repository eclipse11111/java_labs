import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line = reader.readLine();
            String[] parts = line.split(" ");
            double[] x = new double[parts.length];
            for (int i = 0; i < parts.length; i++) {
                x[i] = Double.parseDouble(parts[i]);
            }
            double xMin = x[0];
            double xMax = x[0];

            for (int i = 1; i < x.length; i++) {
                if (x[i] < xMin) {
                    xMin = x[i];
                }
                if (x[i] > xMax) {
                    xMax = x[i];
                }
            }

            double[] y = new double[x.length];
            for (int i = 0; i < x.length; i++) {
                y[i] = (x[i] - xMin) / (xMax - xMin);
            }

            StringBuilder result = new StringBuilder();
            result.append("Початковий масив: ")
                    .append(Arrays.toString(x))
                    .append("\n");

            result.append("X_min = ")
                    .append(xMin)
                    .append("\n");

            result.append("X_max = ")
                    .append(xMax)
                    .append("\n");

            result.append("Нормалізований масив: ")
                    .append(Arrays.toString(y));

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
                writer.write(result.toString());
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
}