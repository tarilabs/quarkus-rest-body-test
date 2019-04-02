package org.acme.quickstart;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@Path("/testjaxb")
public class MyJAXBResource {

    @POST()
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.TEXT_PLAIN)
    public String processXml(@QueryParam("param1") String param1, Thing body) {
        System.out.println("xxx");
        StringBuilder sb = new StringBuilder().append("param1=").append(param1);
        sb.append(" and a body with ").append(body);
        return "asd";
    }

    @XmlRootElement(name = "thing")
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Thing {

        @XmlAttribute
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}