package ru.job4j.function;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FunctionCalculatorTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result).containsAll(expected);
    }

    @Test
    public void whenQuadFunctionThenQuadResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(100, 105, x -> x * x);
        List<Double> expected = Arrays.asList(10000D, 10201D, 10404D, 10609D, 10816D);
        assertThat(result).containsAll(expected);
    }

    @Test
    public void whenExponentFunctionThenExponentResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(10, 14, x -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(1024D, 2048D, 4096D, 8192D);
        assertThat(result).containsAll(expected);
    }
}