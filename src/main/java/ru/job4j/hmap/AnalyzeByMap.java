package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int count = 0;
        double resultSum = 0;
        for (Pupil pupil : pupils) {
            for (Subject subj : pupil.subjects()) {
                resultSum += subj.score();
                count++;
            }
        }
        return resultSum / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double resultSum = 0;
            for (Subject subj : pupil.subjects()) {
                resultSum += subj.score();
            }
            result.add(new Label(pupil.name(), resultSum / pupil.subjects().size()));
        }
        return result;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subj : pupil.subjects()) {
                int resultSum = map.getOrDefault(subj.name(), 0) + subj.score();
                map.put(subj.name(), resultSum);
            }
        }
        for (String name : map.keySet()) {
            result.add(new Label(name, map.get(name) / (double) pupils.size()));
        }
        return result;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double resultSumScore = 0;
            for (Subject subj : pupil.subjects()) {
                resultSumScore += subj.score();
            }
            result.add(new Label(pupil.name(), resultSumScore));
        }
        result.sort(Comparator.naturalOrder());
        return result.get(result.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subj : pupil.subjects()) {
                int resultScoreSum = subj.score();
                if (map.containsKey(subj.name())) {
                    resultScoreSum = map.get(subj.name()) + subj.score();
                }
                map.put(subj.name(), resultScoreSum);
            }
        }
        for (String name : map.keySet()) {
            result.add(new Label(name, map.get(name)));
        }
        result.sort(Comparator.naturalOrder());
        return result.get(result.size() - 1);
    }
}
