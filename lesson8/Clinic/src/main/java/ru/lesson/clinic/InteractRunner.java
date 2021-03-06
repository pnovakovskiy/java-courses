package ru.lesson.clinic;

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
    public void printMainMenu() {
        System.out.println();
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
     * @param question String сообщение/вопрос пользователю
     * @return String ответ пользователя
     */
    public String getUserWordAnswer(final String question) {
        System.out.println(question);

        String answer;
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
    public InteractRunner(final Scanner scanner) {
        this.scanner = scanner;
        clinic = new Clinic();
    }

    /**
     * Запускает работу класса, иммитирующего клинику
     */
    public void runExec() {
        int userChoice = 0;
        while (userChoice != 9) {
            printMainMenu();
            try {
                userChoice = scanner.nextInt();
                scanner.nextLine();

                switch (userChoice) {
                    case 1:
                        addNewClientExec();
                        break;
                    case 2:
                        addNewPetToClientExec();
                        break;
                    case 3:
                        findClientExec();
                        break;
                    case 4:
                        findPetExec();
                        break;
                    case 5:
                        changeClientNameExec();
                        break;
                    case 6:
                        changePetNameExec();
                        break;
                    case 7:
                        deleteClientExec();
                        break;
                    case 8:
                        deletePetExec();
                        break;
                }
            }
            catch (InputMismatchException|UserException exc) {
                System.out.println(exc.getMessage());
                userChoice = 0;
            }

        }
    }

    /**
     * Добавляет нового клиента
     */
    public void addNewClientExec() {
        String id;
        Client client;

        do {
            id = getUserWordAnswer("Введите имя клиента:");
        } while (id.equals(""));
        client = new Client(id);
        clinic.addClient(client);
        System.out.println("Клиент добавлен.");
    }

    /**
     * Создание нового домашнего питомца
     * @return Pet домашний питомец
     */
    public Pet addNewPet() throws UserException {
        String petKind = getUserWordAnswer("Какое домашнее животное необходимо добавить? (СОБАКА или КОШКА):");
        if (!petKind.equalsIgnoreCase("собака") && !petKind.equalsIgnoreCase("кошка")) {
            throw new UserException("Неизвестное домашнее Животное.");
        }

        String petName = getUserWordAnswer("Введите кличку домашнего животного:");

        Pet pet = null;
        if (petKind.equalsIgnoreCase("собака")) {
            pet = new Dog(petName);
        }
        else if (petKind.equalsIgnoreCase("кошка")) {
            pet = new Cat(petName);
        }

        return pet;
    }

    /**
     * Добавляет нового питомца к существующему клиенту
     */
    public void addNewPetToClientExec() throws UserException {
        Client client = findClient();

        if (client == null) {
            throw new UserException("Клиент с таким именем не найден.");
        }
        else {
            Pet pet = addNewPet();
            try {
                client.addPet(pet);
                System.out.println("Питомец добавлен.");
            }
            catch (UserException exc) {
                System.out.println("Ошибка добавления: " + exc.getMessage());
            }
        }
    }

    /**
     * Ищет клиента по имени
     * @return Client клиент клиники
     */
    public Client findClient() {
        String clientName = getUserWordAnswer("Введите имя клиента:");
        return clinic.getClient(clientName);
    }

    /**
     * Запускает поиск клиента
     */
    public void findClientExec() throws UserException {
        Client client = findClient();

        if (client == null) {
            throw new UserException("Клиент с таким именем не найден.");
        }
        else {
            System.out.println("Клиент " + client.getID() + " найден.");
            for (Pet pet: client.getPets()) {
                System.out.println(pet.toString() + " - " + pet.getName());
            }

            System.out.println("Поиск окончен.");
        }
    }

    /**
     * Запускает поиск питомца
     */
    public void findPetExec() {
        String petName = getUserWordAnswer("Введите кличку питомца:");

        for (Client client: clinic.getClients()) {
            for (Pet pet: client.getPets()) {
                if (pet.getName().equalsIgnoreCase(petName)) {
                    System.out.println("Клиент: " + client.getID() + ", " + pet.toString() + " - " + pet.getName());
                }
            }
        }
        System.out.println("Поиск окончен.");
    }

    /**
     * Меняет имя клиента
     */
    public void changeClientNameExec() throws UserException {
        Client client = findClient();

        if (client == null) {
            throw new UserException("Клиент с таким именем не найден.");
        }
        else {
            String newName;
            do {
                newName = getUserWordAnswer("Введите новое имя клиента:");
            } while (newName.equals(""));
            client.setId(newName);
            System.out.println("Имя клиента изменено.");
        }
    }

    /**
     * Меняет кличку питомцу
     */
    public void changePetNameExec() throws UserException {
        Client client = findClient();

        if (client == null) {
            throw new UserException("Клиент с таким именем не найден.");
        }
        else {
            String petName = getUserWordAnswer("Введите кличку питомца:");

            Pet pet = client.getPet(petName);
            if (pet == null) {
                throw new UserException("Питомец с такой кличкой не найден.");
            }
            else {
                String newName;
                do {
                    newName = getUserWordAnswer("Введите новую кличку питомца:");
                } while (newName.equals(""));
                pet.setName(newName);
                System.out.println("Кличка питомца изменена.");
            }
        }
    }

    /**
     * Удаляет клиента
     */
    public void deleteClientExec() throws UserException {
        Client client  = findClient();

        if (client == null) {
            throw new UserException("Клиент с таким именем не найден.");
        }
        else {
            clinic.deleteClient(client);
            System.out.println("Клиент удален.");
        }
    }

    /**
     * Удаляет питомца
     */
    public void deletePetExec() throws UserException {
        Client client = findClient();

        if (client == null) {
            throw new UserException("Клиент с таким именем не найден.");
        }
        else {
            String petName = getUserWordAnswer("Введите кличку питомца:");

            Pet pet = client.getPet(petName);
            if (pet == null) {
                throw new UserException("Питомец с такой кличкой не найден.");
            }
            else {
                client.deletePet(petName);
                System.out.println("Питомец удален.");
            }
        }
    }

    public static void main(String[] args) {
        InteractRunner interactRunner = new InteractRunner(new Scanner(System.in));
        interactRunner.runExec();
    }
}
