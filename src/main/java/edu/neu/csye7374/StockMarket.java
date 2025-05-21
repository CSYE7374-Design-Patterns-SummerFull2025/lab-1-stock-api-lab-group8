package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class StockMarket {
    private static volatile StockMarket instance;
    private List<Stock> stockList;


    private StockMarket() {
        stockList = new ArrayList<>();
    }

    public static StockMarket getInstance() {
        if (instance == null) {
            synchronized (StockMarket.class) {
                if (instance == null) {
                    instance = new StockMarket();
                }
            }
        }
        return instance;
    }

    public void addStock(Stock stock) {
        stockList.add(stock);
        System.out.println("Stock: " + stock.getName() +" has been added");
    }

    public void tradeStock(String stockName, String bid) {
        for (Stock stock : stockList) {
            if (stock.getName().equalsIgnoreCase(stockName)) {
                if (stock instanceof Tradable) {
                    ((Tradable) stock).setBid(bid);
                    System.out.println("Stock: " + stockName + " traded with bid: " + bid);
                } else {
                    System.out.println("Stock " + stockName + " is not tradable.");
                }
                return;
            }
        }
        System.out.println("Stock " + stockName + " not found.");
    }

    public void removeStock(String stockName) {
        boolean removed = stockList.removeIf(stock -> stock.getName().equalsIgnoreCase(stockName));
        if (removed) {
            System.out.println("Removed stock: " + stockName);
        } else {
            System.out.println("Stock " + stockName + " not found.");
        }
    }

    public void showAllStocks() {
        System.out.println("----- All Traded Stocks -----");
        for (Stock stock : stockList) {
            System.out.println(stock);
        }
        System.out.println("-----------------------------");
    }

    public List<Stock> getStockList() {
        return stockList;
    }

    public void demo() {

        Stock ibm = new IbmStock("IBM", 131.15, "IBM Common Stock", 10.0);
        Stock amazon = new AmazonStock("Amazon", 150, "Amazon Common Stock", 3.0);
        Stock netflix = new NetflixStock("Netflix", 123, "Netflix Common Stock", 5.0);
        Stock google = new GoogleStock("Google", 87, "Google Common Stock", 20.0);
        Stock meta = new MetaStock("Meta", 200, "Meta Common Stock", 11.0);
        Stock microsoft = new MicrosoftStock("Microsoft", 181, "Microsoft Common Stock", 15.0);

        addStock(ibm);
        addStock(amazon);
        addStock(netflix);
        addStock(google);
        addStock(meta);
        addStock(microsoft);

        showAllStocks();

        String[] bids = {"BUY 10", "SELL 5", "BUY 20", "SELL 10", "BUY 15", "SELL 20"};

        for (Stock stock : getStockList()) {
            System.out.println("\nTrading stock: " + stock.getName());
            for (String bid : bids) {
                tradeStock(stock.getName(), bid);
                System.out.println(stock);
            }
        }

        showAllStocks();
    }
}
