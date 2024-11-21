package data;

import java.util.Arrays;
import java.util.List;

public class OrderData {

    // Валидные данные для тестов
    public static final List<String[]> TEST_DATA = Arrays.asList(
            new String[] {
                    "Игорь",
                    "Лёвэн",
                    "ул. Пушкина",
                    "245624563546",
                    "Сокольники",
                    "9",
                    "UPPER"
            },
            new String[] {
                    "Василий",
                    "Петрович",
                    "ул. Ленина",
                    "445624563598",
                    "Комсомольская",
                    "5",
                    "LOWER"
            }
    );

    // Невалидные данные для тестирования полей
    public static final List<String[]> INVALID_DATA = Arrays.<String[]>asList(
            new String[]{
                    "5645674567",
                    "6e57767",
                    "56766755674745eurhdfghtdfgh",
                    "5675677567"}
    );


    // Ожидаемые ошибки для невалидных данных
    public static final List<String> ERROR_MESSAGES = Arrays.asList(
            "Введите корректное имя",
            "Введите корректную фамилию",
            "Введите корректный адрес",
            "Введите корректный номер"
    );
}
