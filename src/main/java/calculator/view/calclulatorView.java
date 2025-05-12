package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class calclulatorView {
    public String getInput(){
        System.out.println("문자열을 입력해주세요.");
        return Console.readLine();
    }

    public void printResult(int result){
        System.out.println("결과 : " + result);
    }

    public void printError(String e){
        System.err.println(e);
    }
}
