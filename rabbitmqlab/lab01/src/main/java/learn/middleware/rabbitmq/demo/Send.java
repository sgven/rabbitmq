package learn.middleware.rabbitmq.demo;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Send {

    private final static String QUEUE_NAME = "hello";

    public static void main(String[] argv) throws Exception {
        String message = "Hello World！";
        sendMessage(QUEUE_NAME, message);
    }

    public static void sendMessage(String queueName, String message) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare(queueName,false,false,false,null);

            channel.basicPublish("",queueName,null,message.getBytes());
            System.out.println("[x] Sent'" + message + "'");
        }
    }

}
