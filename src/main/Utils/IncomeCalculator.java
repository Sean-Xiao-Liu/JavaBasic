import java.io.*;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IncomeCalculator {

    private static final String COMMA_DELIMITER = ",";
    private BigDecimal spend = BigDecimal.valueOf(0);
    private BigDecimal balance = BigDecimal.valueOf(0);
    private BigDecimal shares = BigDecimal.valueOf(0);
    private BigDecimal averageCost = BigDecimal.valueOf(0);
    private BigDecimal unit = BigDecimal.valueOf(20);

    public List<List<String>> dataReader(String path) throws FileNotFoundException {
        List<List<String>> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(path));) {
            while (scanner.hasNextLine()) {
                records.add(getRecordFromLine(scanner.nextLine()));
            }
        }
        records.remove(0); // remove the list of headers
        return records;
    }

    private List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(COMMA_DELIMITER);
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }

    /**
     * Take record and output list of close prices
     * @param records
     * @return List<Double> closePrices
     */
    public List<BigDecimal> getClosePrices(List<List<String>> records){
        List<BigDecimal> closePrices = new ArrayList<>();
        for(List<String> l:records){
            closePrices.add(BigDecimal.valueOf(Double.parseDouble(l.get(4)) )); // close prices is in the 5th line
        }
        return closePrices;
    }

    public BigDecimal sharesToPurchase(BigDecimal money,BigDecimal price){
        return money.divide(price,5, RoundingMode.HALF_DOWN);
    }


    public void buyingLogic(BigDecimal price){
        if(averageCost.equals(BigDecimal.valueOf(0))){
            shares = shares.add(sharesToPurchase(unit,price));
            System.out.println("Buy "+sharesToPurchase(unit,price)+" shares with price "+price);
            spend = spend.add(unit);
        } else {
            BigDecimal factor = averageCost.divide(price,10, RoundingMode.HALF_DOWN);
            factor = factor.subtract(BigDecimal.valueOf(1));
            factor = factor.multiply(BigDecimal.valueOf(100));
            if (factor.compareTo(BigDecimal.valueOf(0))>0){
                factor = factor.divide(BigDecimal.valueOf(5),10, RoundingMode.HALF_DOWN);
                factor = factor.round(new MathContext(0, RoundingMode.CEILING));
            } else {
                factor = BigDecimal.valueOf(1);
            }

            shares = shares.add(sharesToPurchase(unit.multiply(factor),price));
            System.out.println("Buy "+sharesToPurchase(unit.multiply(factor),price)+" shares with price "+price);
            spend = spend.add(unit.multiply(factor));
        }
        averageCost = spend.divide(shares,10, RoundingMode.HALF_DOWN);
        balance = shares.multiply(price);
        System.out.println("Current Spend is: "+spend);
        System.out.println("Current Shares is: "+shares);
        System.out.println("Current Average Cost is: "+averageCost);
        System.out.println("Current Balance is: "+balance);
        System.out.println();

    }

    public void buyingProcess(List<BigDecimal> closePrices){

        for(BigDecimal b:closePrices){
            buyingLogic(b);
        }

        System.out.println("Total Spend is: "+spend);
        System.out.println("Total Shares is: "+shares);
        System.out.println("Total Balance is: "+balance);

    }



    public static void main(String[] args) throws FileNotFoundException {

        IncomeCalculator incomeCalculator = new IncomeCalculator();
        String path = "/Users/xiaoliu/Downloads/SPY (1).csv";
        List<List<String>> records = incomeCalculator.dataReader(path);
        List<BigDecimal> closePrices = incomeCalculator.getClosePrices(records);
        incomeCalculator.buyingProcess(closePrices);


    }
}
