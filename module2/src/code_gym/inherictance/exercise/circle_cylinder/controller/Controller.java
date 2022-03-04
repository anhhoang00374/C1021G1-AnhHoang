package code_gym.inherictance.exercise.circle_cylinder.controller;

import code_gym.inherictance.exercise.circle_cylinder.model.Circle;
import code_gym.inherictance.exercise.circle_cylinder.model.Cylinder;
import code_gym.inherictance.exercise.circle_cylinder.service.CircleService;
import code_gym.inherictance.exercise.circle_cylinder.service.CylinderService;

public class Controller {
    public static void main(String[] args) {
        Circle circle = new Circle("red",3.5);
        Cylinder cylinder = new Cylinder("yello",4,5);
        CylinderService cylinderService = new CylinderService();
        CircleService circleService = new CircleService();
        System.out.println(circleService.getArea(circle));
        System.out.println(cylinderService.volume(cylinder));
    }
}
