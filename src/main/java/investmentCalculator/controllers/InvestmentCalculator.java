package investmentCalculator.controllers;

import investmentCalculator.controllers.calculation.AbstractCalculator;
import investmentCalculator.controllers.calculation.FixedPaymentCalculator;
import investmentCalculator.interfaces.InvestmentCalculatorInterface;
import investmentCalculator.model.InvestmentType;

public class InvestmentCalculator implements InvestmentCalculatorInterface {

    @Override
    public AbstractCalculator getCalculator(InvestmentType type) {
        
        if (type.equals(InvestmentType.FIXEDPAYMENT)) {
            return new FixedPaymentCalculator();
        }       
        // here you can add logic if other calculators appear in the future
        
        else {
            throw new IllegalArgumentException("invalid InvestmentType");
        }
        
    }
}