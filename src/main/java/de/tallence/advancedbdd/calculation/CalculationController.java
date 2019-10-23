package de.tallence.advancedbdd.calculation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(value = {"person", "calcResult"})
public class CalculationController {
    @GetMapping("/calculation-input.html")
    public String show(Model model) {
        model.addAttribute("calculationForm", new CalculationForm());
        return "calculation-input";
    }

    @PostMapping("/calculate")
    public String calculate(final CalculationForm calculationForm) {

        return "redirect:calculation-result.html";
    }

    @GetMapping("/calculation-result.html")
    public String showCalculationResult() {
        return "calculation-result";
    }

}
