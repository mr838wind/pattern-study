package com.pattern.builder;

/**
 * 빌더 패턴(Builder pattern)이란 복합 객체의 생성 과정과 표현 방법을 분리하여 동일한 생성 절차에서 서로 다른 표현 결과를 만들 수 있게 하는 패턴이다.
 */
public class StudyBuilderPattern {

    /** A given type of pizza being constructed. */

    public static void main(String[] args) {
        Cook cook = new Cook();
        PizzaBuilder hawaiianPizzaBuilder = new HawaiianPizzaBuilder();
        PizzaBuilder spicyPizzaBuilder = new SpicyPizzaBuilder();

        cook.setPizzaBuilder(hawaiianPizzaBuilder);
        cook.constructPizza();

        Pizza pizza = cook.getPizza();
        System.out.println(pizza);
    }



    /** "Product" */
    private static class Pizza {
        private String dough = "";
        private String sauce = "";
        private String topping = "";

        public void setDough(String dough) {
            this.dough = dough;
        }

        public void setSauce(String sauce) {
            this.sauce = sauce;
        }

        public void setTopping(String topping) {
            this.topping = topping;
        }

        @Override
        public String toString() {
            return "Pizza{" +
                    "dough='" + dough + '\'' +
                    ", sauce='" + sauce + '\'' +
                    ", topping='" + topping + '\'' +
                    '}';
        }
    }

    /** "Abstract Builder" */
    private static abstract class PizzaBuilder {
        protected Pizza pizza;

        public Pizza getPizza() {
            return pizza;
        }

        public void createNewPizzaProduct() {
            pizza = new Pizza();
        }

        public abstract void buildDough();

        public abstract void buildSauce();

        public abstract void buildTopping();
    }

    /** "ConcreteBuilder" */
    private static class HawaiianPizzaBuilder extends PizzaBuilder {
        public void buildDough() {
            pizza.setDough("cross");
        }

        public void buildSauce() {
            pizza.setSauce("mild");
        }

        public void buildTopping() {
            pizza.setTopping("ham+pineapple");
        }
    }

    /** "ConcreteBuilder" */
    private static class SpicyPizzaBuilder extends PizzaBuilder {
        public void buildDough() {
            pizza.setDough("pan baked");
        }

        public void buildSauce() {
            pizza.setSauce("hot");
        }

        public void buildTopping() {
            pizza.setTopping("pepperoni+salami");
        }
    }

    /** "Director" */
    private static class Cook {
        private PizzaBuilder pizzaBuilder;

        public void setPizzaBuilder(PizzaBuilder pizzaBuilder) {
            this.pizzaBuilder = pizzaBuilder;
        }

        public Pizza getPizza() {
            return pizzaBuilder.getPizza();
        }

        public void constructPizza() {
            pizzaBuilder.createNewPizzaProduct();
            pizzaBuilder.buildDough();
            pizzaBuilder.buildSauce();
            pizzaBuilder.buildTopping();
        }
    }


}
