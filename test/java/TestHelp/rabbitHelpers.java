package TestHelp;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class rabbitHelpers {

    public static String consumeMessage () {
        ConnectionFactory factory = new ConnectionFactory();


      /**  factory.UserName = connectionInstance.Fields["UserName"];
        factory.Password = connectionInstance.Fields["Password"];
        factory.VirtualHost = connectionInstance.Fields["VirtualHost"];
        factory.HostName = connectionInstance.Fields["HostName"];
        factory.Port = Convert.ToInt32(connectionInstance.Fields["Port"]);**/

        factory.setUsername("rabbitAdmin");
        factory.setPassword("rabbitAdminPwd");
        factory.setVirtualHost("mgsEventCollectorHost");
        factory.setHost("rabbitmq");
        factory.setPort(15672);
        factory.setTopologyRecoveryEnabled(true);
       factory.setAutomaticRecoveryEnabled(true);
        Connection connection = null;
        try {
            connection = factory.newConnection();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        Channel channel = null;
        try {
            channel = connection.createChannel();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //channel.queueDeclare("mgsEvtCollectorQueue", false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received '" + message + "'");
        };
        try {
            channel.basicConsume("mgsEvtCollectorQueue", true, deliverCallback, consumerTag -> { });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Test(priority =1 )
    public static void TestConsumeMessage () throws IOException, TimeoutException {
        String nathi = consumeMessage ();
    }


    public static String createMessage ()
    {
        return "yebbbb";
    }
}
