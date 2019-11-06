package investmentCalculator.controllers.calculation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import investmentCalculator.model.SourceData;

/**
 * Class for calculating the return on investment with a fixed payment every
 * month
 * @author Kanshin
 */

public class FixedPaymentCalculator extends AbstractCalculator {

        @Override
        public void calculate(SourceData data) {

                this.sourceData = data;
                // Obtain monthly interest rate
                BigDecimal monthlyInterestRate = sourceData.getInterestRateYear().divide(new BigDecimal(1200), 10,
                                RoundingMode.HALF_UP);

                // Calculate Sum All Payments
                monthlyPayment = sourceData
                                .getAmountInvested().multiply(monthlyInterestRate).divide(
                                                new BigDecimal(1 - 1 / Math.pow(1 + monthlyInterestRate.doubleValue(),
                                                                sourceData.getNumberOfYears() * 12)),
                                                5, RoundingMode.HALF_UP);

                this.sumAllPayments = monthlyPayment.multiply(new BigDecimal(sourceData.getNumberOfYears() * 12))
                                .setScale(2, RoundingMode.HALF_UP);
        }
}