import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskMainTest2 {

    // Тест с одним неверным словом
    @Test
    void chek() throws Exception {
        String actual = TaskMain.Chek("text=Helo world, I'm happy");
        String expected = "Количество слов с орфографическими ошибками: 1\nОшибки в словах:\nHelo";
        assertEquals(actual, expected);
    }
}