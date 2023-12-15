// Exercise31_01Server.java: The server can communicate with
// multiple clients concurrently using the multiple threads
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ClassNotFoundException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import java.util.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;import java.io.*;
import java.sql.*;


public class Exercise33_01Server extends Application {
  
  // Text area for displaying contents
  private TextArea ta = new TextArea();
  Loan data = new Loan();
  
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) throws IOException {
    
    ta.setWrapText(true);
   
    // Create a scene and place it in the stage
    Scene scene = new Scene(new ScrollPane(ta), 400, 200);
    primaryStage.setTitle("Exercise31_01Server"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  
  new Thread(() -> {
    try {
      ServerSocket server = new ServerSocket(9876);
      Platform.runLater(() ->
        ta.appendText("Server started at " + new Date() + '\n'));
      
      Socket socket = server.accept();
      Platform.runLater(() ->
        ta.appendText("Connected to a client at " + new Date() + '\n'));
      
      DataInputStream in = new DataInputStream(socket.getInputStream());
      DataOutputStream out = new DataOutputStream(socket.getOutputStream());
      
      while (true) {
        double rate = in.readDouble();
        int years = in.readInt();
        double amount = in.readDouble();
        
        data.setAnnualInterestRate(rate);          
        data.setNumberOfYears(years);
        data.setLoanAmount(amount);
        Platform.runLater(() -> {
          ta.appendText("Annual Intrest Rate: " + rate + '\n');
          ta.appendText("Number of Years: " + years + '\n');
          ta.appendText("Loan Amount: " + amount + '\n');
          ta.appendText("Monthly Payment: " + data.getMonthlyPayment() + '\n');
        });
      }
    }
    catch (IOException ex) {
      System.out.println("Error in with the thread");
    }
  });
}
  
  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}