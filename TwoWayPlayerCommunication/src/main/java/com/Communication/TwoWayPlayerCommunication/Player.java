package com.Communication.TwoWayPlayerCommunication;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class Player implements Runnable, MessageObserver {
    private String name;
    private BlockingQueue<String> messageQueue;
    private Player otherPlayer;
    private int sentMessages;
    private int receivedMessages;

    private Player() {
        this.messageQueue = new LinkedBlockingQueue<>();
    }

    public void setOtherPlayer(Player otherPlayer) {
        this.otherPlayer = otherPlayer;
    }

    public void sendMessage(String message) {
        messageQueue.add(message);
        sentMessages++;
    }

    @Override
    public void notify(String message) {
        receiveMessage(message);
    }

    private void receiveMessage(String message) {
        receivedMessages++;
        String response = message + " " + sentMessages;
        System.out.println(name + " received message: " + message + ", sending response: " + response);
        try {
            Thread.sleep(100); // Simulating some processing time before sending the response
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        otherPlayer.sendMessage(response);
    }

    @Override
    public void run() {
        while (receivedMessages < 10 || sentMessages < 10) {
            try {
                String message = messageQueue.take();
                notify(message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class Builder {
        private Player player;

        public Builder(String name) {
            player = new Player();
            player.name = name;
        }

        public Builder withOtherPlayer(Player otherPlayer) {
            player.otherPlayer = otherPlayer;
            return this;
        }

        public Player build() {
            return player;
        }
    }
}

