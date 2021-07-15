package com.pattern.abstract_factory;

/**
 * 추상 팩토리 패턴에서는 인터페이스를 이용하여 서로 연관된, 또는 의존하는 객체를 구상 클래스를 지정하지 않고도 생성할 수 있습니다.
 *
 */
public class StudyAbstractFactory {

    public static void main(String[] args) {
        System.out.println(">>==================== " + StudyAbstractFactory.class.getSimpleName());

        PizzaIngredientFactory ingredientFactory = new NewYorkPizzaIngredientFactory();
        //PizzaIngredientFactory ingredientFactory = new ChicagoPizzaIngredientFactory();

        ingredientFactory.createDough();
        ingredientFactory.createSauce();

    }

    private static abstract class PizzaIngredientFactory {

        PizzaIngredientFactory() {
            System.out.println(">>================ init: " + this.getClass().getSimpleName());
        }

        abstract Dough createDough();
        abstract Sauce createSauce();
        // ...
    }

    private static class NewYorkPizzaIngredientFactory extends PizzaIngredientFactory {



        @Override
        public Dough createDough() {
            return new ThickDough();
        }

        @Override
        public Sauce createSauce() {
            return new AncientSauce();
        }
    }

    private static class ChicagoPizzaIngredientFactory extends PizzaIngredientFactory {

        @Override
        public Dough createDough() {
            return new ThinDough();
        }

        @Override
        public Sauce createSauce() {
            return new SpecialSauce();
        }
    }



    private static abstract class Dough {
        Dough() {
            System.out.println(">>================ init: " + this.getClass().getSimpleName());
        }

    }

    private static class ThinDough extends Dough {

    }

    private static class ThickDough extends Dough {

    }

    private static abstract class Sauce {
        Sauce() {
            System.out.println(">>================ init: " + this.getClass().getSimpleName());
        }
    }

    private static  class SpecialSauce extends Sauce {

    }

    private static  class AncientSauce extends Sauce {

    }

}
