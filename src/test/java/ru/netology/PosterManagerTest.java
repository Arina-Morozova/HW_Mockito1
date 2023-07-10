package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PosterManagerTest {

    @Test
    public void shouldAddFilm() {
        PosterManager posterManager = new PosterManager();
        posterManager.save("Бладшот");
        posterManager.save("Вперёд");
        posterManager.save("Отель 'Белград'");

        String[] expected = {"Бладшот", "Вперёд", "Отель 'Белград'"};
        String[] actual = posterManager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddOneFilm() {
        PosterManager posterManager = new PosterManager();
        posterManager.save("Бладшот");

        String[] expected = {"Бладшот"};
        String[] actual = posterManager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddZeroFilm() {
        PosterManager posterManager = new PosterManager();

        String[] expected = {};
        String[] actual = posterManager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLastFilmsIfLessLimit() {
        PosterManager posterManager = new PosterManager();
        posterManager.save("Бладшот");
        posterManager.save("Вперёд");
        posterManager.save("Отель 'Белград'");

        String[] expected = {"Отель 'Белград'", "Вперёд", "Бладшот"};
        String[] actual = posterManager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLastFilmsIfLimit() {
        PosterManager posterManager = new PosterManager();
        posterManager.save("Бладшот");
        posterManager.save("Вперёд");
        posterManager.save("Отель 'Белград'");
        posterManager.save("Джентльмены");
        posterManager.save("Человек-невидимка");

        String[] expected = {"Человек-невидимка", "Джентльмены", "Отель 'Белград'", "Вперёд", "Бладшот"};
        String[] actual = posterManager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLastFilmsIfMoreLimit() {
        PosterManager posterManager = new PosterManager();
        posterManager.save("Бладшот");
        posterManager.save("Вперёд");
        posterManager.save("Отель 'Белград'");
        posterManager.save("Джентльмены");
        posterManager.save("Человек-невидимка");
        posterManager.save("Тролли. Мировой тур");

        String[] expected = {"Тролли. Мировой тур", "Человек-невидимка", "Джентльмены", "Отель 'Белград'", "Вперёд"};
        String[] actual = posterManager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLastFilmsIfSetLimitIfLessLimit() {
        PosterManager posterManager = new PosterManager(6);
        posterManager.save("Бладшот");
        posterManager.save("Вперёд");
        posterManager.save("Отель 'Белград'");

        String[] expected = {"Отель 'Белград'", "Вперёд", "Бладшот"};
        String[] actual = posterManager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLastFilmsIfSetLimitIfMoreLimit() {
        PosterManager posterManager = new PosterManager(4);
        posterManager.save("Бладшот");
        posterManager.save("Вперёд");
        posterManager.save("Отель 'Белград'");
        posterManager.save("Джентльмены");
        posterManager.save("Человек-невидимка");
        posterManager.save("Тролли. Мировой тур");

        String[] expected = {"Тролли. Мировой тур", "Человек-невидимка", "Джентльмены", "Отель 'Белград'"};
        String[] actual = posterManager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLastFilmsIfSetLimitIfLimit() {
        PosterManager posterManager = new PosterManager(6);
        posterManager.save("Бладшот");
        posterManager.save("Вперёд");
        posterManager.save("Отель 'Белград'");
        posterManager.save("Джентльмены");
        posterManager.save("Человек-невидимка");
        posterManager.save("Тролли. Мировой тур");

        String[] expected = {"Тролли. Мировой тур", "Человек-невидимка", "Джентльмены", "Отель 'Белград'", "Вперёд", "Бладшот"};
        String[] actual = posterManager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}
