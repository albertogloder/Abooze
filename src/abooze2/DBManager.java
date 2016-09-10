/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package abooze2;

import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

/**
 *
 * @author Alberto Gloder Mike Liutic
 */
public class DBManager {

    BufferedReader br;
    final String database;
    int fileLength = 0;

    public DBManager() throws FileNotFoundException, IOException {
        database = "database/db.txt";
        setFileLength();
    }
    

    public String randomLine() throws FileNotFoundException, IOException {
        int i = (int)(Math.random()*getFileLength());
        br = new BufferedReader(new FileReader(database));
        for (int j = 1; j <= i; j++) {
            br.readLine();
        }
        return br.readLine();
    }
    
    public LinkedList<String> mySearch(String[] Ingredients) throws FileNotFoundException, IOException{
        LinkedList<String> result = new LinkedList<String>();
        br = new BufferedReader(new FileReader(database));
        String sRigaCorrente;
        boolean alreadyIns;
        while ((sRigaCorrente = br.readLine()) != null) {
            alreadyIns = false;
            String[] temp = sRigaCorrente.split(";")[1].split(",");
            for (String currentIng : temp) {
                if(!alreadyIns){
                    for (String Ingredient : Ingredients) {
                        if(currentIng.toLowerCase().equals(Ingredient.toLowerCase())){
                            result.add(sRigaCorrente);
                            alreadyIns = true;
                            break; //Non aggiungo doppioni
                        }
                    }
                }
            }
        }
        return result;
    }
    
    public String byName(String name) throws FileNotFoundException, IOException {
        System.out.println("Nome: " + name);
        br = new BufferedReader(new FileReader(database));
        String sRigaCorrente;
        while ((sRigaCorrente = br.readLine()) != null) {
            String temp = sRigaCorrente.split(";")[0];
            if(temp.toLowerCase().equals(name.toLowerCase())){
                return sRigaCorrente;
            }
        }
        return null;
    }
    

    public void addNew(String newline) throws IOException {
        String[] splittedNL = newline.split(";");
        String sRigaCorrente;
        boolean controller = true;
        while ((sRigaCorrente = br.readLine()) != null) {
            String temp = sRigaCorrente.split(";")[0];
            if (temp.toLowerCase().equals(splittedNL[0].toLowerCase())){
                controller = false;
                break;
            }
        }
        fileLength++;
        if(controller){
            try {
                PrintWriter pw = new PrintWriter(new FileWriter(database, true));
                pw.append(System.getProperty("line.separator") + newline);
                pw.flush();
            } catch (IOException e) {
                System.out.println("Errore IO: " + e.getMessage());
            }
        }
    }

    public void setFileLength() throws FileNotFoundException, IOException {
        br = new BufferedReader(new FileReader(database));
        while (br.readLine() != null) {
            fileLength++;
            System.out.println("File Length: " + fileLength);
        }
    }

    public int getFileLength() {
        return fileLength;
    }
  
}