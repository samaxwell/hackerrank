package challenges.datastructures.arrayLeftShift;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("leftArguments")
    public void givenListAndShift_shouldShiftLeftByGivenAmount(int shift, List<Integer> initial, List<Integer> expectedResponse) {
        List<Integer> response = solution.rotateLeft(shift, initial);

        assertAll(() -> {
            assertTrue(expectedResponse.size() == response.size(), "Lists are same size");
            assertEquals(expectedResponse, response, "response has correct contents");
        });
    }

    @ParameterizedTest
    @MethodSource("rightArguments")
    public void givenListAndShift_shouldShiftRightByGivenAmount(int shift, List<Integer> initial, List<Integer> expectedResponse) {
        List<Integer> response = solution.rotateRight(shift, initial);

        assertAll(() -> {
            assertTrue(expectedResponse.size() == response.size(), "Lists are same size");
            assertEquals(expectedResponse, response, "response has correct contents");
        });
    }

    private static Stream<Arguments> leftArguments() {
        return Stream.of(
                /* Special cases */
                Arguments.of(0, List.of(1,2,3,4,5), List.of(1,2,3,4,5)),
                Arguments.of(2, List.of(), List.of()),
                /* Standard cases */
                Arguments.of(1, List.of(1,2,3,4,5), List.of(2,3,4,5,1)),
                Arguments.of(2, List.of(1,2,3,4,5), List.of(3,4,5,1,2)),
                Arguments.of(3, List.of(1,2,3,4,5), List.of(4,5,1,2,3)),
                Arguments.of(4, List.of(1,2,3,4,5), List.of(5,1,2,3,4)),
                Arguments.of(5, List.of(1,2,3,4,5), List.of(1,2,3,4,5)),
                Arguments.of(6, List.of(1,2,3,4,5), List.of(2,3,4,5,1)),
                Arguments.of(78, List.of(1,2,3,4,5), List.of(4,5,1,2,3)),
                Arguments.of(3, List.of(11,22,33,43,55), List.of(43,55,11,22,33)),
                Arguments.of(6, List.of(-1,-2,-3,-4,-5), List.of(-2,-3,-4,-5,-1))
        );
    }

    private static Stream<Arguments> rightArguments() {
        return Stream.of(
                /* Special cases */
                Arguments.of(0, List.of(1,2,3,4,5), List.of(1,2,3,4,5)),
                Arguments.of(2, List.of(), List.of()),
                /* Standard cases */
                Arguments.of(1, List.of(1,2,3,4,5), List.of(5,1,2,3,4)),
                Arguments.of(2, List.of(1,2,3,4,5), List.of(4,5,1,2,3)),
                Arguments.of(3, List.of(1,2,3,4,5), List.of(3,4,5,1,2)),
                Arguments.of(4, List.of(1,2,3,4,5), List.of(2,3,4,5,1)),
                Arguments.of(5, List.of(1,2,3,4,5), List.of(1,2,3,4,5)),
                Arguments.of(6, List.of(1,2,3,4,5), List.of(5,1,2,3,4)),
                Arguments.of(78, List.of(1,2,3,4,5), List.of(3,4,5,1,2)), // just 3
                Arguments.of(3, List.of(11,22,33,43,55), List.of(33,43,55,11,22)),
                Arguments.of(6, List.of(-1,-2,-3,-4,-5), List.of(-5,-1,-2,-3,-4))
        );
    }
}