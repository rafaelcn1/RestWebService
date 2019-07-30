package local.rafaelcunha;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

@Path("/Clock")
public class ClockRest {
	private static final Map<Clock, Double> CACHE = new ConcurrentHashMap<>();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{hora}/{minuto}")
	public Map<String, Double> exibir(@Context HttpHeaders httpHeaders, @PathParam("hora") int hora,
			@PathParam("minuto") int minuto) {
		Clock clock = new Clock(hora, minuto);
		
		
		Double angulo = CACHE.get(clock);
		
		//Não deixar recalcular em caso a mesma consulta seja executada duas vezes 
		if (angulo == null) {
			angulo = clock.getAngulo();
			CACHE.put(clock, angulo);

		}

		Map<String, Double> resultado = new HashMap<>();
		resultado.put("angle", angulo);

		return resultado;
	}

}
