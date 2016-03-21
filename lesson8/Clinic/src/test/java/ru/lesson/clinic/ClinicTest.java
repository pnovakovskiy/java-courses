package ru.lesson.clinic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClinicTest {
    private Clinic clinic;

    @Before
    public void setUp() throws Exception {
        clinic = new Clinic();
        clinic.addClient(new Client("Павел"));
        clinic.addClient(new Client("Sam"));
    }

    @Test
    public void testAddClient() throws Exception {
        clinic.addClient(new Client("Роман"));
        Assert.assertNotNull(clinic.getClient("Роман"));
    }

    @Test
    public void testDeleteClient() throws Exception {
        clinic.deleteClient(clinic.getClient("Павел"));
        Assert.assertNull(clinic.getClient("Павел"));
    }

    @Test
    public void testGetClient() throws Exception {
        Assert.assertNotNull(clinic.getClient("Sam"));
    }
}