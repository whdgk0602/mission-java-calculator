package calculator;

import calculator.controller.calclulatorController;
import calculator.model.calclulatorModel;
import calculator.view.calclulatorView;

public class Application {
    public static void main(String[] args) {
        calclulatorModel model = new calclulatorModel();
        calclulatorView view = new calclulatorView();
        calclulatorController controller = new calclulatorController(model, view);
        controller.run();
    }
}
