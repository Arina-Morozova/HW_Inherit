package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {

    @Test
    public void shouldMatchesSimpleTaskIfTrue() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        Task task = new Task(5);

        boolean expected = true;
        boolean actual = simpleTask.matches("Позвонить");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchesSimpleTaskIfFalse() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        Task task = new Task(5);

        boolean expected = false;
        boolean actual = simpleTask.matches("Встретить");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchesEpicIfTrueOnce() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Task task = new Task(55);

        boolean expected = true;
        boolean actual = epic.matches("Молоко");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchesEpicIfFalse() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Task task = new Task(55);

        boolean expected = false;
        boolean actual = epic.matches("Мука");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchesMeetingIfTrueForTopic() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Task task = new Task(555);

        boolean expected = true;
        boolean actual = meeting.matches("Выкатка");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchesMeetingIfTrueForProject() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Task task = new Task(555);

        boolean expected = true;
        boolean actual = meeting.matches("Приложение");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchesMeetingIfFalse() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Task task = new Task(555);

        boolean expected = false;
        boolean actual = meeting.matches("Сайт");
        Assertions.assertEquals(expected, actual);
    }
}
