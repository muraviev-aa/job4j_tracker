package ru.job4j.queue;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.job4j.queue.Position.*;

class ScheduleTaskTest {
    @Test
    void whenTwoDirectorTaskThenReadMethodTest() {
        ScheduleTask scheduleTask = new ScheduleTask(new TaskByPositionAsc().
                thenComparing(new TaskByUrgencyDesc()));
        scheduleTask.addTask(new Task(DEPARTMENT_HEAD, "description_1", 10));
        scheduleTask.addTask(new Task(DIRECTOR, "description_2", 4));
        scheduleTask.addTask(new Task(DIRECTOR, "description_3", 8));
        String expected = "description_3";
        String result = scheduleTask.readTask().description();
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenTwoDepartmentHeadTaskAndEqualUrgencyThenGetMethodTest() {
        ScheduleTask scheduleTask = new ScheduleTask(new TaskByPositionAsc().
                thenComparing(new TaskByUrgencyDesc()));
        scheduleTask.addTask(new Task(DEPARTMENT_HEAD, "description_1", 7));
        scheduleTask.addTask(new Task(MANAGER, "description_2", 10));
        scheduleTask.addTask(new Task(DEPARTMENT_HEAD, "description_3", 7));
        String expected = "description_1";
        String result = scheduleTask.getTask().description();
        assertThat(result).isEqualTo(expected);
        scheduleTask.getTask();
        expected = "description_2";
        result = scheduleTask.getTask().description();
        assertThat(result).isEqualTo(expected);
    }
}