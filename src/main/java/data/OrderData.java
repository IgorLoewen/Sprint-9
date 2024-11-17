package data;

import java.util.Arrays;
import java.util.List;

public class OrderData {
    // Параметры массивов данных
    public static final List<String[]> TEST_DATA = Arrays.asList(
      //    new String[]{"Игорь", "Лёвэн", "ул. Пушкина", "245624563546", "Сокольники"},
            new String[]{"Игорь", "Лёвэн", "ул. Пушкина", "245624563546", "Сокольники"},
            new String[]{"Василий", "Петрович", "ул. Ленина", "445624563598", "Комсомольская"}
    );

    // Статические параметры (меняются вручную)
    public static final String CALENDAR_DATE = "9"; // Здесь можно изменить дату Когда привезти САМОКАТ
    public static final String ORDER_BUTTON = "LOWER"; // Здесь выбираем кнопку: UPPER или LOWER
                                                       // Верхняя или нижняя кнопки ЗАКАЗАТЬ для выбора
}
