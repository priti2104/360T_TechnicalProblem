package com.Communication.TwoWayPlayerCommunication;

import java.util.Random;



/**
 * @author Priti
 * Entry point of the communication project
 *
 */
public class App {
    public static void main(String[] args) {
        Player player1 = new Player.Builder("Player1").build();
        Player player2 = new Player.Builder("Player2").build();

        player1.setOtherPlayer(player2);
        player2.setOtherPlayer(player1);

        Thread thread1 = new Thread(player1);
        Thread thread2 = new Thread(player2);

        thread1.start();
        thread2.start();

        //Initiator chosen Randomly
        boolean player1Initiates = new Random().nextBoolean();
        if (player1Initiates) {
            player1.sendMessage(CommunicationConstants.COMMUNICATION_MESSAGE);
        } else {
            player2.sendMessage(CommunicationConstants.COMMUNICATION_MESSAGE);
        }

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

