# CS380 Project 1 

In this project, you will be implementing a very simple chat client. I will have a server running that you will
connect to for testing your client. In this project, both the server and client will communicate using UTF-8
text. The server will work as follows: the first line you send will be stored by the server as your user name.
If it is already in use, the server will respond “Name in use.” and close the connection.

After connecting and providing a name, any line you send to the server will be broadcast to all connected
clients with a timestamp and the sender’s username. Your client should run either a loop or a separate thread1
that reads messages from the server and displays them. You can also create a graphical user interface if you
desire.
