package model;

import java.text.DecimalFormat;

public class StockProfit {

    private String buyDate;
    private double buyPrice;
    private String sellDate;
    private double sellPrice;
    private double profit;

    public StockProfit(String buyDate, double buyPrice, String sellDate, double sellPrice, double profit) {
        this.buyDate = buyDate;
        this.buyPrice = buyPrice;
        this.sellDate = sellDate;
        this.sellPrice = sellPrice;
        this.profit = profit;
    }

    public String getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(String buyDate) {
        this.buyDate = buyDate;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public String getSellDate() {
        return sellDate;
    }

    public void setSellDate(String sellDate) {
        this.sellDate = sellDate;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.000000");
        StringBuilder sb = new StringBuilder();
        if (getBuyDate() != null) {
            sb.append("Buy date: ").append(getBuyDate()).append("\n");
        }
        sb.append("Buy price: ").append(getBuyPrice()).append("\n");
        if (getSellDate() != null) {
            sb.append("Sell date: ").append(getSellDate()).append("\n");
        }
        sb.append("Sell price: ").append(getSellPrice()).append("\n");
        sb.append("Profit: ").append(df.format(getProfit()));
        return sb.toString();
    }
}
