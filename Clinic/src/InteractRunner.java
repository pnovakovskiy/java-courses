import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Класс, иммитирующий работу клиники
 */
public class InteractRunner {
    private Scanner scanner;
    private Clinic clinic;

    /**
     * Печатает главное меню
     */
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

    /**
     * Конструктор класса
     */
    public InteractRunner() {
        scanner = new Scanner(System.in);
        clinic = new Clinic();
        runExec();
    }

    private void runExec() {
        int userChoice = 0;
        while (userChoice != 9) {
            printMainMenu();
            try {
                userChoice = scanner.nextInt();

                switch (userChoice) {
                    case 1:
                        addNewClient();
                        break;
                }
            }
            catch (InputMismatchException exc) {
                System.out.println(exc.getMessage());
                userChoice = 0;
            }

        }
    }

    private void addNewClient() {
        String id = "";
        System.out.println("Введите имя клиента:");
        while (id.equals("")) {
            try {
                id = scanner.nextLine();
            }
            catch (NoSuchElementException exc) {
                id = "";
                System.out.println(exc.getMessage());
            }
        }
        Pet pet  = addNewPet();
        clinic.addClient(new Client(id, pet));
        System.out.println("Клиент добавлен.");
    }

    /**
     * Создание нового домашнего питомца
     * @return Pet домашний питомец
     */
    private Pet addNewPet() {
        System.out.println("Какое домашнее животное необходимо добавить? (СОБАКА или КОШКА):");
        String petKind = scanner.nextLine();
        while (!petKind.equalsIgnoreCase("собака") && !petKind.equalsIgnoreCase("кошка")) {
            System.out.println("Неизвестное домашнее животное. Повторите попытку.");
            petKind = scanner.nextLine();
        }

        System.out.println("Введите кличку домашнего животного:");
        String petName = scanner.nextLine();

        Pet pet = null;
        if (petKind.equalsIgnoreCase("собака")) {
            pet = new Dog(petName);
        }
        else if (petKind.equalsIgnoreCase("кошка")) {
            pet = new Cat(petName);
        }

        return pet;
    }



    public static void main(String[] args) {
        InteractRunner ir = new InteractRunner();
    }
}
