import java.util.ArrayList;
import java.util.List;

/**
 * Класс, описывающий клиента ветеринарной клиники
 */
public class Client {
    /**
     * Идентификатор клиента
     */
    private String id;

    /**
     *Домашний питомец клиента
     */
    private final List<Pet> pets;

    /**
     * Конструктор класса
     * @param id Идентификатор клиента
     */
    public Client(String id) {
        this.id = id;
        this.pets = new <Pet>ArrayList();
    }

    /**
     * Меняет идентификатор клиента
     * @param id идентификатор клинета
     */
    public void setId(final String id) {
        this.id = id;
    }

    public String getID() {
        return id;
    }

    /**
     * Удаляет домашнего питомца у клиента
     * @param name кличка удаляемого питомца
     */
    public void deletePet(final String name) {
        for (int i = 0; i < pets.size(); i++) {
            if (name.equalsIgnoreCase(pets.get(i).getName())) {
                pets.remove(i);
            }
        }
    }

    /**
     * Возвращает домашнего питомца клиента
     * @param name кличка питомца
     * @return Pet найденный питомец
     */
    public Pet getPet(final String name) {
        Pet foundPet = null;
        for (int i = 0; i < pets.size(); i++) {
            if (name.equalsIgnoreCase(pets.get(i).getName())) {
                foundPet = pets.get(i);
                break;
            }
        }
        return foundPet;
    }

    /**
     * Проверяе, что питомец с переданной кличкой уже есть у клиента
     * @param name проверяемая кличка
     * @return boolean истина или ложь
     */
    private boolean canAddPet(final String name) {
        boolean canAdd = true;
        for (int i = 0; i < pets.size(); i++) {
            if (name.equalsIgnoreCase(pets.get(i).getName())) {
                canAdd = false;
                break;
            }
        }
        return canAdd;
    }

    /**
     * Добавляет домашнего питомца клиенту
     * @param pet Домашний питомец
     */
    public void addPet(Pet pet) throws DuplicateNameException {
        if (canAddPet(pet.getName())) {
            pets.add(pet);
        }
        else {
            throw new DuplicateNameException("Питомец с указанной кличкой уже есть у клиента.");
        }
    }
}
