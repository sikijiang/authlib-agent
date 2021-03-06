package yushijinhun.authlibagent.web.manager;

import java.util.Collection;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import yushijinhun.authlibagent.model.AccessPolicy;
import yushijinhun.authlibagent.model.AccessRule;
import yushijinhun.authlibagent.util.ResourceUtils;

@Path("/rules")
@Produces(ResourceUtils.APPLICATION_JSON_UTF8)
public interface RuleResource {

	@GET
	Collection<AccessRule> getRules(@QueryParam("policy") AccessPolicy policy);

	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	AccessRule createRule(AccessRule rule);

	@GET
	@Path("{host}")
	AccessRule getRule(@PathParam("host") String host);

	@Consumes(MediaType.APPLICATION_JSON)
	@PUT
	@Path("{host}")
	AccessRule createOrUpdateRule(@PathParam("host") String host, AccessRule rule);

	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	@Path("{host}")
	AccessRule updateRule(@PathParam("host") String host, AccessRule rule);

	@DELETE
	@Path("{host}")
	void deleteRule(@PathParam("host") String host);

}
