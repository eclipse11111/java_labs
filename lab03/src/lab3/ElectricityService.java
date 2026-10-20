package lab3;
public class ElectricityService extends UtilityService {
    private double dayCons, nightCons, dayRate, nightRate;
    public ElectricityService(String accountNumber, String address, double dayCons, double nightCons, double dayRate, double nightRate) {
        super(accountNumber, address);
        setDayCons(dayCons);
        setNightCons(nightCons);
        setDayRate(dayRate);
        setNightRate(nightRate);
    }
    public double getDayCons() { return dayCons; }
    public void setDayCons(double dayCons) {
        if (dayCons < 0) throw new IllegalArgumentException("Показник не може бути від'ємним");
        this.dayCons = dayCons;
    }
    public double getNightCons() { return nightCons; }
    public void setNightCons(double nightCons) {
        if (nightCons < 0) throw new IllegalArgumentException("Показник не може бути від'ємним");
        this.nightCons = nightCons;
    }
    public double getDayRate() { return dayRate; }
    public void setDayRate(double dayRate) {
        if (dayRate < 0) throw new IllegalArgumentException("Тариф не може бути від'ємним");
        this.dayRate = dayRate;
    }
    public double getNightRate() { return nightRate; }
    public void setNightRate(double nightRate) {
        if (nightRate < 0) throw new IllegalArgumentException("Тариф не може бути від'ємним");
        this.nightRate = nightRate;
    }
    @Override
    public double calculateBill() {
        return dayCons * dayRate + nightCons * nightRate;
    }
    @Override
    public String toString() {
        return String.format("[Електропостачання] %s | День: %.1f кВт, Ніч: %.1f кВт | До сплати: %.2f грн",
                super.toString(), dayCons, nightCons, calculateBill());
    }
}