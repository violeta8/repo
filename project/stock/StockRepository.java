package project.stock;

import java.util.List;
import java.util.ArrayList;
import project.product.Product;

public class StockRepository{
    private static List<Stock> repository=new ArrayList<Stock>();
    private static int nextIdStock;

    public StockRepository() {
        repository = new ArrayList<>();
        nextIdStock = 0;
    }

    public static int nextIdStock() {
        return nextIdStock++;
    }

    public static void saveStock(Stock stock) {
        repository.add(stock);
    }

    public static void updateStock(int id, int quantity) {
        if (!repository.contains(repository.get(id))) {
            throw new IllegalAccessError("Stock not found");
        }
        Stock stock = repository.get(id);
        stock.updateStock(quantity);
    }

    public static void updateStock(Product p, int quantity){
        for(Stock stock : repository){
            if(stock.getProduct().equals(p)){
                stock.updateStock(quantity);
            }
        }
    }

    public static Stock getStockById(int id) {
        return repository.get(id);
    }

    public static String getAllStocks() {
        String result="";
        for (Stock stock : repository) {
            result += stock.display_stock_info()+"\n";
        }
        return result;
    }

    public static int getStockQuantity(Product p){
        for(Stock stock : repository){
            if(stock.getProduct().equals(p)){
                return stock.getQuantity();
            }
        }
        return 0;
    }

    public static void deleteStock(Product p) {
        for(Stock stock : repository){
            if(stock.getProduct().equals(p)){
                repository.remove(stock);
            }
        }
    }
}