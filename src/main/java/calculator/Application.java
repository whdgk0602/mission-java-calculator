package calculator;

import calculator.controller.carclulatorController;
import calculator.model.carclulatorModel;
import calculator.view.carclulatorView;

public class Application {
    public static void main(String[] args) {
        carclulatorModel model = new carclulatorModel();
        carclulatorView view = new carclulatorView();
        carclulatorController controller = new carclulatorController(model, view);
        controller.run();
    }
}
