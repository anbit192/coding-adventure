def days(month):
    day_in_months = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

    return day_in_months[month - 1]


print(days(2))
