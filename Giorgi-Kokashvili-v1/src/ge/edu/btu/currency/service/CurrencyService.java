package ge.edu.btu.currency.service;

public interface CurrencyService {

    void setExchangeRate(int exchangeRate);

    double convert(double amount);

    int convert(int amount);

}
