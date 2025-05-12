package calculator.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class carclulatorModel {
    private static final Pattern Custom_Separator = Pattern.compile("^//(.)\\\\n(.*)");

    public int calculator(String input){
        if(input == null || input.isEmpty()) return 0;

        String delimiter = ",|:";

        Matcher matcher = Custom_Separator.matcher(input);

        if(matcher.matches()){
            String customDelimiter = matcher.group(1);
            input = matcher.group(2);
            delimiter = Pattern.quote(customDelimiter) + "|" + delimiter;
        }


        String[] tokens = input.split(delimiter);
        int sum = Arrays.stream(tokens)
                .filter(token -> !token.isEmpty())
                .mapToInt(token->{
                    try{
                        return Integer.parseInt(token);
                    }catch (NumberFormatException e){
                        throw new IllegalArgumentException("IllegalArgumentException");
                    }
                })
                .sum();

        return sum;
    }
}
