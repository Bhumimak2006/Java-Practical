package app.service;

import app.model.Item;
import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class ItemServiceTest {

    @Test
    void savedDataLoadsUnchanged() throws Exception {
        Path file = Files.createTempFile("items", ".dat");

        try {
            ItemService original = new ItemService();
            original.addItem("Book");
            original.addItem("Pen");

            original.save(file.toString());

            ItemService loaded = new ItemService();
            loaded.load(file.toString());

            assertEquals(original.getCount(), loaded.getCount());

            for (int i = 0; i < original.getCount(); i++) {
                assertEquals(
                    original.getItems().get(i).getName(),
                    loaded.getItems().get(i).getName()
                );
            }

            System.out.println("Save/load test passed");
        } finally {
            Files.deleteIfExists(file);
        }
    }
}