package lab3;
import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        UtilityService[] services = new UtilityService[2];
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) {
                    continue;
                }
                String[] p = line.split(";");
                for (int i = 0; i < p.length; i++) {
                    p[i] = p[i].trim();
                }
                try {
                    UtilityService service = null;
                    if ("ELECTRICITY".equalsIgnoreCase(p[0])) {
                        service = new ElectricityService(
                                p[1], p[2],
                                Double.parseDouble(p[3]),
                                Double.parseDouble(p[4]),
                                Double.parseDouble(p[5]),
                                Double.parseDouble(p[6])
                        );
                    } else if ("WATER".equalsIgnoreCase(p[0])) {
                        service = new WaterService(
                                p[1], p[2],
                                Double.parseDouble(p[3]),
                                Double.parseDouble(p[4]),
                                Double.parseDouble(p[5])
                        );
                    }
                    if (service != null) {
                        if (count >= services.length) {
                            services = Arrays.copyOf(
                                    services, services.length * 2
                            );
                        }
                        services[count++] = service;
                    }
                } catch (Exception e) {
                    System.err.println(
                            "Помилка обробки рядка: " + e.getMessage()
                    );
                }
            }
        } catch (IOException e) {
            System.err.println(
                    "Помилка читання вхідного файлу: " + e.getMessage()
            );
            return;
        }
        services = Arrays.copyOf(services, count);
        StringBuilder report = new StringBuilder(
                "КВИТАНЦІЯ НА СПЛАТУ КОМУНАЛЬНИХ ПОСЛУГ\n\n"
        );
        double totalSum = 0;
        for (int i = 0; i < services.length; i++) {
            totalSum += services[i].calculateBill();
            report.append(i + 1)
                    .append(". ")
                    .append(services[i])
                    .append("\n");
        }
        report.append("\n------------------------------------------------\n");
        report.append(String.format(
                "ЗАГАЛЬНА СУМА ДО СПЛАТИ: %.2f грн\n", totalSum
        ));
        System.out.println(report);
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("output.txt"))) {
            writer.write(report.toString());
            System.out.println(
                    "Звіт успішно збережено у файл output.txt"
            );
        } catch (IOException e) {
            System.err.println(
                    "Помилка запису у файл: " + e.getMessage()
            );
        }
    }
}