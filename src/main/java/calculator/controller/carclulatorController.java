package calculator.controller;

import calculator.model.carclulatorModel;
import calculator.view.carclulatorView;

public class carclulatorController {
    private final carclulatorModel model;
    private final carclulatorView view;

    public carclulatorController(carclulatorModel model, carclulatorView view){
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
