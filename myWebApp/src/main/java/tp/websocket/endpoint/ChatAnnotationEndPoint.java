package tp.websocket.endpoint;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

//import util.HTMLFilter;

@ServerEndpoint(value = "/websocket/chat")
public class ChatAnnotationEndPoint {
	private static final String GUEST_PREFIX = "Guest";
	private static final AtomicInteger connectionIds = new AtomicInteger(0);
	private static final Set<ChatAnnotationEndPoint> connections = new CopyOnWriteArraySet<>();
	private final String nickname;
	private Session session; // javax.websocket.Session

	public ChatAnnotationEndPoint() {
		nickname = GUEST_PREFIX + connectionIds.getAndIncrement();
	}

	@OnOpen
	public void start(Session session) {
		this.session = session;
		connections.add(this); // une instance de cette classe construite pour chaque connexion
		String message = String.format("* %s %s", nickname, "has joined.");
		broadcast(message);
	}

	@OnClose
	public void end() {
		connections.remove(this);
		String message = String.format("* %s %s", nickname, "has disconnected.");
		broadcast(message);
	}

	@OnMessage
	public void incoming(String message) {
		// Never trust the client
		String filteredMessage = String.format("%s: %s", nickname, /*HTMLFilter.filter(*/message.toString()/*)*/);

		broadcast(filteredMessage);
	}

	@OnError
	public void onError(Throwable t) throws Throwable {
		System.err.println("Chat Error: " + t.toString());
	}

	private static void broadcast(String msg) {
		for (ChatAnnotationEndPoint client : connections) {
			try {
				synchronized (client) {
					client.session.getBasicRemote().sendText(msg);
				}
			} catch (IOException e) {
				System.out.println("Chat Error: Failed to send message to client" + e.getMessage());
				connections.remove(client);
				try {
					client.session.close();
				} catch (IOException e1) {
					// Ignore
				}
				String message = String.format("* %s %s", client.nickname, "has been disconnected.");
				broadcast(message);
			}
		}
	}
}
