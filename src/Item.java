public abstract class Item {
    private int ID;
    private String name;
    private double price;
    private double tax;
    private int stock ;
    
    
    public Item(int iD, String name, double price, double tax, int stock) {
        ID = iD;
        this.name = name;
        this.price = price;
        this.tax = tax;
        this.stock = stock;
    }
    
    public int getID() {
        return ID;
    }
    public void setID(int iD) {
        ID = iD;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public double getTax() {
        return tax;
    }
    public void setTax(double tax) {
        this.tax = tax;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    abstract double CalculateBill(int quantity);
}
