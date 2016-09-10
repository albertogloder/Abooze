/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package abooze2;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;

/**
 *
 * @author Alberto Gloder Mike Liutic
 */
public class Abooze2 extends JFrame 
{

    JPanel jPmenu;
    JPanel jPmySearchPage;
    JPanel jPaddNewPage;
    JPanel jPaboutPage;
    JPanel jPerrorPage;
    JPanel jPrandomPage;
    JPanel jPbyNameSearchPage;
    //Per il menu
    JButton jBmySearch;
    JButton jBaddNew;
    JButton jBbyName;
    JButton jBrandom;
    JButton jBabout;
    //Per la mySearchpage
    JLabel jLmSTitle;
    JTextArea jTAmSResearch;
    JLabel jLmStick;
    JButton jBmSSubmit;
    JLabel jLmSName;
    JLabel jLmSNameResult;
    JLabel jLmSIngredients;
    JLabel jLmSIngredientsResult;
    JLabel jLmSAbout;
    JLabel jLmSAboutResult;
    JLabel jLmSDifficulty;
    //I pallini neri e verdi della difficulty
    JLabel jLmSDifficulty1;
    JLabel jLmSDifficulty2;
    JLabel jLmSDifficulty3;
    JLabel jLmSDifficulty4;
    JLabel jLmSDifficulty5;
    JButton jBprevious;
    JButton jBnext;
    JLabel jLpageNumber;
    JButton jBmSneverMind;
    //Per la byNamepage
    JLabel jLbNTitle;
    JTextArea jTAbNResearch;
    JLabel jLbNtick;
    JButton jBbNSubmit;
    JLabel jLbNName;
    JLabel jLbNNameResult;
    JLabel jLbNIngredients;
    JLabel jLbNIngredientsResult;
    JLabel jLbNAbout;
    JLabel jLbNAboutResult;
    JLabel jLbNDifficulty;
    //I pallini neri e verdi della difficulty
    JLabel jLbNDifficulty1;
    JLabel jLbNDifficulty2;
    JLabel jLbNDifficulty3;
    JLabel jLbNDifficulty4;
    JLabel jLbNDifficulty5;
    JButton jBbNneverMind;
    //Per la randomPage
    JLabel jLrTitle;
    JLabel jLrName;
    JLabel jLrNameResult;
    JLabel jLrIngredients;
    JLabel jLrIngredientsResult;
    JLabel jLrAbout;
    JLabel jLrAboutResult;
    JLabel jLrDifficulty;
    JLabel jLrDifficulty1;
    JLabel jLrDifficulty2;
    JLabel jLrDifficulty3;
    JLabel jLrDifficulty4;
    JLabel jLrDifficulty5;
    JButton jBrneverMind;
    //Per l'addnew
    JLabel jLaNTitle;
    JLabel jLaNTickName;
    JLabel jLaNTickIngredients;
    JLabel jLaNTickAbout;
    JLabel jLaNTickDifficulty;
    JLabel jLaNName;
    JTextArea jTAaNNameInput;
    JLabel jLaNIngredients;
    JTextArea jTAaNIngredientsInput;
    JLabel jLaNAbout;
    JTextArea jTAaNAboutInput;
    JLabel jLaNDifficulty;
    JTextArea jTAaNDifficultyInput;
    JButton jBaNneverMind;
    JButton jBaNSubmit;
    int counter;
    //Per aboutPage
    JLabel jLaboutTitle;
    JLabel jLaboutPage;
    JButton jBAboutNeverMind;
    
    //Per error Page
    JLabel jLerrorTitle;
    JLabel jLerrorPage;
    JButton jBerrorNeverMind;
    
    //Altri
    Font font = new Font("Myriad Pro", Font.PLAIN, 16);
    DBManager db;
    LinkedList<String> queryMs;
    String query;
    //Per il controllo
    int pageDisplayed = 0; //0-menu 1-mysearch 2-addnew 3-byname 4-random 5-about

    public Abooze2() throws FileNotFoundException, IOException 
    {
        initComponents();
    }
    
    //MACRO GUI COMP
    private void initComponents() throws FileNotFoundException, IOException 
    {
        db = new DBManager();
        jPmenu = new JPanel();
        jPmenu.setLayout(null);
        jPmenu.setBounds(0, 0, 215, 320);
        jPmenu.setBackground(new java.awt.Color(255, 255, 255));

        jBmySearch = new JButton(new ImageIcon("images/mysearch.png"));
        jBmySearch.setBounds(5, 5, 100, 100);
        jBmySearch.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                mySearchPage();             //<--- RESULT
            }
        });

        jBaddNew = new JButton(new ImageIcon("images/addnew.png"));
        jBaddNew.setBounds(110, 5, 100, 100);
        jBaddNew.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                addNewPage();               //<--- ADD NEW
            }
        });

        jBbyName = new JButton(new ImageIcon("images/byname.png"));
        jBbyName.setBounds(5, 110, 100, 100);
        jBbyName.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                byNamePage();               //<--- BY NAME S
            }
        });

        jBrandom = new JButton(new ImageIcon("images/random.png"));
        jBrandom.setBounds(110, 110, 100, 205);
        jBrandom.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                try 
                {
                    randomPage();           //<--- RANDOM S
                } 
                catch (FileNotFoundException ex) 
                {
                    Logger.getLogger(Abooze2.class.getName()).log(Level.SEVERE, null, ex);
                } 
                catch (IOException ex) 
                {
                    Logger.getLogger(Abooze2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        jBabout = new JButton(new ImageIcon("images/about.png"));
        jBabout.setBounds(5, 215, 100, 100);
        jBabout.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                aboutPage();                //ABOUT
            }
        });
            //ADDING BUTTONS TO MENU PANEL
        jPmenu.add(jBmySearch);
        jPmenu.add(jBaddNew);
        jPmenu.add(jBbyName);
        jPmenu.add(jBrandom);
        jPmenu.add(jBabout);
        
            //ERRORPAGE
        jPerrorPage = new JPanel();
        jPerrorPage.setLayout(null);
        jPerrorPage.setBounds(0, 0, 215, 320);
        jPerrorPage.setBackground(new java.awt.Color(255, 255, 255));

        jLerrorTitle = new JLabel(new ImageIcon("images/errortitle.png"));
        jLerrorTitle.setBounds(5, 5, 205, 50);

        jLerrorPage = new JLabel(new ImageIcon("images/errorpage.png"));
        jLerrorPage.setBounds(5, 60, 205, 224);

        jBerrorNeverMind = new JButton(new ImageIcon("images/nevermind.png"));
        jBerrorNeverMind.setBorder(null);
        jBerrorNeverMind.setBounds(5, 280, 205, 25);
        jBerrorNeverMind.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                menuPage();
            }
        });

        jPerrorPage.add(jLerrorTitle);
        jPerrorPage.add(jLerrorPage);
        
        //MY SEARCH (INGREDIENT)

        jPmySearchPage = new JPanel();
        jPmySearchPage.setLayout(null);
        jPmySearchPage.setBounds(0, 0, 215, 320);
        jPmySearchPage.setBackground(new java.awt.Color(255, 255, 255));

        jLmSTitle = new JLabel(new ImageIcon("images/mysearchtitle.png"));
        jLmSTitle.setBounds(5, 5, 205, 50);

        jTAmSResearch = new JTextArea("Type the ingredient");
        jTAmSResearch.setBounds(5, 155, 205, 50);
        jTAmSResearch.setFont(font);
        jTAmSResearch.addKeyListener(new KeyListener() 
        {
            @Override
            public void keyTyped(KeyEvent e) 
            {
            }

            @Override
            public void keyPressed(KeyEvent e) 
            {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) 
                {
                    if (jTAmSResearch.getText().length() > 0) 
                    {
                        jTAmSResearch.setEditable(false);
                        jLmStick.setVisible(true);      // user's soft confirm(enter)
                        jBmSSubmit.setEnabled(true);
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e)
            {
            }
        });

        jLmStick = new JLabel(new ImageIcon("images/tick.png"));    //tick for enter pressed
        jLmStick.setBounds(97, 210, 20, 20);
        jLmStick.setFont(font);

        jLmSName = new JLabel("Name");
        jLmSName.setBounds(5, 60, 205, 20);
        jLmSName.setFont(font);
        jLmSName.setForeground(Color.GRAY);

        jLmSNameResult = new JLabel();
        jLmSNameResult.setBounds(5, 85, 205, 20);
        jLmSNameResult.setFont(font);

        jLmSIngredients = new JLabel("Ingredients");
        jLmSIngredients.setBounds(5, 110, 205, 20);
        jLmSIngredients.setFont(font);
        jLmSIngredients.setForeground(Color.GRAY);

        jLmSIngredientsResult = new JLabel();
        jLmSIngredientsResult.setBounds(5, 135, 205, 20);
        jLmSIngredientsResult.setFont(font);

        jLmSAbout = new JLabel("About");
        jLmSAbout.setBounds(5, 160, 205, 20);
        jLmSAbout.setFont(font);
        jLmSAbout.setForeground(Color.GRAY);
        
        jLmSAboutResult = new JLabel();
        jLmSAboutResult.setBounds(5, 185, 205, 20);
        jLmSAboutResult.setFont(font);

        jLmSDifficulty = new JLabel("Difficulty");
        jLmSDifficulty.setBounds(5, 210, 205, 20);
        jLmSDifficulty.setFont(font);
        jLmSDifficulty.setForeground(Color.GRAY);

        jLmSDifficulty1 = new JLabel(new ImageIcon("images/blackcircle.png"));
        jLmSDifficulty1.setBounds(5, 235, 10, 10);

        jLmSDifficulty2 = new JLabel(new ImageIcon("images/blackcircle.png"));
        jLmSDifficulty2.setBounds(20, 235, 10, 10);

        jLmSDifficulty3 = new JLabel(new ImageIcon("images/blackcircle.png"));
        jLmSDifficulty3.setBounds(35, 235, 10, 10);

        jLmSDifficulty4 = new JLabel(new ImageIcon("images/blackcircle.png"));
        jLmSDifficulty4.setBounds(50, 235, 10, 10);

        jLmSDifficulty5 = new JLabel(new ImageIcon("images/blackcircle.png"));
        jLmSDifficulty5.setBounds(65, 235, 10, 10);

        jBprevious = new JButton(new ImageIcon("images/previous.png"));     //freccette
        jBprevious.setBounds(50, 250, 15, 17);
        jBprevious.setBorder(null);
        jBprevious.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                previousResult();
            }
        });

        jLpageNumber = new JLabel();
        jLpageNumber.setBounds(97, 250, 40, 20);
        jLpageNumber.setFont(font);

        jBnext = new JButton(new ImageIcon("images/next.png"));             //freccette
        jBnext.setBounds(150, 250, 15, 17);
        jBnext.setBorder(null);
        jBnext.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                nextResult();
            }
        });



                    //SUBMIT BUTTON - COMMON
        jBmSSubmit = new JButton(new ImageIcon("images/submit.png"));
        jBmSSubmit.setBounds(5, 250, 205, 25);
        jBmSSubmit.setBorder(null);
        jBmSSubmit.setEnabled(false);
        jBmSSubmit.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                try {
                    mySearchSubmit();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Abooze2.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Abooze2.class.getName()).log(Level.SEVERE, null, ex);
                }                 
            }
            
        });


        jBmSneverMind = new JButton(new ImageIcon("images/nevermind.png"));
        jBmSneverMind.setBorder(null);
        jBmSneverMind.setBounds(5, 280, 205, 25);
        jBmSneverMind.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                clearContent();
                menuPage();
            }
        });


        jPmySearchPage.add(jLmSTitle);
        jPmySearchPage.add(jTAmSResearch);
        jPmySearchPage.add(jBmSSubmit);

        //All'inizio sono disabilitate
        jPmySearchPage.add(jLmStick).setVisible(false);
        jPmySearchPage.add(jLmSName).setVisible(false);
        jPmySearchPage.add(jLmSNameResult).setVisible(false);
        jPmySearchPage.add(jLmSIngredients).setVisible(false);
        jPmySearchPage.add(jLmSIngredientsResult).setVisible(false);
        jPmySearchPage.add(jLmSAbout).setVisible(false);
        jPmySearchPage.add(jLmSAboutResult).setVisible(false);
        jPmySearchPage.add(jLmSDifficulty).setVisible(false);
        jPmySearchPage.add(jLmSDifficulty1).setVisible(false);
        jPmySearchPage.add(jLmSDifficulty2).setVisible(false);
        jPmySearchPage.add(jLmSDifficulty3).setVisible(false);
        jPmySearchPage.add(jLmSDifficulty4).setVisible(false);
        jPmySearchPage.add(jLmSDifficulty5).setVisible(false);
        jPmySearchPage.add(jBprevious).setVisible(false);
        jPmySearchPage.add(jLpageNumber).setVisible(false);
        jPmySearchPage.add(jBnext).setVisible(false);






        //ADD NEW PAGE

        counter = 0;

        jPaddNewPage = new JPanel();
        jPaddNewPage.setLayout(null);
        jPaddNewPage.setBounds(0, 0, 215, 320);
        jPaddNewPage.setBackground(new java.awt.Color(255, 255, 255));

        jLaNTitle = new JLabel(new ImageIcon("images/addnewtitle.png"));
        jLaNTitle.setBounds(5, 5, 205, 50);



        jLaNName = new JLabel("Name");              //NAME
        jLaNName.setBounds(5, 60, 205, 20);
        jLaNName.setFont(font);
        jLaNName.setForeground(Color.GRAY);

        jTAaNNameInput = new JTextArea();           //NAME INPUT
        jTAaNNameInput.setBounds(5, 85, 185, 20);
        jTAaNNameInput.setFont(font);
        jTAaNNameInput.requestFocus();
        jTAaNNameInput.addKeyListener(new KeyListener() 
        {
            @Override
            public void keyTyped(KeyEvent e) 
            {
            }

            @Override
            public void keyPressed(KeyEvent e) 
            {                
                if (e.getKeyCode() == KeyEvent.VK_ENTER) 
                {
                    if (jTAaNNameInput.getText().length() > 0 && jTAaNNameInput.getText().length() <= 15) {
                        jTAaNNameInput.setEditable(false);
                        jLaNTickName.setVisible(true);
                        ++counter;
                        if (counter == 4) {
                            jBaNSubmit.setEnabled(true);
                        }
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) 
            {
            }
        });

        jLaNTickName = new JLabel(new ImageIcon("images/tick.png"));
        jLaNTickName.setBounds(190, 85, 20, 20);

        jLaNIngredients = new JLabel("Ingredients");
        jLaNIngredients.setBounds(5, 110, 205, 20);
        jLaNIngredients.setFont(font);
        jLaNIngredients.setForeground(Color.GRAY);

        jTAaNIngredientsInput = new JTextArea();
        jTAaNIngredientsInput.setBounds(5, 135, 185, 20);
        jTAaNIngredientsInput.setFont(font);
        jTAaNIngredientsInput.addKeyListener(new KeyListener() 
        {
            @Override
            public void keyTyped(KeyEvent e) 
            {
            }

            @Override
            public void keyPressed(KeyEvent e) 
            {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) 
                {
                    if (jTAaNIngredientsInput.getText().length() > 0) 
                    {
                        jTAaNIngredientsInput.setEditable(false);
                        jLaNTickIngredients.setVisible(true);
                        ++counter;
                        if (counter == 4) 
                        {
                            jBaNSubmit.setEnabled(true);
                        }
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) 
            {
            }
        });

        jLaNTickIngredients = new JLabel(new ImageIcon("images/tick.png"));
        jLaNTickIngredients.setBounds(190, 135, 20, 20);

        jLaNAbout = new JLabel("About");
        jLaNAbout.setBounds(5, 160, 205, 20);
        jLaNAbout.setFont(font);
        jLaNAbout.setForeground(Color.GRAY);

        jTAaNAboutInput = new JTextArea();
        jTAaNAboutInput.setBounds(5, 185, 185, 20);
        jTAaNAboutInput.setFont(font);
        jTAaNAboutInput.addKeyListener(new KeyListener() 
        {
            @Override
            public void keyTyped(KeyEvent e) 
            {
            }

            @Override
            public void keyPressed(KeyEvent e) 
            {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) 
                {
                    if (jTAaNAboutInput.getText().length() > 0) 
                    {
                        jTAaNAboutInput.setEditable(false);
                        jLaNTickAbout.setVisible(true);
                        ++counter;
                        if (counter == 4) 
                        {
                            jBaNSubmit.setEnabled(true);
                        }
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) 
            {
            }
        });

        jLaNTickAbout = new JLabel(new ImageIcon("images/tick.png"));
        jLaNTickAbout.setBounds(190, 185, 20, 20);

        jLaNDifficulty = new JLabel("Difficulty");
        jLaNDifficulty.setBounds(5, 210, 205, 20);
        jLaNDifficulty.setFont(font);
        jLaNDifficulty.setForeground(Color.GRAY);

        jTAaNDifficultyInput = new JTextArea();
        jTAaNDifficultyInput.setBounds(5, 232, 185, 20);
        jTAaNDifficultyInput.setFont(font);
        jTAaNDifficultyInput.addKeyListener(new KeyListener() 
        {
            @Override
            public void keyTyped(KeyEvent e) 
            {
            }

            @Override
            public void keyPressed(KeyEvent e) 
            {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) 
                {
                    if (jTAaNDifficultyInput.getText().length() > 0) {
                        jTAaNDifficultyInput.setEditable(false);
                        jLaNTickDifficulty.setVisible(true);
                        ++counter;
                        if (counter == 4) 
                        {
                            jBaNSubmit.setEnabled(true);
                        }
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        jLaNTickDifficulty = new JLabel(new ImageIcon("images/tick.png"));
        jLaNTickDifficulty.setBounds(190, 232, 20, 20);


        jBaNSubmit = new JButton(new ImageIcon("images/submit.png"));
        jBaNSubmit.setBounds(5, 255, 205, 25);
        jBaNSubmit.setBorder(null);
        jBaNSubmit.setEnabled(false);
        jBaNSubmit.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                try {
                    addNewSubmit();
                } catch (FileNotFoundException ex) 
                {
                    Logger.getLogger(Abooze2.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) 
                {
                    Logger.getLogger(Abooze2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });


        jBaNneverMind = new JButton(new ImageIcon("images/nevermind.png"));
        jBaNneverMind.setBorder(null);
        jBaNneverMind.setBounds(5, 280, 205, 25);
        jBaNneverMind.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                menuPage();
            }
        });


        jPaddNewPage.add(jLaNTitle);

        jPaddNewPage.add(jLaNName);
        jPaddNewPage.add(jTAaNNameInput);
        jPaddNewPage.add(jLaNIngredients);
        jPaddNewPage.add(jTAaNIngredientsInput);
        jPaddNewPage.add(jLaNAbout);
        jPaddNewPage.add(jTAaNAboutInput);
        jPaddNewPage.add(jLaNDifficulty);
        jPaddNewPage.add(jTAaNDifficultyInput);

        jPaddNewPage.add(jLaNTickName).setVisible(false);
        jPaddNewPage.add(jLaNTickIngredients).setVisible(false);
        jPaddNewPage.add(jLaNTickAbout).setVisible(false);
        jPaddNewPage.add(jLaNTickDifficulty).setVisible(false);

        jPaddNewPage.add(jBaNSubmit);



        //BY NAME PAGE

        jPbyNameSearchPage = new JPanel();
        jPbyNameSearchPage.setLayout(null);
        jPbyNameSearchPage.setBounds(0, 0, 215, 320);
        jPbyNameSearchPage.setBackground(new java.awt.Color(255, 255, 255));

        jLbNTitle = new JLabel(new ImageIcon("images/bynametitle.png"));
        jLbNTitle.setBounds(5, 5, 205, 50);


        jTAbNResearch = new JTextArea("Type name of Drink");
        jTAbNResearch.setBounds(5, 155, 205, 50);
        jTAbNResearch.setFont(font);
        jTAbNResearch.addKeyListener(new KeyListener() 
        {
            @Override
            public void keyTyped(KeyEvent e) 
            {
            }

            @Override
            public void keyPressed(KeyEvent e) 
            {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) 
                {
                    if (jTAbNResearch.getText().length() > 0 && jTAbNResearch.getText().length() <= 15) 
                    {
                        jTAbNResearch.setEditable(false);
                        jLbNtick.setVisible(true);
                        jBbNSubmit.setEnabled(true);
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) 
            {
            }
        });

        jLbNtick = new JLabel(new ImageIcon("images/tick.png"));
        jLbNtick.setBounds(97, 210, 20, 20);
        jLbNtick.setFont(font);

        jLbNName = new JLabel("Name");
        jLbNName.setBounds(5, 60, 205, 20);
        jLbNName.setFont(font);
        jLbNName.setForeground(Color.GRAY);


        jLbNNameResult = new JLabel();
        jLbNNameResult.setBounds(5, 85, 205, 20);
        jLbNNameResult.setFont(font);

        jLbNIngredients = new JLabel("Ingredients");
        jLbNIngredients.setBounds(5, 110, 205, 20);
        jLbNIngredients.setFont(font);
        jLbNIngredients.setForeground(Color.GRAY);

        jLbNIngredientsResult = new JLabel();
        jLbNIngredientsResult.setBounds(5, 135, 205, 20);
        jLbNIngredientsResult.setFont(font);

        jLbNAbout = new JLabel("About");
        jLbNAbout.setBounds(5, 160, 205, 20);
        jLbNAbout.setFont(font);
        jLbNAbout.setForeground(Color.GRAY);

        jLbNAboutResult = new JLabel();
        jLbNAboutResult.setBounds(5, 185, 205, 20);
        jLbNAboutResult.setFont(font);

        jLbNDifficulty = new JLabel("Difficulty");
        jLbNDifficulty.setBounds(5, 210, 205, 20);
        jLbNDifficulty.setFont(font);
        jLbNDifficulty.setForeground(Color.GRAY);


        jLbNDifficulty1 = new JLabel(new ImageIcon("images/blackcircle.png"));
        jLbNDifficulty1.setBounds(5, 235, 10, 10);

        jLbNDifficulty2 = new JLabel(new ImageIcon("images/blackcircle.png"));
        jLbNDifficulty2.setBounds(20, 235, 10, 10);

        jLbNDifficulty3 = new JLabel(new ImageIcon("images/blackcircle.png"));
        jLbNDifficulty3.setBounds(35, 235, 10, 10);

        jLbNDifficulty4 = new JLabel(new ImageIcon("images/blackcircle.png"));
        jLbNDifficulty4.setBounds(50, 235, 10, 10);

        jLbNDifficulty5 = new JLabel(new ImageIcon("images/blackcircle.png"));
        jLbNDifficulty5.setBounds(65, 235, 10, 10);



        jBbNSubmit = new JButton(new ImageIcon("images/submit.png"));
        jBbNSubmit.setBounds(5, 250, 205, 25);
        jBbNSubmit.setBorder(null);
        jBbNSubmit.setEnabled(false);
        jBbNSubmit.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                try 
                {
                    byNameSubmit();
                } 
                catch (FileNotFoundException ex) 
                {
                    Logger.getLogger(Abooze2.class.getName()).log(Level.SEVERE, null, ex);
                } 
                catch (IOException ex) 
                {
                    Logger.getLogger(Abooze2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });


        jBbNneverMind = new JButton(new ImageIcon("images/nevermind.png"));
        jBbNneverMind.setBorder(null);
        jBbNneverMind.setBounds(5, 280, 205, 25);
        jBbNneverMind.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                clearContent();
                menuPage();
            }
        });

        jPbyNameSearchPage.add(jLbNTitle);
        jPbyNameSearchPage.add(jTAbNResearch);
        jPbyNameSearchPage.add(jBbNSubmit);

        //All'inizio sono disabilitate.
        jPbyNameSearchPage.add(jLbNtick).setVisible(false);
        jPbyNameSearchPage.add(jLbNName).setVisible(false);
        jPbyNameSearchPage.add(jLbNNameResult).setVisible(false);
        jPbyNameSearchPage.add(jLbNIngredients).setVisible(false);
        jPbyNameSearchPage.add(jLbNIngredientsResult).setVisible(false);
        jPbyNameSearchPage.add(jLbNAbout).setVisible(false);
        jPbyNameSearchPage.add(jLbNAboutResult).setVisible(false);
        jPbyNameSearchPage.add(jLbNDifficulty).setVisible(false);
        jPbyNameSearchPage.add(jLbNDifficulty1).setVisible(false);
        jPbyNameSearchPage.add(jLbNDifficulty2).setVisible(false);
        jPbyNameSearchPage.add(jLbNDifficulty3).setVisible(false);
        jPbyNameSearchPage.add(jLbNDifficulty4).setVisible(false);
        jPbyNameSearchPage.add(jLbNDifficulty5).setVisible(false);





        //RANDOM PAGE

        jPrandomPage = new JPanel();
        jPrandomPage.setLayout(null);
        jPrandomPage.setBounds(0, 0, 215, 320);
        jPrandomPage.setBackground(new java.awt.Color(255, 255, 255));

        jLrTitle = new JLabel(new ImageIcon("images/randomtitle.png"));
        jLrTitle.setBounds(5, 5, 205, 50);

        jLrName = new JLabel("Name");
        jLrName.setBounds(5, 60, 205, 20);
        jLrName.setFont(font);
        jLrName.setForeground(Color.GRAY);


        jLrNameResult = new JLabel();
        jLrNameResult.setBounds(5, 85, 205, 20);
        jLrNameResult.setFont(font);

        jLrIngredients = new JLabel("Ingredients");
        jLrIngredients.setBounds(5, 110, 205, 20);
        jLrIngredients.setFont(font);
        jLrIngredients.setForeground(Color.GRAY);

        jLrIngredientsResult = new JLabel();
        jLrIngredientsResult.setBounds(5, 135, 205, 20);
        jLrIngredientsResult.setFont(font);

        jLrAbout = new JLabel("About");
        jLrAbout.setBounds(5, 160, 205, 20);
        jLrAbout.setFont(font);
        jLrAbout.setForeground(Color.GRAY);

        jLrAboutResult = new JLabel();
        jLrAboutResult.setBounds(5, 185, 205, 20);
        jLrAboutResult.setFont(font);

        jLrDifficulty = new JLabel("Difficulty");
        jLrDifficulty.setBounds(5, 210, 205, 20);
        jLrDifficulty.setFont(font);
        jLrDifficulty.setForeground(Color.GRAY);

        jLrDifficulty1 = new JLabel(new ImageIcon("images/blackcircle.png"));
        jLrDifficulty1.setBounds(5, 235, 10, 10);

        jLrDifficulty2 = new JLabel(new ImageIcon("images/blackcircle.png"));
        jLrDifficulty2.setBounds(20, 235, 10, 10);

        jLrDifficulty3 = new JLabel(new ImageIcon("images/blackcircle.png"));
        jLrDifficulty3.setBounds(35, 235, 10, 10);

        jLrDifficulty4 = new JLabel(new ImageIcon("images/blackcircle.png"));
        jLrDifficulty4.setBounds(50, 235, 10, 10);

        jLrDifficulty5 = new JLabel(new ImageIcon("images/blackcircle.png"));
        jLrDifficulty5.setBounds(65, 235, 10, 10);



        jBrneverMind = new JButton(new ImageIcon("images/nevermind.png"));
        jBrneverMind.setBorder(null);
        jBrneverMind.setBounds(5, 280, 205, 25);
        jBrneverMind.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                menuPage();
            }
        });

        jPrandomPage.add(jLrTitle);

        jPrandomPage.add(jLrName);
        jPrandomPage.add(jLrNameResult);
        jPrandomPage.add(jLrIngredients);
        jPrandomPage.add(jLrIngredientsResult);
        jPrandomPage.add(jLrAbout);
        jPrandomPage.add(jLrAboutResult);
        jPrandomPage.add(jLrDifficulty);
        jPrandomPage.add(jLrDifficulty1);
        jPrandomPage.add(jLrDifficulty2);
        jPrandomPage.add(jLrDifficulty3);
        jPrandomPage.add(jLrDifficulty4);
        jPrandomPage.add(jLrDifficulty5);




        //ABOUT PAGE


        jPaboutPage = new JPanel();
        jPaboutPage.setLayout(null);
        jPaboutPage.setBounds(0, 0, 215, 320);
        jPaboutPage.setBackground(new java.awt.Color(255, 255, 255));

        jLaboutTitle = new JLabel(new ImageIcon("images/abouttitle.png"));
        jLaboutTitle.setBounds(5, 5, 205, 50);

        jLaboutPage = new JLabel(new ImageIcon("images/aboutpage.png"));
        jLaboutPage.setBounds(5, 60, 205, 224);

        jBAboutNeverMind = new JButton(new ImageIcon("images/nevermind.png"));
        jBAboutNeverMind.setBorder(null);
        jBAboutNeverMind.setBounds(5, 280, 205, 25);
        jBAboutNeverMind.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                menuPage();
            }
        });

        jPaboutPage.add(jLaboutTitle);
        jPaboutPage.add(jLaboutPage);
        
        
        
        
        
        //Final instruction

        jPmySearchPage.add(jBmSneverMind);
        jPaboutPage.add(jBAboutNeverMind);
        jPerrorPage.add(jBerrorNeverMind);
        jPbyNameSearchPage.add(jBbNneverMind);
        jPaddNewPage.add(jBaNneverMind);
        jPrandomPage.add(jBrneverMind);

        //Setto la visibilità a false delle pagine che non devono vedersi all'inizio
        jPaboutPage.setVisible(false);
        jPerrorPage.setVisible(false);
        jPaddNewPage.setVisible(false);
        jPbyNameSearchPage.setVisible(false);
        jPmySearchPage.setVisible(false);
        jPrandomPage.setVisible(false);


        add(jPmenu);
        add(jPmySearchPage);
        add(jPaddNewPage);
        add(jPbyNameSearchPage);
        add(jPrandomPage);
        add(jPaboutPage);
        add(jPerrorPage);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        //Dimensione giusta (215,320)
        setBounds(500, 200, 220, 348);
        setVisible(true);


    }//END INIT

    public void menuPage() 
    {
        jPmenu.setVisible(true);
        jPaboutPage.setVisible(false);
        jPerrorPage.setVisible(false);
        jPaddNewPage.setVisible(false);
        jPbyNameSearchPage.setVisible(false);
        jPmySearchPage.setVisible(false);
        jPrandomPage.setVisible(false);
    }

    public void mySearchPage() 
    {
        jTAmSResearch.setText("Type the ingredient");
        jTAmSResearch.setEditable(true);
        jTAmSResearch.addFocusListener(new FocusListener() 
        {
            @Override
            public void focusGained(FocusEvent e) 
            {
                jTAmSResearch.selectAll();             //<--- TO SELECT ALL THE TEXT
            }
            @Override
            public void focusLost(FocusEvent e) 
            {}
        });
        
        
        jBmSSubmit.setEnabled(false);
        jLmStick.setVisible(false);
        jTAmSResearch.setVisible(true);
        jBmSSubmit.setVisible(true);
        jLmSName.setVisible(false);
        jLmSNameResult.setVisible(false);
        jLmSIngredients.setVisible(false);
        jLmSIngredientsResult.setVisible(false);
        jLmSAbout.setVisible(false);
        jLmSAboutResult.setVisible(false);
        jLmSDifficulty.setVisible(false);
        jLmSDifficulty1.setIcon(new ImageIcon("images/blackcircle.png"));
        jLmSDifficulty2.setIcon(new ImageIcon("images/blackcircle.png"));
        jLmSDifficulty3.setIcon(new ImageIcon("images/blackcircle.png"));
        jLmSDifficulty4.setIcon(new ImageIcon("images/blackcircle.png"));
        jLmSDifficulty5.setIcon(new ImageIcon("images/blackcircle.png"));
        jLmSDifficulty1.setVisible(false);
        jLmSDifficulty2.setVisible(false);
        jLmSDifficulty3.setVisible(false);
        jLmSDifficulty4.setVisible(false);
        jLmSDifficulty5.setVisible(false);
        jBprevious.setVisible(false);
        jLpageNumber.setVisible(false);
        jBnext.setVisible(false);

        jPmenu.setVisible(false);
        jPaboutPage.setVisible(false);
        jPaddNewPage.setVisible(false);
        jPbyNameSearchPage.setVisible(false);
        jPmySearchPage.setVisible(true);
        jPrandomPage.setVisible(false);
    }

    private void addNewPage() 
    {
        jBaNSubmit.setEnabled(false);
        jLaNTickName.setVisible(false);
        jLaNTickIngredients.setVisible(false);
        jLaNTickAbout.setVisible(false);
        jLaNTickDifficulty.setVisible(false);
        jTAaNNameInput.setEditable(true);
        jTAaNIngredientsInput.setEditable(true);
        jTAaNAboutInput.setEditable(true);
        jTAaNDifficultyInput.setEditable(true);
        
        jTAaNNameInput.setText("");
        jTAaNIngredientsInput.setText("");
        jTAaNAboutInput.setText("");
        jTAaNDifficultyInput.setText("");
        
        counter = 0;

        jPmenu.setVisible(false);
        jPaboutPage.setVisible(false);
        jPaddNewPage.setVisible(true);
        jPbyNameSearchPage.setVisible(false);
        jPmySearchPage.setVisible(false);
        jPrandomPage.setVisible(false);
        
        jTAaNNameInput.requestFocus();
    }

    public void byNamePage() 
    {
        jTAbNResearch.setText("Type name of Drink");
        jTAbNResearch.setEditable(true);
        jTAbNResearch.addFocusListener(new FocusListener() 
        {
            @Override
            public void focusGained(FocusEvent e) 
            {
                jTAbNResearch.selectAll();             //<--- TO SELECT ALL THE TEXT
            }
            @Override
            public void focusLost(FocusEvent e) 
            {}
        });
        jBbNSubmit.setEnabled(false);
        jLbNtick.setVisible(false);
        jTAbNResearch.setVisible(true);
        jBbNSubmit.setVisible(true);
        jLbNtick.setVisible(false);
        jLbNName.setVisible(false);
        jLbNNameResult.setVisible(false);
        jLbNIngredients.setVisible(false);
        jLbNIngredientsResult.setVisible(false);
        jLbNAbout.setVisible(false);
        jLbNAboutResult.setVisible(false);
        jLbNDifficulty.setVisible(false);

        jLbNDifficulty1.setIcon(new ImageIcon("images/blackcircle.png"));
        jLbNDifficulty2.setIcon(new ImageIcon("images/blackcircle.png"));
        jLbNDifficulty3.setIcon(new ImageIcon("images/blackcircle.png"));
        jLbNDifficulty4.setIcon(new ImageIcon("images/blackcircle.png"));
        jLbNDifficulty5.setIcon(new ImageIcon("images/blackcircle.png"));

        jLbNDifficulty1.setVisible(false);
        jLbNDifficulty2.setVisible(false);
        jLbNDifficulty3.setVisible(false);
        jLbNDifficulty4.setVisible(false);
        jLbNDifficulty5.setVisible(false);


        jPmenu.setVisible(false);
        jPaboutPage.setVisible(false);
        jPaddNewPage.setVisible(false);
        jPbyNameSearchPage.setVisible(true);
        jPmySearchPage.setVisible(false);
        jPrandomPage.setVisible(false);

    }

    public void randomPage() throws FileNotFoundException, IOException 
    {

        jLrDifficulty1.setIcon(new ImageIcon("images/blackcircle.png"));
        jLrDifficulty2.setIcon(new ImageIcon("images/blackcircle.png"));
        jLrDifficulty3.setIcon(new ImageIcon("images/blackcircle.png"));
        jLrDifficulty4.setIcon(new ImageIcon("images/blackcircle.png"));
        jLrDifficulty5.setIcon(new ImageIcon("images/blackcircle.png"));

        query = db.randomLine();

        if (query != null) 
        {
            jLrNameResult.setText(query.split(";")[0]);
            jLrIngredientsResult.setText(query.split(";")[1]);
            jLrAboutResult.setText(query.split(";")[2]);
            int tempDiff = (Integer.parseInt(query.split(";")[3]));
            switch (tempDiff) 
            {
                case 5:
                    jLrDifficulty5.setIcon(new ImageIcon("images/greencircle.png"));
                case 4:
                    jLrDifficulty4.setIcon(new ImageIcon("images/greencircle.png"));
                case 3:
                    jLrDifficulty3.setIcon(new ImageIcon("images/greencircle.png"));
                case 2:
                    jLrDifficulty2.setIcon(new ImageIcon("images/greencircle.png"));
                case 1:
                    jLrDifficulty1.setIcon(new ImageIcon("images/greencircle.png"));
                    break;
                case 0:
                    jLrDifficulty1.setIcon(new ImageIcon("images/blackcircle.png"));
                    jLrDifficulty2.setIcon(new ImageIcon("images/blackcircle.png"));
                    jLrDifficulty3.setIcon(new ImageIcon("images/blackcircle.png"));
                    jLrDifficulty4.setIcon(new ImageIcon("images/blackcircle.png"));
                    jLrDifficulty5.setIcon(new ImageIcon("images/blackcircle.png"));
            }
        }

        jPmenu.setVisible(false);
        jPaboutPage.setVisible(false);
        jPaddNewPage.setVisible(false);
        jPbyNameSearchPage.setVisible(false);
        jPmySearchPage.setVisible(false);
        jPrandomPage.setVisible(true);
    }

    public void aboutPage() 
    {
        jPmenu.setVisible(false);
        jPaboutPage.setVisible(true);
        jPaddNewPage.setVisible(false);
        jPbyNameSearchPage.setVisible(false);
        jPmySearchPage.setVisible(false);
        jPrandomPage.setVisible(false);
    }
    
//------------------------------------------------------------------------------
    //Eventi dei jButton
    private void mySearchSubmit() throws FileNotFoundException, IOException 
    {
        System.out.println("Ricerca buona");

        queryMs = db.mySearch(jTAmSResearch.getText().split(","));
        if (queryMs.size() != 0) 
        {
            setAttributes(0);
            jLpageNumber.setText("1/" + queryMs.size());
        }


        jTAmSResearch.setVisible(false);
        jBmSSubmit.setVisible(false);
        jLmStick.setVisible(false);
        jLmSName.setVisible(true);
        jLmSNameResult.setVisible(true);
        jLmSIngredients.setVisible(true);
        jLmSIngredientsResult.setVisible(true);
        jLmSAbout.setVisible(true);
        jLmSAboutResult.setVisible(true);
        jLmSDifficulty.setVisible(true);
        jLmSDifficulty1.setVisible(true);
        jLmSDifficulty2.setVisible(true);
        jLmSDifficulty3.setVisible(true);
        jLmSDifficulty4.setVisible(true);
        jLmSDifficulty5.setVisible(true);
        jBprevious.setVisible(true);
        jLpageNumber.setVisible(true);
        jBnext.setVisible(true);
        if (jLmSNameResult.getText().length() == 0)
        {
            System.out.println("Record non trovato.");
            jPmySearchPage.setVisible(false);
            jPerrorPage.setVisible(true);
        }
        
    }

    private void byNameSubmit() throws FileNotFoundException, IOException 
    {
        System.out.println("Ricerca buona");

        query = db.byName(jTAbNResearch.getText());
        if (query != null) 
        {
            jLbNNameResult.setText(query.split(";")[0]);
            jLbNIngredientsResult.setText(query.split(";")[1]);
            jLbNAboutResult.setText(query.split(";")[2]);
            int tempDiff = (Integer.parseInt(query.split(";")[3]));
            switch (tempDiff) 
            {
                case 5:
                    jLbNDifficulty5.setIcon(new ImageIcon("images/greencircle.png"));
                case 4:
                    jLbNDifficulty4.setIcon(new ImageIcon("images/greencircle.png"));
                case 3:
                    jLbNDifficulty3.setIcon(new ImageIcon("images/greencircle.png"));
                case 2:
                    jLbNDifficulty2.setIcon(new ImageIcon("images/greencircle.png"));
                case 1:
                    jLbNDifficulty1.setIcon(new ImageIcon("images/greencircle.png"));
                    break;
                case 0:
                    jLbNDifficulty1.setIcon(new ImageIcon("images/blackcircle.png"));
                    jLbNDifficulty2.setIcon(new ImageIcon("images/blackcircle.png"));
                    jLbNDifficulty3.setIcon(new ImageIcon("images/blackcircle.png"));
                    jLbNDifficulty4.setIcon(new ImageIcon("images/blackcircle.png"));
                    jLbNDifficulty5.setIcon(new ImageIcon("images/blackcircle.png"));
            }
        }

        jTAbNResearch.setVisible(false);
        jBbNSubmit.setVisible(false);
        jLbNtick.setVisible(false);
        jLbNName.setVisible(true);
        jLbNNameResult.setVisible(true);
        jLbNIngredients.setVisible(true);
        jLbNIngredientsResult.setVisible(true);
        jLbNAbout.setVisible(true);
        jLbNAboutResult.setVisible(true);
        jLbNDifficulty.setVisible(true);
        jLbNDifficulty1.setVisible(true);
        jLbNDifficulty2.setVisible(true);
        jLbNDifficulty3.setVisible(true);
        jLbNDifficulty4.setVisible(true);
        jLbNDifficulty5.setVisible(true);
        jPerrorPage.setVisible(false);
        if (jLbNNameResult.getText().length() == 0)
        {
            System.out.println("Record non trovato.");
            jLbNName.setVisible(false);
            jLbNNameResult.setVisible(false);
            jLbNIngredients.setVisible(false);
            jLbNIngredientsResult.setVisible(false);
            jLbNAbout.setVisible(false);
            jLbNAboutResult.setVisible(false);
            jLbNDifficulty.setVisible(false);
            jLbNDifficulty1.setVisible(false);
            jLbNDifficulty2.setVisible(false);
            jLbNDifficulty3.setVisible(false);
            jLbNDifficulty4.setVisible(false);
            jLbNDifficulty5.setVisible(false);
            jPbyNameSearchPage.setVisible(false);
            jPerrorPage.setVisible(true);
            /*
            jLerrorPage.setVisible(true);
            jLerrorTitle.setVisible(true);
            jBerrorNeverMind.setVisible(true);
            
            jPbyNameSearchPage.setVisible(false);
            */
        }
    }

    public void addNewSubmit() throws IOException, FileNotFoundException 
    {
        String addQuery = jTAaNNameInput.getText() + ";" + jTAaNIngredientsInput.getText() + ";" + jTAaNAboutInput.getText() + ";" + jTAaNDifficultyInput.getText();
        db.addNew(addQuery);
        jTAaNNameInput.setText("");
        jTAaNIngredientsInput.setText("");
        jTAaNAboutInput.setText("");
        jTAaNDifficultyInput.setText("");
        jLaNTickName.setVisible(false);
        jLaNTickIngredients.setVisible(false);
        jLaNTickAbout.setVisible(false);
        jLaNTickDifficulty.setVisible(false);
        jTAaNNameInput.setEditable(true);
        jTAaNIngredientsInput.setEditable(true);
        jTAaNAboutInput.setEditable(true);
        jTAaNDifficultyInput.setEditable(true);
        jBaNSubmit.setEnabled(false);
        counter = 0;
    }

    
    public void previousResult() 
    {
        if (queryMs.size() != 0) 
        {
            int tempPageNum = Integer.parseInt(jLpageNumber.getText().split("/")[0]);
            if (!(tempPageNum == 1)) 
            {
                jLpageNumber.setText((tempPageNum - 1) + "/" + queryMs.size());
                setAttributes(tempPageNum - 2);
            }
        }

    }

    public void nextResult() 
    {
        if (queryMs.size() != 0) 
        {
            int tempPageNum = Integer.parseInt(jLpageNumber.getText().split("/")[0]);
            if (!(tempPageNum == queryMs.size())) 
            {
                jLpageNumber.setText((tempPageNum + 1) + "/" + queryMs.size());
                setAttributes(tempPageNum);
            }
        }
    }
    
    public void clearContent()
    {
        jLbNNameResult.setText("");
        jLmSNameResult.setText("");
        
    }

    public void setAttributes(int index) 
    {
        jLmSDifficulty1.setIcon(new ImageIcon("images/blackcircle.png"));
        jLmSDifficulty2.setIcon(new ImageIcon("images/blackcircle.png"));
        jLmSDifficulty3.setIcon(new ImageIcon("images/blackcircle.png"));
        jLmSDifficulty4.setIcon(new ImageIcon("images/blackcircle.png"));
        jLmSDifficulty5.setIcon(new ImageIcon("images/blackcircle.png"));

        jLmSNameResult.setText(queryMs.get(index).split(";")[0]);
        jLmSIngredientsResult.setText(queryMs.get(index).split(";")[1]);
        jLmSAboutResult.setText(queryMs.get(index).split(";")[2]);
        int tempDiff = (Integer.parseInt(queryMs.get(index).split(";")[3]));
        switch (tempDiff) 
        {
            case 5:
                jLmSDifficulty5.setIcon(new ImageIcon("images/greencircle.png"));
            case 4:
                jLmSDifficulty4.setIcon(new ImageIcon("images/greencircle.png"));
            case 3:
                jLmSDifficulty3.setIcon(new ImageIcon("images/greencircle.png"));
            case 2:
                jLmSDifficulty2.setIcon(new ImageIcon("images/greencircle.png"));
            case 1:
                jLmSDifficulty1.setIcon(new ImageIcon("images/greencircle.png"));
                break;
            case 0:
                jLmSDifficulty1.setIcon(new ImageIcon("images/blackcircle.png"));
                jLmSDifficulty2.setIcon(new ImageIcon("images/blackcircle.png"));
                jLmSDifficulty3.setIcon(new ImageIcon("images/blackcircle.png"));
                jLmSDifficulty4.setIcon(new ImageIcon("images/blackcircle.png"));
                jLmSDifficulty5.setIcon(new ImageIcon("images/blackcircle.png"));
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException 
    {
        new Abooze2();
    }
}