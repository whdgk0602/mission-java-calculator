package calculator.controller;

import calculator.model.calclulatorModel;
import calculator.view.calclulatorView;

public class calclulatorController {
    private final calclulatorModel model;
    private final calclulatorView view;

    public calclulatorController(calclulatorModel model, calclulatorView view){
        this.model = model;
        this.view = view;
    }

    public void run(){
        try{
            String input = view.getInput();
            int result = model.calculator(input);
            view.printResult(result);
        }catch (IllegalArgumentException e){
            view.printError(e.getMessage());
        }
    }
}
