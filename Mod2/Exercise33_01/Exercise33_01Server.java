// Exercise31_01Server.java: The server can communicate with
package com.journaldev.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ClassNotFoundException;
import java.net.ServerSocket;
import java.net.Socket;
// multiple clients concurrently using the multiple threads
import java.util.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class Exercise33_01Server extends Application {
  //https://www.digitalocean.com/community/tutorials/java-socket-programming-server-client
  //static ServerSocket variable
  private static ServerSocket server;
  //socket server port on which it will listen
  private static int port = 9876;
  
  // Text area for displaying contents
  private TextArea ta = new TextArea();

  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    ta.setWrapText(true);
   
    // Create a scene and place it in the stage
    Scene scene = new Scene(new ScrollPane(ta), 400, 200);
    primaryStage.setTitle("Exercise31_01Server"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }
    
  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
