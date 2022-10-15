/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.quizapplication;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/**
 *
 * @author Rithi
 */
public class QuizApplication extends JFrame implements ActionListener{
    JLabel label;
    JRadioButton RadioButtons[]= new JRadioButton[5];
    JButton buttonNext, buttonResult;
    ButtonGroup btng;
    int count=0, current=0, x=1,y=1, now=0;
    int m[]= new int[7]; //10= num of questions
    
    QuizApplication(String s){
        super(s); //super calls on parent class constructor, parent class is JFrame so putting s into JFrame
        // creates a jframe w title of string input
        
        label= new JLabel(); // creating and adding label to frame
        add(label);
        
        btng= new ButtonGroup();
        
        for(int i=0;i<5;i++){
            RadioButtons[i]=new JRadioButton();// adding 5 radio buttons to eqach question
            add(RadioButtons[i]);// add to jframe
            btng.add(RadioButtons[i]);
            
        }
            buttonNext= new JButton("Next");
            buttonResult= new JButton("Result");
            buttonResult.setVisible(false);
            buttonNext.addActionListener(this);
            buttonResult.addActionListener(this);
            add(buttonNext);
            add(buttonResult);
            
            setData();
            label.setBounds(30, 40, 450, 20);
            RadioButtons[0].setBounds(50,80,450,20);
            RadioButtons[1].setBounds(50,110,200,20);
            RadioButtons[2].setBounds(50,140,200,20);
            RadioButtons[3].setBounds(50,170,200,20);
            buttonNext.setBounds(100, 240, 100,30);
            buttonResult.setBounds(270,240,100,30);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(null);
            setLocation(250,100);
            setVisible(true);
            setSize(600,350);
            
        }
    public void setData(){
        
        if(current==0){
            label.setText("Question 1: whats Rithi's fav color?");
            RadioButtons[0].setText("purple");
            RadioButtons[1].setText("black");
            RadioButtons[2].setText("pink");
            RadioButtons[3].setText("magenta");
        }
        if(current==1){
            label.setText("Question 2: whats Rithi's fav cuisine?");
            RadioButtons[0].setText("thai");
            RadioButtons[1].setText("indian");
            RadioButtons[2].setText("italian");
            RadioButtons[3].setText("japanese");
        }
        if(current==2){
            label.setText("Question 3: whats Rithi's fav anime?");
            RadioButtons[0].setText("aot");
            RadioButtons[1].setText("deathnote");
            RadioButtons[2].setText("devilman crybaby");
            RadioButtons[3].setText("inuyasha");
        }
        if(current==3){
            label.setText("Question 4: whats Rithi's fav season?");
            RadioButtons[0].setText("autumn");
            RadioButtons[1].setText("winter");
            RadioButtons[2].setText("spring");
            RadioButtons[3].setText("summer");
        }
        if(current==4){
            label.setText("Question 5: how many states has rithi visited?");
            RadioButtons[0].setText("13");
            RadioButtons[1].setText("7");
            RadioButtons[2].setText("6");
            RadioButtons[3].setText("14");
        }
        if(current==5){
            label.setText("Question 6: what artist does Rithi like the most out of the following");
            RadioButtons[0].setText("lana del rey");
            RadioButtons[1].setText("nct");
            RadioButtons[2].setText("exo");
            RadioButtons[3].setText("p!atd");
        }
        if(current==6){
            label.setText("Question 7: what does rithi hate");
            RadioButtons[0].setText("kurdi");
            RadioButtons[1].setText("licorish");
            RadioButtons[2].setText("men");
            RadioButtons[3].setText("all of the above");
        
    }
        label.setBounds(30,40,450,20);
        
    }
    
    public boolean checkAns(){
        if(current==0){
            return RadioButtons[3].isSelected();
        }
        if(current==1){
            return RadioButtons[1].isSelected();
        }
        if(current==2){
            return RadioButtons[2].isSelected();
        }
        if(current==3){
            return RadioButtons[0].isSelected();
        }
        if(current==4){
            return RadioButtons[0].isSelected();
        }
        if(current==5){
            return RadioButtons[1].isSelected();
        }
        if(current==6){
            return RadioButtons[3].isSelected();
        }
       return false;
    }
    public static void main(String[] args) {
        new QuizApplication("Simple quiz app");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==buttonNext){
            if(checkAns()){
                count++;
                current++;
                setData();}
            else{
                current++;
                setData();
            }
                if(current==7){
                    buttonNext.setEnabled(false);
                    buttonResult.setVisible(true);
                    
                }
                
            }
        if(e.getActionCommand().equals("Result")){
            
            current++;
            JOptionPane.showMessageDialog(this, "Correct Answers: "+count);
            System.exit(0);
        }
        }
    }

