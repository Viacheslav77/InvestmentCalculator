package investmentCalculator.interfaces;

import investmentCalculator.controllers.calculation.AbstractCalculator;
import investmentCalculator.model.InvestmentType;

public interface InvestmentCalculatorInterface {

    /** Returns the Calculator of all future interest payments */
    AbstractCalculator getCalculator(InvestmentType type);

}