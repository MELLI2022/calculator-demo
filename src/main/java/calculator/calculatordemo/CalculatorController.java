package calculator.calculatordemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String please() {
        return "Добро пожаловать в калькулятор.";
    }

    @GetMapping("/plus")
    public String plus(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        if (num1 == null || num2 == null){
            return "Ошибка, не передан параметр";
        }
        return num1+ " + " +num2+ " = " +calculatorService.plus(num1, num2);
    }
    @GetMapping("/minus")
    public String minus(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        if (num1 == null || num2 == null){
            return "Ошибка, не передан параметр";
        }
        return num1+ " * " +num2+ " = " +calculatorService.minus(num1, num2);
    }
    @GetMapping("/multiply")
    public String multiply(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        if (num1 == null || num2 == null){
            return "Ошибка, не передан параметр";
        }
        return num1+ " * " +num2+ " = " +calculatorService.multiply(num1, num2);
    }
    @GetMapping("/division")
    public String division(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        if (num1 == null || num2 == null){
            return "Ошибка, не передан параметр.";
        }
        if (num2 == 0){
            return "Ошибка, на ноль делить нельзя.";
        }
        return num1+ " / " +num2+ " = " +calculatorService.division(num1, num2);
    }

}
