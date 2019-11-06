package investmentCalculator;

import org.junit.Test;

import investmentCalculator.controllers.InvestmentCalculator;
import investmentCalculator.controllers.calculation.AbstractCalculator;
import investmentCalculator.model.InvestmentType;
import investmentCalculator.model.SourceData;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test.
     */

    final SourceData data = new SourceData();
    final InvestmentCalculator investmentCalculator = new InvestmentCalculator();

    @Test
    public void testApp1() {
        data.setAgreementDate(LocalDate.of(2020, 01, 01));
        data.setСalculationDate();
        data.setAmountInvested(new BigDecimal(24756.55).setScale(2, RoundingMode.HALF_UP));
        data.setInterestRateYear(new BigDecimal(13.4).setScale(2, RoundingMode.HALF_UP));
        data.setNumberOfYears(7);

        final AbstractCalculator calc = investmentCalculator.getCalculator(InvestmentType.FIXEDPAYMENT);
        calc.calculate(data);
        final double sumAllPayments = calc.getSumAllPayments().doubleValue();
        assertTrue(sumAllPayments == 38284.79);
    }

    @Test
    public void testApp2() {
        data.setAgreementDate(LocalDate.of(2020, 01, 01));
        data.setСalculationDate();
        data.setAmountInvested(new BigDecimal(50000).setScale(2, RoundingMode.HALF_UP));
        data.setInterestRateYear(new BigDecimal(13).setScale(2, RoundingMode.HALF_UP));
        data.setNumberOfYears(10);

        final AbstractCalculator calc = investmentCalculator.getCalculator(InvestmentType.FIXEDPAYMENT);
        calc.calculate(data);
        final double sumAllPayments = calc.getSumAllPayments().doubleValue();
        assertTrue(sumAllPayments == 89586.44);
    }
    @Test(expected = IllegalArgumentException.class)
    public void argumentExceptionAgreementDate() {
        data.setAgreementDate(LocalDate.of(1020, 01, 01));
    }

    @Test(expected = IllegalArgumentException.class)
    public void argumentExceptionAmountInvested() {
        data.setAmountInvested(new BigDecimal(-24756.55));
    }

    @Test(expected = IllegalArgumentException.class)
    public void argumentExceptionAmountInvestedZiro() {
        data.setAmountInvested(new BigDecimal(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void argumentExceptionInterestRateYear() {
        data.setInterestRateYear(new BigDecimal(-13.4));
    }

    @Test(expected = IllegalArgumentException.class)
    public void argumentExceptionInterestRateYearZiro() {
        data.setInterestRateYear(new BigDecimal(0));
    }

}
