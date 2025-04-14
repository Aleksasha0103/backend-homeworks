package ru.alexandradeeva.week_day.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DayOfWeek {
    public enum DayOfWeekList {
        Sunday("воскресенье"),
        Monday("понедельник"),
        Tuesday("вторник"),
        Wednesday("среда"),
        Thursday("четверг"),
        Friday("пятница"),
        Saturday("суббота");

        private final String title;

        DayOfWeekList(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }
    }

    @GetMapping("/dayOfWeek")
    public String getDayOfWeek(@RequestParam(value = "name", defaultValue = "(День не указан)") String name) {
        return String.format("Сегодня %s", DayOfWeekList.valueOf(name).getTitle());
    }
}


























