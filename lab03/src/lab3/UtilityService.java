package lab3;
public abstract class UtilityService {
    private String accountNumber;
    private String address;
    public UtilityService(String accountNumber, String address) {
        setAccountNumber(accountNumber);
        setAddress(address);
    }
    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) {
        if (accountNumber == null || accountNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Номер особового рахунку порожній");
        }
        this.accountNumber = accountNumber.trim();
    }
    public String getAddress() { return address; }
    public void setAddress(String address) {
        if (address == null || address.trim().isEmpty()) {
            throw new IllegalArgumentException("Адреса порожня");
        }
        this.address = address.trim();
    }
    public abstract double calculateBill();
    @Override
    public String toString() {
        return "Ос. рахунок: " + accountNumber + " | Адреса: " + address;
    }
}