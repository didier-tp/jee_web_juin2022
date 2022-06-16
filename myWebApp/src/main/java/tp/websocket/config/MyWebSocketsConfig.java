package tp.websocket.config;

import java.util.HashSet;
import java.util.Set;
import javax.websocket.Endpoint;
import javax.websocket.server.ServerApplicationConfig;
import javax.websocket.server.ServerEndpointConfig;
//import websocket.xy.XyEndpoint;

public class MyWebSocketsConfig implements ServerApplicationConfig {

	@Override
	public Set<ServerEndpointConfig> getEndpointConfigs(Set<Class<? extends Endpoint>> scanned) {
		Set<ServerEndpointConfig> result = new HashSet<>();
		/*
		if (scanned.contains(XyEndpoint.class)) {
			result.add(ServerEndpointConfig.Builder.create(XyEndpoint.class, "/websocket/xy").build());
		}
		*/
		return result;
	}

	@Override
	public Set<Class<?>> getAnnotatedEndpointClasses(Set<Class<?>> scanned) {
		Set<Class<?>> results = new HashSet<>();
		for (Class<?> clazz : scanned) {
			if (clazz.getPackage().getName().startsWith("tp.websocket.endpoint")) {
				results.add(clazz);
			}
		}
		return results;
	}
}