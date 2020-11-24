package ge.edu.btu.currency.service.impl;

import ge.edu.btu.currency.service.CurrencyService;
import org.apache.log4j.Logger;

public class CurrencyServiceImpl implements CurrencyService {
    final static Logger logger = Logger.getLogger(CurrencyServiceImpl.class);

    private int exchangeRate;

    @Override
    public void setExchangeRate(int exchangeRate) {
        this.exchangeRate = exchangeRate;
        logger.info("System exchange rate set to " + exchangeRate);
    }

    @Override
    public double convert(double amount) {
        return amount / exchangeRate;
    }

    @Override
    public int convert(int amount) {
        return amount / exchangeRate;
    }

}
