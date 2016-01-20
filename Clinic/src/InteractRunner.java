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
     * Возвращает введенное пользователем значение
     * @return
     */
    private String getUserWordAnswer() {
        String answer = "";
        try {
            answer = scanner.nextLine();
        }
        catch (NoSuchElementException exc) {
            answer = "";
            System.out.println(exc.getMessage());
        }
        return answer;
    }

    /**
     * Конструктор класса
     */
    public InteractRunner() {
        scanner = new Scanner(System.in);
        clinic = new Clinic();
        runExec();
    }

    /**
     * Запускает работу класса, иммитирующего клинику
     */
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

    /**
     * Добавляет нового клиента
     */
    private void addNewClient() {
        String id = "";
        Client client = null;

        while (id.equals("")) {
            System.out.println("Введите имя клиента:");
            id = getUserWordAnswer();
        }
        client = new Client(id);
        clinic.addClient(client);
        System.out.println("Клиент добавлен.");

        System.out.println("Добавить питомца клиенту? (да/нет)");
        if (getUserWordAnswer().equalsIgnoreCase("да")) {
            boolean addResult = false;
            while (!addResult) {
                Pet pet  = addNewPet();
                try {
                    client.addPet(pet);
                    addResult = true;
                    System.out.println("Питомец добавлен.");
                }
                catch (DuplicateNameException exc) {
                    addResult = false;
                    System.out.println(exc.getMessage());
                }
            }
        }

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
