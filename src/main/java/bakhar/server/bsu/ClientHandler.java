package bakhar.server.bsu;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;

public class ClientHandler implements Runnable {
    private Server server;
    private PrintWriter outMessage;
    private Scanner inMessage;
    private Socket clientSocket = null;
    private String username = null;
    private static int clients_count = 0;

    public ClientHandler(Socket socket, Server server) {
        try {
            clients_count++;
            this.server = server;
            this.clientSocket = socket;
            this.outMessage = new PrintWriter(socket.getOutputStream());
            this.inMessage = new Scanner(socket.getInputStream());
            username = inMessage.nextLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                // сервер отправляет сообщение
                server.sendMessageToAllClients("Новый участник вошёл в чат! " + username);
                server.sendMessageToAllClients("Клиентов в чате = " + clients_count);
                break;
            }

            while (true) {
                if (inMessage.hasNext()) {
                    String clientMessage = inMessage.nextLine();
                    if (clientMessage.equalsIgnoreCase("##session##end##")) {
                        break;
                    }
                    String[] words = clientMessage.split("\s");
                    if (words[0].equals("get")) {
                        HashMap info = server.getInformation();
                        try {
                            Integer key = Integer.valueOf(words[1]);
                            String value = (String) info.get(key);
                            sendMsg(key + "\s" + value);
                        } catch (NumberFormatException | NullPointerException e) {
                            sendMsg("null");
                        }

                    } else if (words[0].equals("push")) {
                        try {
                            Integer key = Integer.valueOf(words[1]);
                            String value = words[2];
                            HashMap<Integer, String> info = server.getInformation();
                            info.put(key, value);
                            sendMsg("success: " + key + "\s" + value);
                        } catch (NumberFormatException | NullPointerException e) {
                            sendMsg("error");
                        }
                    }
                    System.out.println(clientMessage);
                }

                Thread.sleep(100);
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            this.close();
        }

    }

    // отправляем сообщение
    public void sendMsg(String msg) {
        try {
            outMessage.println(msg);
            outMessage.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // клиент выходит из чата
    public void close() {
        // удаляем клиента из списка
        server.removeClient(this);
        clients_count--;
        server.sendMessageToAllClients("Клиентов в чате = " + clients_count);
    }
}