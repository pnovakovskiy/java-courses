package ru.lesson.clinic;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

public class InteractRunnerTest {

    @Test
    public void getUserWordAnswerTest() throws Exception {
        String str = "99\n";
        InteractRunner interactRunner = new InteractRunner(new Scanner(str));
        Assert.assertTrue(interactRunner.getUserWordAnswer("Сколько тебе лет?").equals("99"));
    }

    @Test
    public void runExecTest() throws Exception {
        String str = "1\nЕгор\n9\nЖора\n";
        InteractRunner interactRunner  = new InteractRunner(new Scanner(str));
        interactRunner.runExec();
        Assert.assertNull(interactRunner.findClient());
    }

    @Test
    public void addNewClientExecTest() throws Exception {
        String str = "Егор\nЕгор\n";
        InteractRunner interactRunner  = new InteractRunner(new Scanner(str));
        interactRunner.addNewClientExec();
        Assert.assertNotNull(interactRunner.findClient());
    }

    @Test
    public void addNewPetTest() throws Exception {
        String str = "кошка\nмурка\nсобака\nшарик\n";
        InteractRunner interactRunner = new InteractRunner(new Scanner(str));
        Assert.assertNotNull(interactRunner.addNewPet());
    }

    @Test
    public void addNewPetToClientExecTest() throws Exception {
        String str = "Егор\nЕгор\nсобака\nбобик\nЕгор\n";
        InteractRunner interactRunner = new InteractRunner(new Scanner(str));
        interactRunner.addNewClientExec();
        interactRunner.addNewPetToClientExec();
        Assert.assertNotNull(interactRunner.findClient().getPet("бобик"));
    }

    @Test
    public void findClientTest() throws Exception {
        String str = "Иннокентий\n";
        InteractRunner interactRunner  = new InteractRunner(new Scanner(str));
        Assert.assertNull(interactRunner.findClient());
    }

    @Test
    public void changeClientNameExecTest() {
        String str = "Иннокентий\nИннокентий\nМихаил\nИннокентий\nМихаил\n";
        InteractRunner interactRunner  = new InteractRunner(new Scanner(str));
        interactRunner.addNewClientExec();
        interactRunner.changeClientNameExec();
        Assert.assertNull(interactRunner.findClient());
        Assert.assertNotNull(interactRunner.findClient());
    }

    @Test
    public void changePetNameExecTest() {
        String str = "Иннокентий\nИннокентий\nсобака\nбобик\nИннокентий\nбобик\nОгрызок\nИннокентий\nИннокентий\n";
        InteractRunner interactRunner  = new InteractRunner(new Scanner(str));
        interactRunner.addNewClientExec();
        interactRunner.addNewPetToClientExec();
        interactRunner.changePetNameExec();
        Assert.assertNull(interactRunner.findClient().getPet("бобик"));
        Assert.assertNotNull(interactRunner.findClient().getPet("огрызок"));
    }

    @Test
    public void deleteClientExecTest() {
        String str = "Егор\nЕгор\nЕгор\nЕгор\n";
        InteractRunner interactRunner  = new InteractRunner(new Scanner(str));
        interactRunner.addNewClientExec();
        Assert.assertNotNull(interactRunner.findClient());
        interactRunner.deleteClientExec();
        Assert.assertNull(interactRunner.findClient());
    }

    @Test
    public void deletePetExec() {
        String str = "Егор\nЕгор\nсобака\nбобик\nЕгор\nЕгор\nбобик\nЕгор\n";
        InteractRunner interactRunner = new InteractRunner(new Scanner(str));
        interactRunner.addNewClientExec();
        interactRunner.addNewPetToClientExec();
        Assert.assertNotNull(interactRunner.findClient().getPet("бобик"));
        interactRunner.deletePetExec();
        Assert.assertNull(interactRunner.findClient().getPet("бобик"));
    }
}