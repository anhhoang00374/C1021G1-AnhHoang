package code_gym.structeral_design_pattern.Proxy;

public class TestProxy {
    public static void main(String[] args) {
        MathCalculatorProxy mathCalculatorProxy = new MathCalculatorProxy();
        double result = mathCalculatorProxy.add(1,2);
        System.out.println("1 + 2 =" + result);
        result = mathCalculatorProxy.add(2,Double.MAX_VALUE);
        System.out.println("2 + Double.MAX_VALUE = " + result);
    }
}
