# 360T_TechnicalProblem
Problem Statement:
Given a Player class - an instance of which can communicate with other Players.

The requirements are as follows:

1. create 2 Player instances
2. one of the players should send a message to second player (let's call this player "initiator")
3. when a player receives a message, it should reply with a message that contains the received message concatenated with the value of a counter holding the number of messages this player already sent.
4. finalize the program (gracefully) after the initiator sent 10 messages and received back 10 messages (stop condition)
5. both players should run in the same java process (strong requirement)

Below is the shell script to start the program:
#!/bin/bash

cd D:/Workspace/360T_Problem/TwoWayPlayerCommunication/target

java -cp TwoWayPlayerCommunication-0.0.1-SNAPSHOT.jar com.Communication.TwoWayPlayerCommunication.App

To run the shell script
chmod +x PlayerStartCommunication.sh
./PlayerStartCommunication.sh


