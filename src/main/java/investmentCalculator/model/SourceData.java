package investmentCalculator.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Class for storing the source data for calculating investments
 * @author Kanshin
 */

public class SourceData {

    private LocalDate agreementDate; // Agreement date
    private LocalDate сalculationDate; // Calculation date
    private BigDecimal amountInvested; // X - how much is one person going to invest
    private BigDecimal interestRateYear; // R - interest rate per year
    private int numberOfYears; // N - years 

    public LocalDate getAgreementDate() {
        return agreementDate;
    }

    public void setAgreementDate(LocalDate agreementDate) throws IllegalArgumentException {
        LocalDate dateNow = LocalDate.now();
        if (agreementDate.isBefore(dateNow) || !(agreementDate instanceof LocalDate)) {
            throw new IllegalArgumentException("invalid agreementDate");
        }
        this.agreementDate = agreementDate;
    }

    public LocalDate getСalculationDate() {
        return сalculationDate;
    }

    public void setСalculationDate() throws IllegalArgumentException {
        this.сalculationDate = LocalDate.now();
    }

    public BigDecimal getAmountInvested() {
        return amountInvested;
    }

    public void setAmountInvested(BigDecimal amountInvested) {

        if (amountInvested.doubleValue() <= 0 || !(amountInvested instanceof BigDecimal)) {
            throw new IllegalArgumentException("invalid amountInvested");
        }
        this.amountInvested = amountInvested;
    }

    public BigDecimal getInterestRateYear() {
        return interestRateYear;
    }

    public void setInterestRateYear(BigDecimal interestRateYear) {

        if (interestRateYear.doubleValue() <= 0 || !(interestRateYear instanceof BigDecimal)) {
            throw new IllegalArgumentException("invalid interestRateYear");
        }
        this.interestRateYear = interestRateYear;
    }

    public int getNumberOfYears() {
        return numberOfYears;
    }

    public void setNumberOfYears(int numberOfYears) {
        if (numberOfYears <= 0) {
            throw new IllegalArgumentException("invalid numberOfYears");
        }
        this.numberOfYears = numberOfYears;
    }

    @Override
    public String toString() {
        return "\nSource data: \n----------------\nAgreement Date: "
                + agreementDate.format(DateTimeFormatter.ofPattern("dd-MM-YYYY")) 
                + "\nDate of calculation: "
                + сalculationDate.format(DateTimeFormatter.ofPattern("dd-MM-YYYY")) 
                + "\nInvested amount: $"
                + amountInvested + "\nNumber of years - " + numberOfYears 
                + "\nInterest rate: " + interestRateYear
                + " %/year\n----------------\n";
    }

}