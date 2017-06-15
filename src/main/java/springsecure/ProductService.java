package springsecure;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

import org.springframework.security.access.annotation.Secured;

public interface ProductService {
	@Secured("ROLE_CUSTOMER")
	@GET
	@Path("/products")
	List<Product> getProducts(@HeaderParam("authorization") String authString,@Context HttpHeaders headers);
	@Secured("ROLE_ADMIN")
	@POST
	@Path("/products")
	int addProduct(Product product);
}
