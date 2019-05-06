package learn.middleware.rabbitmq.config;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by sgven on 2019/5/5.
 */
public class RabbitMQConfig {

    public static void connect() {
        ConnectionFactory factory = new ConnectionFactory();
        //“guest” /“guest”默认情况下，仅限于本地主机连接
//        factory.setUsername("guest");
//        factory.setPassword("guest");
//        factory.setVirtualHost("/");
        factory.setHost("localhost");
//        factory.setPort(5672);

        try {
            Connection conn = factory.newConnection();
            Channel channel = conn.createChannel();
            channel.close();
            conn.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        connect();
    }
}
