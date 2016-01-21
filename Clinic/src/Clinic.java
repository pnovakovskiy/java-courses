import java.util.ArrayList;
import java.util.List;

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

    /**
     * Поиск клиента по имени
     * @param name имя
     * @return клиент
     */
    public Client getClient(final String name) {
        Client client = null;
        for (int i = 0; i < clients.size(); i++) {
            if (name.equalsIgnoreCase(clients.get(i).getID())) {
                client = clients.get(i);
                break;
            }
        }
        return client;
    }
}
