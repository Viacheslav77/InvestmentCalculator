package investmentCalculator.controllers.calculation;

import java.math.BigDecimal;

import investmentCalculator.interfaces.CalculatorTypeInterface;
import investmentCalculator.model.SourceData;

public abstract class AbstractCalculator implements CalculatorTypeInterface {
    protected SourceData sourceData;
    protected BigDecimal sumAllPayments;
    protected BigDecimal monthlyPayment;

    @Override
    public abstract void calculate (SourceData data);

    public BigDecimal getSumAllPayments() {
        return sumAllPayments;
    }

    public BigDecimal getMonthlyPayment() {
        return monthlyPayment;
    }

    public SourceData getSourceData() {
        return sourceData;
    }

}
