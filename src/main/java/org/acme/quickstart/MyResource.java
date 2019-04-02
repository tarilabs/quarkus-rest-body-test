package org.acme.quickstart;

import java.util.Map;
import java.util.Map.Entry;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.w3c.dom.Node;

@Path("/test")
public class MyResource {

    @POST()
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String process(@QueryParam("param1") String param1, Map<?, ?> bodyAsMap) {
        StringBuilder sb = new StringBuilder().append("param1=").append(param1);
        sb.append(" and a body with ").append(bodyAsMap.size()).append(" entries={\n");
        for (Entry<?, ?> kv : bodyAsMap.entrySet()) {
            sb.append(kv.getKey()).append(" (").append(kv.getKey().getClass()).append(") : ");
            sb.append(kv.getValue()).append(" (").append(kv.getValue().getClass()).append(")\n");
        }
        return sb.append("}").toString();
    }

    @POST()
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.TEXT_PLAIN)
    public String processXml(@QueryParam("param1") String param1, org.w3c.dom.Document body) {
        StringBuilder sb = new StringBuilder().append("param1=").append(param1);
        sb.append(" and a body with ").append(processDocumentBody(body));
        return sb.toString();
    }

    private Node processDocumentBody(org.w3c.dom.Document body) {
        return body.getFirstChild();
    }

    //    @POST()
    //    @Consumes({MediaType.APPLICATION_XML})
    //    @Produces(MediaType.TEXT_PLAIN)
    //    public String processXml(@QueryParam("param1") String param1, Map<?, ?> body) {
    //        StringBuilder sb = new StringBuilder().append("param1=").append(param1);
    //        sb.append(" and a body with ").append(body);
    //        return sb.toString();
    //    }
    //
    //    @XmlRootElement(name = "thing")
    //    @XmlAccessorType(XmlAccessType.FIELD)
    //    public static class Thing {
    //
    //        @XmlAttribute
    //        private String name;
    //
    //        public String getName() {
    //            return name;
    //        }
    //
    //        public void setName(String name) {
    //            this.name = name;
    //        }
    //    }
}