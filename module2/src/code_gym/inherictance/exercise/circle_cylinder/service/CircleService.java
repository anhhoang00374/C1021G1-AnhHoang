package code_gym.inherictance.exercise.circle_cylinder.service;

import code_gym.inherictance.exercise.circle_cylinder.model.Circle;

public class CircleService {
    public CircleService(){

    }
    public double getArea(Circle circle){
        return circle.getPI()*circle.getRadius()*circle.getRadius();
    }

}
