
public class Grocery {

    Grocery(){

    }
    public Grocery(String item, int quantity, String category) {
        this.item = item;
        this.quantity = quantity;
        this.category = category;
    }

    protected String item;
    protected int quantity;
    protected String category;

    public Grocery(String text){
        this.item = text;
    }

//    public String toString() {
//        return "item="+item + ", q="+quantity;
//    }
}
