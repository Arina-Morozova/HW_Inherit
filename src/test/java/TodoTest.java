import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodoTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchIfZeroNeededTask() {
        SimpleTask simpleTask1 = new SimpleTask(5, "Позвонить родителям");
        SimpleTask simpleTask2 = new SimpleTask(15, "Позвонить начальнику");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask1);
        todos.add(simpleTask2);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {  };
        Task[] actual = todos.search("Встретить");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchIfOneNeededSimpleTask() {
        SimpleTask simpleTask1 = new SimpleTask(5, "Позвонить родителям");
        SimpleTask simpleTask2 = new SimpleTask(15, "Встретить родителей");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask1);
        todos.add(simpleTask2);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask1 };
        Task[] actual = todos.search("Позвонить");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchIfSeveralNeededSimpleTasks() {
        SimpleTask simpleTask1 = new SimpleTask(5, "Позвонить родителям");
        SimpleTask simpleTask2 = new SimpleTask(15, "Позвонить начальнику");
        SimpleTask simpleTask3 = new SimpleTask(25, "Позвонить заказчику");
        SimpleTask simpleTask4 = new SimpleTask(35, "Встретить родителей");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask1);
        todos.add(simpleTask2);
        todos.add(simpleTask3);
        todos.add(simpleTask4);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask1, simpleTask2, simpleTask3 };
        Task[] actual = todos.search("Позвонить");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchIfOneNeededEpic() {
        SimpleTask simpleTask1 = new SimpleTask(5, "Позвонить родителям");
        SimpleTask simpleTask2 = new SimpleTask(15, "Встретить родителей");

        String[] subtasks1 = {"Молоко", "Яйца", "Хлеб"};
        Epic epic1 = new Epic(55, subtasks1);
        String[] subtasks2 = {"Мука", "Яблоки", "Сок"};
        Epic epic2 = new Epic(65, subtasks2);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask1);
        todos.add(simpleTask2);
        todos.add(epic1);
        todos.add(epic2);
        todos.add(meeting);

        Task[] expected = { epic1 };
        Task[] actual = todos.search("Молоко");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchIfSeveralNeededEpics() {
        SimpleTask simpleTask1 = new SimpleTask(5, "Позвонить родителям");
        SimpleTask simpleTask2 = new SimpleTask(15, "Позвонить начальнику");

        String[] subtasks1 = {"Молоко", "Яйца", "Хлеб"};
        Epic epic1 = new Epic(55, subtasks1);
        String[] subtasks2 = {"Молоко", "Яблоки", "Сок"};
        Epic epic2 = new Epic(65, subtasks2);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask1);
        todos.add(simpleTask2);
        todos.add(epic1);
        todos.add(epic2);
        todos.add(meeting);

        Task[] expected = { epic1, epic2 };
        Task[] actual = todos.search("Молоко");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchIfOneNeededMeetingForTopic() {
        SimpleTask simpleTask1 = new SimpleTask(5, "Позвонить родителям");
        SimpleTask simpleTask2 = new SimpleTask(15, "Встретить родителей");

        String[] subtasks1 = {"Молоко", "Яйца", "Хлеб"};
        Epic epic1 = new Epic(55, subtasks1);

        Meeting meeting1 = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Meeting meeting2 = new Meeting(
                655,
                "Обсуждение нового функционала сайта",
                "Сайт НетоБанка",
                "В среду после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask1);
        todos.add(simpleTask2);
        todos.add(epic1);
        todos.add(meeting1);
        todos.add(meeting2);

        Task[] expected = { meeting1 };
        Task[] actual = todos.search("Выкатка");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchIfSeveralNeededMeetingsForTopic() {
        SimpleTask simpleTask1 = new SimpleTask(5, "Позвонить родителям");
        SimpleTask simpleTask2 = new SimpleTask(15, "Позвонить начальнику");

        String[] subtasks1 = {"Молоко", "Яйца", "Хлеб"};
        Epic epic1 = new Epic(55, subtasks1);
        String[] subtasks2 = {"Молоко", "Яблоки", "Сок"};
        Epic epic2 = new Epic(65, subtasks2);

        Meeting meeting1 = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Meeting meeting2 = new Meeting(
                655,
                "Обсуждение нового функционала приложения",
                "Приложение НетоБанка",
                "В среду после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask1);
        todos.add(simpleTask2);
        todos.add(epic1);
        todos.add(epic2);
        todos.add(meeting1);
        todos.add(meeting2);

        Task[] expected = { meeting1, meeting2 };
        Task[] actual = todos.search("Приложение");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchIfOneNeededMeetingForProject() {
        SimpleTask simpleTask1 = new SimpleTask(5, "Позвонить родителям");
        SimpleTask simpleTask2 = new SimpleTask(15, "Встретить родителей");

        String[] subtasks1 = {"Молоко", "Яйца", "Хлеб"};
        Epic epic1 = new Epic(55, subtasks1);

        Meeting meeting1 = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Meeting meeting2 = new Meeting(
                655,
                "Обсуждение нового функционала сайта",
                "Сайт НетоБанка",
                "В среду после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask1);
        todos.add(simpleTask2);
        todos.add(epic1);
        todos.add(meeting1);
        todos.add(meeting2);

        Task[] expected = { meeting1 };
        Task[] actual = todos.search("Приложение");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchIfSeveralNeededMeetingsForProject() {
        SimpleTask simpleTask1 = new SimpleTask(5, "Позвонить родителям");
        SimpleTask simpleTask2 = new SimpleTask(15, "Позвонить начальнику");

        String[] subtasks1 = {"Молоко", "Яйца", "Хлеб"};
        Epic epic1 = new Epic(55, subtasks1);
        String[] subtasks2 = {"Молоко", "Яблоки", "Сок"};
        Epic epic2 = new Epic(65, subtasks2);

        Meeting meeting1 = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "НетоБанк",
                "Во вторник после обеда"
        );

        Meeting meeting2 = new Meeting(
                655,
                "Обсуждение нового функционала приложения",
                "НетоБанк",
                "В среду после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask1);
        todos.add(simpleTask2);
        todos.add(epic1);
        todos.add(epic2);
        todos.add(meeting1);
        todos.add(meeting2);

        Task[] expected = { meeting1, meeting2 };
        Task[] actual = todos.search("НетоБанк");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchIfSeveralTypesOfTasks() {
        SimpleTask simpleTask1 = new SimpleTask(5, "Позвонить родителям");
        SimpleTask simpleTask2 = new SimpleTask(15, "Позвонить начальнику, обсудить Приложение");
        SimpleTask simpleTask3 = new SimpleTask(25, "Позвонить заказчику");
        SimpleTask simpleTask4 = new SimpleTask(35, "Встретить родителей");

        String[] subtasks1 = {"Приложение", "Сайт", "Сервер"};
        Epic epic1 = new Epic(55, subtasks1);
        String[] subtasks2 = {"Мука", "Яблоки", "Сок"};
        Epic epic2 = new Epic(65, subtasks2);

        Meeting meeting1 = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Meeting meeting2 = new Meeting(
                655,
                "Обсуждение нового функционала сайта",
                "Сайт НетоБанка",
                "В среду после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask1);
        todos.add(simpleTask2);
        todos.add(simpleTask3);
        todos.add(simpleTask4);
        todos.add(epic1);
        todos.add(epic2);
        todos.add(meeting1);
        todos.add(meeting2);

        Task[] expected = { simpleTask2, epic1, meeting1 };
        Task[] actual = todos.search("Приложение");
        Assertions.assertArrayEquals(expected, actual);
    }
}
