/**
 * Класс, иммитирующий работу клиники
 */
public class InteractRunner {

    private void printMainMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1. Добавить клиента");
        System.out.println("2. Добавить питомца клиенту");
        System.out.println("3. Найти клиента по имени");
        System.out.println("4. Найти питомца по кличке");
        System.out.println("5. Изменить имя клиента");
        System.out.println("6. Изменить кличку питомцу");
        System.out.println("7. Удалить клиента");
        System.out.println("8. Удалить питомца");
        System.out.println("9. Выйти из программы");
    }

    public InteractRunner() {
        printMainMenu();
    }

    public static void main(String[] args) {
        InteractRunner ir = new InteractRunner();
    }
}
