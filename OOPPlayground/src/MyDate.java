public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public MyDate getNextDate() {
        int nextYear = year;
        int nextMonth = month;
        int nextDay = day;

        int daysInMonth = getDaysInMonth(month, year);

        if (day == daysInMonth) { // last day check
            if (month == 12) {
                nextYear++;
                nextMonth = 1;
            } else {
                nextMonth++;
            }
            nextDay = 1;
        } else {
            nextDay++;
        }

        return new MyDate(nextYear, nextMonth, nextDay);
    }

    private int getDaysInMonth(int month, int year) {
        switch (month) {
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                if (isLeapYear(year)) {
                    return 29;
                } else {
                    return 28;
                }
            default:
                return 31;
        }
    }

    public MyDate addYear(int yearToAdd) {
        int newYear = year + yearToAdd;
        int newMonth = month;
        int newDay = day;

        if (month == 2 && day == 29 && !isLeapYear(newYear)) {
            newMonth = 3;
            newDay = 1;
        }

        return new MyDate(newYear, newMonth, newDay);
    }

    public MyDate addMonth(int monthsToAdd) {
        int newYear = year;
        int newMonth = month + monthsToAdd;
        int newDay = day;

        while (newMonth > 12) {
            newMonth -= 12;
            newYear++;
        }

        while (newMonth < 1) {
            newMonth += 12;
            newYear--;
        }

        int maxDayInNewMonth = getDaysInMonth(newMonth, newYear);
        if (newDay > maxDayInNewMonth) {
            newDay = maxDayInNewMonth;
        }

        return new MyDate(newYear, newMonth, newDay);
    }

    public MyDate addDay(int daysToAdd) {
        int newYear = year;
        int newMonth = month;
        int newDay = day + daysToAdd;

        while (newDay > getDaysInMonth(newMonth, newYear)) {
            newDay -= getDaysInMonth(newMonth, newYear);
            newMonth++;

            if (newMonth > 12) {
                newMonth = 1;
                newYear++;
            }
        }

        return new MyDate(newYear, newMonth, newDay);
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}
