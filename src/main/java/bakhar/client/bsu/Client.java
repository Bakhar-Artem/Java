package bakhar.client.bsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 8080;
    private Socket clientSocket;
    private Scanner inMessage;
    private PrintWriter outMessage;
    private String clientName;


    public Client(String name) throws IOException {

        clientName = name;
        try {
            // подключаемся к серверу
            clientSocket = new Socket(SERVER_HOST, SERVER_PORT);
            inMessage = new Scanner(clientSocket.getInputStream());
            outMessage = new PrintWriter(clientSocket.getOutputStream());
            outMessage.println(clientName);
            outMessage.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            try {
                // бесконечный цикл
                while (true) {
                    // если есть входящее сообщение
                    if (inMessage.hasNext()) {
                        // считываем его
                        String inMes = inMessage.nextLine();
                        System.out.println(inMes);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String msg = reader.readLine();
            sendMsg(msg);
        }

    }


    public void sendMsg(String msg) {

        String messageStr = msg;
        outMessage.println(messageStr);
        outMessage.flush();
    }
}
