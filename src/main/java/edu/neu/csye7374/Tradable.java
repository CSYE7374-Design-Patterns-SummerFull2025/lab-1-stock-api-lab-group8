package edu.neu.csye7374;

public interface Tradable {
    /**
     * Place a bid to buy a stock
     *
     * @param bid
     */
    void setBid(String bid);

    /**
     * Return a metric indicating a measure of positive performance of this stock.
     * A large positive index means consider buying the stock, and a large negative
     * index means consider selling it.
     *
     * @return
     */
    String getMetric();
}

