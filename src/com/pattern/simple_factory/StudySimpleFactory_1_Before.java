package com.pattern.simple_factory;
/**
 * 팩토리 패턴
 */
public class StudySimpleFactory_1_Before {

    public static void main(String[] args) {
        System.out.println(">>==================== " + StudySimpleFactory_1_Before.class.getSimpleName());

        PizzaStore pizzaStore = new PizzaStore();

        Pizza  pizza = pizzaStore.orderPizza("cheese");
        //....
    }


    private static class PizzaStore {
        Pizza orderPizza(String type) {
            Pizza pizza = null;

            // create
            if("cheese".equals(type)) {
                pizza = new CheesePizza();
            } else if("pep".equals(type)) {
                pizza = new PepperoniPizza();
            }
            // ....

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
