import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JPanel mainPanel;
  
  JLabel firstLabel;
  JLabel secondLabel;
  JLabel thirdLabel;

  JTextField firstInput;
  JTextField secondInput;
  JTextField thirdInput;

  JButton validateButton;
  JButton resetButton;

  JTextArea outputArea;
  JTextArea instructionArea;

  Font biggerText;


  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("My First Program");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);
 
    //initialize the main JPanel
    mainPanel = new JPanel();
    //disable any layout helpers
    mainPanel.setLayout(null);

    //create the side labels
    firstLabel = new JLabel("Enter the first side:");
    secondLabel = new JLabel("Enter the second side:");
    thirdLabel = new JLabel("Enter the third side:");

    //layout the labels by setting coordinate and size
    //set Bounds (x,y,width,height)
    firstLabel.setBounds(10,10,200,20);
    secondLabel.setBounds(10,40,200,20);
    thirdLabel.setBounds(10,70,200,20);

    //initialize the input text fields
    firstInput = new JTextField();
    secondInput = new JTextField();
    thirdInput = new JTextField();

    //set the location and size
    firstInput.setBounds(220,10,100,20);
    secondInput.setBounds(220,40,100,20);
    thirdInput.setBounds(220,70,100,20);

    //initialize the buttons
    validateButton = new JButton("Validate");
    resetButton = new JButton("Clear");

    //set the location and size
    validateButton.setBounds(330,10,100,35);
    resetButton.setBounds(330,55,100,35);

    //add an action listener to the buttons
    validateButton.addActionListener(this);
    resetButton.addActionListener(this);

    //set the action command on the buttons
    validateButton.setActionCommand("validate");
    resetButton.setActionCommand("clear");

    //initialize the text areas
    outputArea = new JTextArea();
    instructionArea = new JTextArea();

    //create a string that holds the instructions
    String instructions = "This is a simple triangle detector.\nEnter an integer into each of the text fields above.\nPress the \"Validate Button\" to find out whether you have made a valid triangle or not.\nYou can press Clear to reset everything";

    //set the text in the instruction
    instructionArea.setText(instructions);

    //set the location and size
    outputArea.setBounds(10,100,780,240);
    instructionArea.setBounds(10,350,780,240);

    //disable the text areas so the user can't type in them
    outputArea.setEnabled(false);
    instructionArea.setEnabled(false);

    //create a bigger font for the user
    biggerText = new Font("arial",Font.BOLD,16);

    //set the font on the area I want to use it
    instructionArea.setFont(biggerText);
    outputArea.setFont(biggerText);

    //add the text areas to the panel
    mainPanel.add(outputArea);
    mainPanel.add(instructionArea);

    //add the buttons to the panel
    mainPanel.add(validateButton);
    mainPanel.add(resetButton);

    //add the text fields to the panel
    mainPanel.add(firstInput);
    mainPanel.add(secondInput);
    mainPanel.add(thirdInput);

    //add the labels to the mainPanel
    mainPanel.add(firstLabel);
    mainPanel.add(secondLabel);
    mainPanel.add(thirdLabel);

    //add the panel to the window
    frame.add(mainPanel);

  }

  //checks to see if a triangle is valid given the length of side a, b, and c
  public boolean isValidTriangle(int a, int b, int c){
    //check using the triangle inequality 
    if(a + b > c && a + c > b && b + c > a){
      //valid triangle
      return true;
    }else{
      //invaluid triangle
      return false;
    }
  }


  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

    if(command.equals("validate")){
      //get the text from each text box
      String firstText = firstInput.getText();
      String secondText = secondInput.getText();
      String thirdText = thirdInput.getText();

      //change the string into an integer
      int sideA = Integer.parseInt(firstText);
      int sideB = Integer.parseInt(secondText);
      int sideC = Integer.parseInt(thirdText);

      //using a method to check if the triangle is valid
      boolean isValid = isValidTriangle(sideA, sideB, sideC);
      //output the answer to the user
      if(isValid){
        outputArea.setText("This is a valid triangle");
      }else{
        outputArea.setText("This is a invalid triangle");
      }


    }else if(command.equals("clear")){
      //clear all of the text in the text boxes
      firstInput.setText("");
      secondInput.setText("");
      thirdInput.setText("");
      outputArea.setText("");
    }
    

  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
