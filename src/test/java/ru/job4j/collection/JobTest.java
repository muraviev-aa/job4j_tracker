package ru.job4j.collection;

import org.assertj.core.internal.Arrays;
import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class JobTest {
    @Test
    public void whenCompatorAscByName() {
        Comparator<Job> cmpAscName = new JobAscByName();
        int rsl = cmpAscName.compare(
                new Job("AJob", 1),
                new Job("BJob", 2)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompatorDescByName() {
        Comparator<Job> cmpDescName = new JobDescByName();
        int rsl = cmpDescName.compare(
                new Job("AJob", 1),
                new Job("BJob", 2)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenCompatorAscByPriority() {
        Comparator<Job> cmpAscPriority = new JobAscByPriority();
        int rsl = cmpAscPriority.compare(
                new Job("AJob", 1),
                new Job("BJob", 2)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompatorDescByPriority() {
        Comparator<Job> cmpAscPriority = new JobDescByPriority();
        int rsl = cmpAscPriority.compare(
                new Job("AJob", 1),
                new Job("BJob", 2)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenCompatorDescByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenCompatorAscByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompatorAscByNameAndDescPriority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobDescByName());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl).isEqualTo(0);
    }
}