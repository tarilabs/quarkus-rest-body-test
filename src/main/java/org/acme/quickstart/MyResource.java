package org.acme.quickstart;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/test")
public class MyResource {

    @POST()
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String process(@QueryParam("param1") String param1, String body) {
        Jsonb jsonb = JsonbBuilder.create();
        Map<?, ?> fromJson = jsonb.fromJson(body, HashMap.class);

        StringBuilder sb = new StringBuilder().append("param1=").append(param1);
        sb.append(" and a body with ").append(fromJson.size()).append(" entries={\n");
        for (Entry<?, ?> kv : fromJson.entrySet()) {
            sb.append(kv.getKey()).append(" (").append(kv.getKey().getClass()).append(") : ");
            sb.append(kv.getValue()).append(" (").append(kv.getValue().getClass()).append(")\n");
        }
        return sb.append("}").toString();
    }
}