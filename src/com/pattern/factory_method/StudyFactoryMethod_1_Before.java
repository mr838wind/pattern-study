package com.pattern.factory_method;

/**
 * 팩토리 메서드 패턴 - 팩토리 매서드 패턴에서는 객체를 생성하기 위한 인터페이스를 정의하는데, 어떤 클래스의 인스턴스를 만들지는 서브클래스에서 결정하게 만듭니다.
 * 팩토리 메서드 패턴을 사용하면, 클래스의 인스턴스를 만드는 일은 서브 클래스에게 맡기는 것이죠.
 */
public class StudyFactoryMethod_1_Before {

    public static void main(String[] args) {
        System.out.println(">>==================== " + StudyFactoryMethod_1_Before.class.getSimpleName());

        PizzaStore pizzaStore = new PizzaStore();

        Pizza  pizza = pizzaStore.orderPizza("NewYork", "cheese");
        Pizza  pizza2 = pizzaStore.orderPizza("Chicago", "cheese");
        //....
    }


    private static class PizzaStore {
        Pizza orderPizza(String style, String type) {
            Pizza pizza = null;

            // create:
            if("NewYork".equals(style) ) {
                if("cheese".equals(type)) {
                    pizza = new NewYorkCheesePizza();
                } else if("pep".equals(type)) {
                    pizza = new NewYorkPepperoniPizza();
                }
            } else if ("Chicago".equals(style)) {
                if("cheese".equals(type)) {
                    pizza = new ChicagoCheesePizza();
                } else if("pep".equals(type)) {
                    pizza = new ChicagoCheesePizza();
                }
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

    private static class NewYorkCheesePizza extends Pizza {

    }
    private static class ChicagoCheesePizza extends Pizza {

    }

    private static class NewYorkPepperoniPizza extends Pizza {

    }

    private static class ChicagoPepperoniPizza extends Pizza {

    }



}
