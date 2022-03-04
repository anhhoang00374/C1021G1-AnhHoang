package code_gym.inherictance.exercise.circle_cylinder.service;

import code_gym.inherictance.exercise.circle_cylinder.model.Circle;
import code_gym.inherictance.exercise.circle_cylinder.model.Cylinder;

public class CylinderService extends CircleService{
    public CylinderService(){

    }
    public  double volume (Cylinder cylinder){
        return super.getArea(cylinder)*cylinder.getHeight();
    }
}
