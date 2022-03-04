package code_gym.behavior.TemplateMethod;

public abstract class Meal {
    public abstract void prepareIngredients();
    public abstract void cook();
    public void eat(){
        System.out.println("mlem mlem,that's good");
    }
    public abstract void cleanUp();
    public final void doMeal(){
        prepareIngredients();
        cook();
        eat();
        cleanUp();
    }
}
