package org.example;

import net.jqwik.api.*;
import net.jqwik.api.constraints.IntRange;

import java.util.*;
import java.util.stream.*;

public class MathFunctionsTest {

    // a) MultiplyByTwo: valide que o resultado é sempre par.
    @Property
    boolean multiplyByTwoReturnsCorrect(@ForAll int number) {
        int result = MathFunctions.MultiplyByTwo(number);
        return result % 2 == 0;
    }

    // b) GenerateMultiplicationTable: valide que todos os elementos são múltiplos do número original.
    @Property
    boolean allElementsAreMultiples(
            @ForAll @IntRange(min = -1_000_000, max = 1_000_000) int number,
            @ForAll @IntRange(min = 1, max = 100) int limit
    ) {
        Assume.that(number != 0); // evita divisão por zero no assert
        int[] table = MathFunctions.GenerateMultiplicationTable(number, limit);
        return table.length == limit && Arrays.stream(table).allMatch(x -> x % number == 0);
    }

    // c) IsPrime: valide que para qualquer número primo, não há divisores além de 1 e ele mesmo.
    @Property
    boolean primesHaveOnlylDivisors(@ForAll @IntRange(min = 2, max = 10_000) int number) {
        Assume.that(MathFunctions.IsPrime(number));
        return IntStream.rangeClosed(2, number - 1).noneMatch(i -> number % i == 0);
    }

    // d) CalculateAverage: resultado está sempre entre o menor e o maior valor do array.
    @Property
    boolean averageIsWithinRange(
            @ForAll List<@IntRange(min = -1_000_000, max = 1_000_000) Integer> list
    ) {
        Assume.that(list != null && !list.isEmpty());
        int[] array = list.stream().mapToInt(Integer::intValue).toArray();
        double avg = MathFunctions.CalculateAverage(array);
        int min = Arrays.stream(array).min().orElseThrow();
        int max = Arrays.stream(array).max().orElseThrow();
        return avg >= min && avg <= max;
    }
}
