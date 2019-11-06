package main;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import investmentCalculator.controllers.InvestmentCalculator;
import investmentCalculator.controllers.calculation.AbstractCalculator;
import investmentCalculator.model.InvestmentType;
import investmentCalculator.model.SourceData;

public final class App {
    private App() {
    }

    public static void main(String[] args) {

        SourceData data = new SourceData();
        InvestmentCalculator investmentCalculator = new InvestmentCalculator();      
        try {
            data.setAgreementDate(LocalDate.of(2020, 01, 01));
            data.setСalculationDate();
            data.setAmountInvested(new BigDecimal(24756.55).setScale(2, RoundingMode.HALF_UP));
            data.setInterestRateYear(new BigDecimal(13.4).setScale(2, RoundingMode.HALF_UP));
            data.setNumberOfYears(7);

            AbstractCalculator calc = investmentCalculator.getCalculator(InvestmentType.FIXEDPAYMENT);
            calc.calculate(data);

            // Display results
            System.out.println(calc.getSourceData().toString());
            System.out.println("Calculated data\n----------------");
            System.out.println("The monthly payment is " + calc.getMonthlyPayment().setScale(2, RoundingMode.HALF_UP));
            System.out.println("The total payment is $" + calc.getSumAllPayments() + "\n----------------\n");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
