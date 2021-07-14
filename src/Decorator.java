abstract class Beverage {
    String des;
    Beverage(String des) {
        this.des = des;
    }
    public String getDes() {
        return des;
    }
    abstract int findCost();
}


class Coffee extends Beverage {
    Coffee(String des) {
        super("Coffee");
    }
    @Override
    int findCost() {
        return 10;
    }
}

class Chai extends Beverage {
    Chai(String des) {
        super("Chai");
    }
    @Override
    int findCost() {
        return 8;
    }
}

abstract class AddOn extends  Beverage {
    Beverage beverage;

    AddOn(String des , Beverage bev) {
        super(des);
        this.beverage  = bev;
    }
}

class sugarAddOn extends AddOn {


    sugarAddOn(Beverage bev) {
        super("sugar with lalala ", bev);
    }

//    @Override
//    public String getDes() {
//        return "sugar with" + beverage.getDes();
//    }

    @Override
    int findCost() {
        return this.beverage.findCost() + 10;
    }
}



public class Decorator {



    public  static  void main(String[] args) {
        sugarAddOn su = new sugarAddOn(new Coffee("cofee"));
        Beverage bv = new sugarAddOn(new Chai("s"));

        su.getDes();
    }
}
