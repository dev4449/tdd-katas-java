package dev.mohsenmajd;

import java.util.Arrays;
import java.util.regex.Pattern;

public class StringCalculator {
    public int calculate(String... arguments){
        var numbers = arguments[0];
        if( numbers.length() == 0) return 0;
        if( numbers.length() == 1) return Integer.parseInt(numbers);

        if(numbers.startsWith("//")) {
            var delimiter = numbers.split("\n")[0].substring(2);
            if( numbers.endsWith(delimiter) ) throw new IllegalArgumentException();
            var split = numbers.substring(delimiter.length() + 3).split(Pattern.quote(delimiter));
            return Arrays.stream(split).map(Integer::parseInt).reduce(0, Integer::sum);

        }
        else{
            if( numbers.endsWith(",") || numbers.endsWith("\n") ) throw new IllegalArgumentException();
            var split = numbers.split("[,\n]");
            return Arrays.stream(split).map(Integer::parseInt).reduce(0, Integer::sum);
        }

    }
}
