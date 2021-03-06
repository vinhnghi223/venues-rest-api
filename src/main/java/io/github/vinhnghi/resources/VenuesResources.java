package io.github.vinhnghi.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.vinhnghi.model.Venue;
import io.github.vinhnghi.service.VenuesListService;

@Component
@Path("/venues")
public class VenuesResources {
	
	@Autowired
	VenuesListService venuesClient;
	
	@GET
	@Produces("application/json")
    public List<Venue> getAll(){
        List<Venue> products = new ArrayList<Venue>();
        products.add(new Venue());
        return products;
    }
	
	@GET
	@Path("{query}")
	@Produces("application/json")
	public List<Venue> getVenues(@PathParam("query") String query){
		return venuesClient.getVenues(query);
	}
	
}
