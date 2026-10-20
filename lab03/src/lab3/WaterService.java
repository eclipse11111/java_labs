package lab3;
public class WaterService extends UtilityService {
    private double consumption, supplyRate, drainageRate;
    public WaterService(String accountNumber, String address, double consumption, double supplyRate, double drainageRate) {
        super(accountNumber, address);
        setConsumption(consumption);
        setSupplyRate(supplyRate);
        setDrainageRate(drainageRate);
    }
    public double getConsumption() { return consumption; }
    public void setConsumption(double consumption) {
        if (consumption < 0) throw new IllegalArgumentException("Обсяг не може бути від'ємним");
        this.consumption = consumption;
    }
    public double getSupplyRate() { return supplyRate; }
    public void setSupplyRate(double supplyRate) {
        if (supplyRate < 0) throw new IllegalArgumentException("Тариф не може бути від'ємним");
        this.supplyRate = supplyRate;
    }
    public double getDrainageRate() { return drainageRate; }
    public void setDrainageRate(double drainageRate) {
        if (drainageRate < 0) throw new IllegalArgumentException("Тариф не може бути від'ємним");
        this.drainageRate = drainageRate;
    }
    @Override
    public double calculateBill() {
        return consumption * (supplyRate + drainageRate);
    }
    @Override
    public String toString() {
        return String.format("[Водопостачання] %s | Обсяг: %.1f м куб. | До сплати: %.2f грн",
                super.toString(), consumption, calculateBill());
    }
}