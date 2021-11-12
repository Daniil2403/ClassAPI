import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskMainTest {

    // Тест с полностью неверным текстом
    @Test
    void chek() throws Exception {
        String actual = TaskMain.chek("Helo wold, I'mm happi");
        String expected = "Количество слов с орфографическими ошибками: 4\nОшибки в словах:\nHelo\nwold\nI'mm\nhappi";
        assertEquals(actual, expected);
    }
}