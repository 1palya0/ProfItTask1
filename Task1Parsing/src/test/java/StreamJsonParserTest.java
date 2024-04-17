import org.example.Book;
import org.example.StreamJsonParser;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;


public class StreamJsonParserTest {

    @Test
    void parseJsonFiles_ValidFolderPath_Success() throws IOException {
        StreamJsonParser parser = new StreamJsonParser();
        List<Book> books = parser.parseJsonFiles("src/main/resources");

        assertNotNull(books);
        assertTrue(books.size() > 0);

        for (Book book : books) {
            assertNotNull(book.getTitle());
            assertFalse(book.getTitle().isEmpty());
        }
    }

    @Test
    void parseJsonFiles_InvalidFolderPath_ThrowsIOException() {
        StreamJsonParser parser = new StreamJsonParser();
        try {
            parser.parseJsonFiles("invalid_folder_path");
        } catch (IOException e) {
            assertTrue(e.getMessage().contains("Нема такого файлу"));
        }
    }

    @Test
    void parseJsonFiles_EmptyFolderPath_EmptyList() throws IOException {
        StreamJsonParser parser = new StreamJsonParser();
        List<Book> books = parser.parseJsonFiles("src/test/resources/empty_folder");
        assertNotNull(books);
        assertEquals(0, books.size());
    }
}