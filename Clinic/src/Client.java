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
    private Pet pet;

    /**
     * КОнструктор класса
     * @param id Идентификатор клиента
     * @param pet Домашний питомец клиента
     */
    public Client(String id, Pet pet) {
        this.id = id;
        this.pet = pet;
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
     */
    public void deletePet() {
        this.pet = null;
    }

    /**
     * Возвращает домашнего питомца клиента
     * @return Pet
     */
    public Pet getPet() {
        return pet;
    }

    /**
     * Добавляет домашнего питомца клиенту
     * @param pet Домашний питомец
     */
    public void addPet(Pet pet) {
        this.pet = pet;
    }
}
