package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class stocks {
    private static stocks instance;

    private List<StockAPI> bids = new ArrayList<>();

    private stocks(){
        instance = null;
    }

    public static stocks getInstance(){
        if(instance == null){
            instance = new stocks();
        }
        return instance;
    }

    public StockAPI getStockItem(String name, double price, String description){
        return new StockAPI(name, price, description);
    }

    public void add(StockAPI stock){
        bids.add(stock);
    }

    public void remove(StockAPI s){
        boolean removed = this.bids.remove(s);

        if(!removed) {
            System.out.println("Stock not found");
        }
    }

    public void displayStocks(){
        for(StockAPI s : this.bids){
            System.out.println(s.toString());
        }
    }

    public void updatePrice(StockAPI s, double price){
        if(this.bids.contains(s)){
            s.setPrice(price);
            return;
        }
        System.out.println("Stock not found");
    }

    public static void demo(){
        System.out.println("");

        Nvidia nvidiaStock = new Nvidia(240.0);
        Mastercard mastercardStock = new Mastercard(125.0);

        stocks.getInstance().add(nvidiaStock);
        stocks.getInstance().add(mastercardStock);

        nvidiaStock.setBid(240.0);

        nvidiaStock.setBid(245.0);

        nvidiaStock.setBid(250.0);

        nvidiaStock.setBid(265.0);

        nvidiaStock.setBid(280.0);

        nvidiaStock.setBid(300.0);

        nvidiaStock.getMetric();

        /*Meta Stocks*/
        mastercardStock.setBid(110.0);

        mastercardStock.setBid(190.0);

        mastercardStock.setBid(180.0);

        mastercardStock.setBid(170.0);

        mastercardStock.setBid(160.0);

        mastercardStock.setBid(150.0);

        mastercardStock.getMetric();

        stocks.getInstance().displayStocks();
        stocks.getInstance().remove(nvidiaStock);
        stocks.getInstance().remove(mastercardStock);
    }
}
