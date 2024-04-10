import model.StockPrice;
import model.StockProfit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StockAnalyzer {

    private static final String ERR_MSG_USER_INPUT = "Usage: java StockAnalyzer <stockName> <year>";
    private static final String ERR_MSG_CORRUPTED_DATA = "Data in the file is corrupted";

    private static List<StockPrice> readStockPrices(String filename) throws IOException {
        List<StockPrice> prices = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;
        br.readLine();
        try {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String date = data[0];
                double open = Double.parseDouble(data[1]);
                double high = Double.parseDouble(data[2]);
                double low = Double.parseDouble(data[3]);
                double close = Double.parseDouble(data[4]);
                prices.add(new StockPrice(date, open, high, low, close));
            }
        } catch (NumberFormatException e) {
            throw new IOException(ERR_MSG_CORRUPTED_DATA);
        }
        br.close();
        return prices;
    }

    private static StockProfit maxProfit(String stockName, int year) throws IOException {
        List<StockPrice> prices = readStockPrices("input/" + stockName + ".csv");
        StockProfit sp = null;
        double maxProfit = 0;
        try {
            for (int i = 0; i < prices.size() - 1; i++) {
                StockPrice buyPrice = prices.get(i);
                if (Integer.parseInt(buyPrice.getDate().split("-")[0]) != year) {
                    continue;
                }
                for (int j = i + 1; j < prices.size(); j++) {
                    StockPrice sellPrice = prices.get(j);
                    if (Integer.parseInt(sellPrice.getDate().split("-")[0]) != year) {
                        break;
                    }
                    double profit = sellPrice.getClose() - buyPrice.getOpen();
                    if (profit > maxProfit) {
                        maxProfit = profit;
                        sp = new StockProfit(buyPrice.getDate(), buyPrice.getOpen(), sellPrice.getDate(), sellPrice.getClose(), maxProfit);
                    }
                }
            }
        } catch (NumberFormatException e) {
            throw new IOException(ERR_MSG_CORRUPTED_DATA);
        }
        return sp;
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println(ERR_MSG_USER_INPUT);
            return;
        }

        String stockName = args[0];

        int year;
        try {
            year = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.out.println(ERR_MSG_USER_INPUT);
            return;
        }

        try {
            StockProfit sp = maxProfit(stockName, year);
            if (sp != null) {
                System.out.println(sp);
            } else {
                System.out.println("No profitable trades.");
            }
        } catch (IOException e) {
            System.out.println("Error reading stock prices: " + e.getMessage());
        }
    }

}
