import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Класс, описывающий клинику
 */
public class Clinic {
    private int clientsCount = 0;
    /**
     * Список клиентов
     */
    private final List<Client> clients;

    /**
     * Конструктор класса
     */
    public Clinic() {
        clients = new <Client>ArrayList();
    }

    /**
     * Добавить клиента
     * @param client Клиент
     */
    public void addClient(final Client client) {
        clients.add(client);
    }



    //private void doAction(final byte actionNamber) {
    //    switch (actionNamber) {
    //        case 1:
    //            addClient(new Client(++clientsCount, ));
    //    }
    //}

    /*
    public static void main(String[] args) {
        //выбранное дествие
        byte actionNumber = 0;

        Clinic clinic = new Clinic();

        try (Scanner sc = new Scanner(System.in)) {

            //пока не выберут "Выйти из программы"
            do {
                clinic.printMainMenu();
                actionNumber = sc.nextByte();
            } while (actionNumber != 9);
        }
    }
    */
}
