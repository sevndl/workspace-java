import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class TestAsynchrone {
	
	public static void main(String[] args) {
		ConnectionFactory factory = new ActiveMQConnectionFactory("admin", "admin", "tcp://localhost:61616");
		try {
			Connection connection = factory.createConnection();
			Session session = connection.createSession(false,  Session.AUTO_ACKNOWLEDGE);
			Destination queue = session.createQueue("Queue EPSI");
			TextMessage message = session.createTextMessage("hello world");
			MessageProducer producer = session.createProducer(queue);
			producer.send(message);
			session.close();
			connection.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}		
	}
	
}
