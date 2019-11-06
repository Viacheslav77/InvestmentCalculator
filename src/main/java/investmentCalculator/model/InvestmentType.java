package investmentCalculator.model;

import java.util.stream.Stream;

/**
 * Class for storing the source type for calculating investments
 * @author Kanshin
 */

public enum InvestmentType {

    FIXEDPAYMENT(1, "FixedPayment");

    private int id;
    private String name;

    InvestmentType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static InvestmentType ofID(int id) {
        return Stream.of(InvestmentType.values()).filter(val -> val.getId() == id).findFirst().orElse(null);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
