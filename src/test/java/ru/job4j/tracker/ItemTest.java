package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemTest {
    @Test
    public void whenSortAscByName() {
        List<Item> items = Arrays.asList(
                new Item("New4"),
                new Item("New2"),
                new Item("New3"),
                new Item("New1"),
                new Item("New5")
                );
        List<Item> expected = Arrays.asList(
                new Item("New1"),
                new Item("New2"),
                new Item("New3"),
                new Item("New4"),
                new Item("New5")
                );
        items.sort(new ItemAscByName());
        assertThat(items).isEqualTo(expected);
    }

    @Test
    public void whenSortDescByName() {
        List<Item> items = Arrays.asList(
                new Item("New4"),
                new Item("New2"),
                new Item("New3"),
                new Item("New1"),
                new Item("New5")
        );
        List<Item> expected = Arrays.asList(
                new Item("New5"),
                new Item("New4"),
                new Item("New3"),
                new Item("New2"),
                new Item("New1")
        );
        items.sort(new ItemDescByName());
        assertThat(items).isEqualTo(expected);
    }
}