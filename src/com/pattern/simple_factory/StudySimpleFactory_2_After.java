package com.pattern.simple_factory;
/**
 * 팩토리 패턴
 */
public class StudySimpleFactory_2_After {

    public static void main(String[] args) {
        System.out.println(">>==================== " + StudySimpleFactory_2_After.class.getSimpleName());

        SimplePizzaFactory factory = new SimplePizzaFactory();
        PizzaStore pizzaStore = new PizzaStore(factory);

        Pizza  pizza = pizzaStore.orderPizza("cheese");
        //....
    }


    private static class SimplePizzaFactory {
        Pizza createPizza(String type) {
            Pizza pizza = null;
            if("cheese".equals(type)) {
                pizza = new CheesePizza();
            } else if("pep".equals(type)) {
                pizza = new PepperoniPizza();
            }
            // ....
            return pizza;
        }
    }

    private static class PizzaStore {

        SimplePizzaFactory factory;

        PizzaStore(SimplePizzaFactory factory) {
            this.factory = factory;
        }

        Pizza orderPizza(String type) {
            Pizza pizza = null;

            // create
//            if("cheese".equals(type)) {
//                pizza = new CheesePizza();
//            } else if("pep".equals(type)) {
//                pizza = new PepperoniPizza();
//            }
//            // ....

            // create
            pizza = this.factory.createPizza(type);


            pizza.prepare();

            pizza.bake();

            pizza.cut();

            pizza.box();


            return pizza;
        }
    }


    private static abstract class Pizza {

        Pizza() {
            System.out.println(">>================ init: " + this.getClass().getSimpleName());
        }

        void prepare(){ System.out.println(">>== prepare: "); }
        void bake(){ System.out.println(">>== bake: ");}
        void cut(){ System.out.println(">>== cut: ");}
        void box(){ System.out.println(">>== box: ");}
    }

    private static class CheesePizza extends Pizza {

    }

    private static class PepperoniPizza extends Pizza {

    }



}
