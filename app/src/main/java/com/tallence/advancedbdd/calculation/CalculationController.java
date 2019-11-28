package com.tallence.advancedbdd.calculation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.math.BigDecimal;

@Controller
@SessionAttributes(value = {"person", "calcResult"})
public class CalculationController {
    @GetMapping("/calculation-input.html")
    public String show(Model model) {
        model.addAttribute("calculationForm", new CalculationForm());
        return "calculation-input";
    }

    @PostMapping("/calculate")
    public String calculate(final CalculationForm calculationForm, Model model) {
        BigDecimal calcResult = calculationForm
                .getValue1()
                .add(calculationForm.getValue2())
                .add(calculationForm.getValue3());
        model.addAttribute("calcResult", calcResult);
        return "redirect:calculation-result.html";
    }

    @GetMapping("/calculation-result.html")
    public String showCalculationResult() {
        return "calculation-result";
    }

}
