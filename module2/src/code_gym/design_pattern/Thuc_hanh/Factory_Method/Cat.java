package code_gym.design_pattern.Thuc_hanh.Factory_Method;

import code_gym.design_pattern.Thuc_hanh.Factory_Method.Animal;

public class Cat extends Animal {
    @Override
    public String makeSound() {
        return "Mèo méo meo.....";
    }
}
