import org.example.Book;
import org.example.StatisticsCalculator;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class StatisticsCalculatorTest {




    @Test
    public void testEmptyList() {
        List<Book> emptyList = Collections.emptyList();
        String attribute = "author";

        Map<String, Long> statistics = new StatisticsCalculator().calculateStatistics(emptyList, attribute);

        assertEquals(Collections.emptyMap(), statistics);
    }



}
