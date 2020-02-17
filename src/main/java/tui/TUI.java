package tui;

import exceptions.DALException;
import users.UserDAO;
import users.UserDTO;

import java.util.List;
import java.util.Scanner;

public class TUI {
    private Scanner scan = new Scanner(System.in);
    private String[] options = {"Opret ny bruger","List Brugere","Ret bruger","Slet bruger","Afslut program"};
    private UserDTO dto;
    private UserDAO dao;

    public TUI(UserDAO dao){
        this.dao = dao;
    }

    public void showMenu() {
        for (int i = 0; i < options.length; i++) {
            System.out.println(i + 1 + ". " + options[i]);
        }
        System.out.print("Hvad vil du vælge (nummer): ");
        int brugerValg = scan.nextInt();
        while (brugerValg < 1 || brugerValg > 6) {
            System.out.print("Incorrect input. Choose the preferred action (1-5): ");
            brugerValg = scan.nextInt();
        }

        switch (brugerValg) {
            case 1: {
                opretNyBruger();
                break;
            }
            case 2: {
                listBrugere();
                break;
            }
            case 3: {
                retBruger();
                break;
            }
            case 4: {
                sletBruger();
                break;
            }
            case 5: {
                afslutProgram();
                break;
            }
        }
    }


    public void opretNyBruger() {
        try {
            System.out.print("Indtast et brugerID: ");
            int userID = scan.nextInt();
            this.dto.setUserId(userID);
            System.out.print("Indtast et brugernavn: ");
            String userName = scan.next();
            this.dto.setUserName(userName);
            System.out.print("Indtast et ini nummer: ");
            String ini = scan.next();
            this.dto.setIni(ini);
            dao.createUser(this.dto);
        }catch (DALException d){d.getMessage(); d.printStackTrace();}
    }

    public void listBrugere(){
        try {
            for (int i = 0; i < dao.getUserList().size(); i++) {
                System.out.println(dao.getUser(i).toString());
            }
        }catch (DALException d){d.getMessage(); d.printStackTrace();}
    }

    public void retBruger(){
        try {
            for (int i = 0; i < dao.getUserList().size(); i++) {
                System.out.println(i + 1 + ": " + dao.getUser(i).getUserName());
            }
            int valg = scan.nextInt();
            dao.updateUser(dao.getUser(valg));
        }catch (DALException d){d.getMessage(); d.printStackTrace();}
    }

    public void sletBruger(){
        try {
            for (int i = 0; i < dao.getUserList().size(); i++) {
                System.out.println(i + 1 + ": " + dao.getUser(i).getUserName());
            }
            int valg = scan.nextInt();
            dao.deleteUser(dao.getUser(valg).getUserId());
        }catch (DALException d){d.getMessage(); d.printStackTrace();}
    }

    public void afslutProgram(){
        System.out.println("Programmet lukker nu ned!");
        System.exit(0);
    }
}
