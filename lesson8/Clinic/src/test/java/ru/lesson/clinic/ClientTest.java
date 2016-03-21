package ru.lesson.clinic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClientTest {

    private Client client;

    @Before
    public void setUp() throws Exception {
        client = new Client("Павел");
        client.addPet(new Dog("Шарик"));
        client.addPet(new Cat("Мурка"));
        client.addPet(new Cat("Шкурка"));
    }

    @Test
    public void testSetId() throws Exception {
        client.setId("Жора");
        Assert.assertTrue(client.getID().equals("Жора"));
        Assert.assertFalse(client.getID().equals("Павел"));
    }

    @Test
    public void testDeletePet() throws Exception {
        client.deletePet("Шкурка");
        Assert.assertNull(client.getPet("Шкурка"));
    }

    @Test
    public void testGetPet() throws Exception {
        Assert.assertNotNull(client.getPet("Шарик"));
        Assert.assertNull(client.getPet("Бобик"));
    }

    @Test
    public void testCanAddPet() throws Exception {
        Assert.assertFalse("Животное с такой кличкой уже есть у клиента", client.canAddPet("Шарик"));
        Assert.assertTrue("Животное с такой кличкой можно добавить клиенту", client.canAddPet("Балбес"));
    }

    @Test (expected = UserException.class)
    public void testAddPet() throws UserException {
        client.addPet(new Dog("Шарик"));
    }
}