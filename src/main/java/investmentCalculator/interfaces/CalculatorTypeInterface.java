package investmentCalculator.interfaces;

import java.math.BigDecimal;

import investmentCalculator.model.SourceData;

public interface CalculatorTypeInterface {

    /**
     * Method for calculating the monthly payment and the amount of all investment
     * payments
     */
    void calculate(SourceData data);

    /** Returns the Sum of all future interest payments */
    BigDecimal getSumAllPayments();

    /** Returns the monthly payment */
    BigDecimal getMonthlyPayment();

    /** Returns the Source Data */
    SourceData getSourceData();
}