import org.junit.jupiter.api.Test;

import javax.imageio.IIOException;

import static org.junit.jupiter.api.Assertions.*;

class TaskMainTest3 {

    // Тест с правильным текстом
    @Test
    void chek() throws Exception {
        String actual = TaskMain.Chek("text=Hello world, I'm happy");
        String expected = "Слов с ошибками нет";
        assertEquals(actual, expected);
    }
}