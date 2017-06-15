package springsecure;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;

import sun.misc.BASE64Decoder;

public class ProductServiceImpl implements ProductService {

	List<Product> products = new ArrayList<Product>();
	private int productId = 123;

	public ProductServiceImpl() {
		Product product = new Product();
		product.setId(++productId);
		product.setDescription("Java Web Services Course!");
		products.add(product);
	}

	@Override
	public List<Product> getProducts(String authString,HttpHeaders headers) {
		isUserAuthenticated(authString);
		Map<String,Cookie> cookies = headers.getCookies();
		Set<String> names = cookies.keySet();
		for(String name :names){
			Cookie cookie = cookies.get(name);
			System.out.println("cookie info:"+name+"+"+cookie.getValue());
		}
		return products;
	}

	@Override
	public int addProduct(Product product) {
		product.setId(++productId);
		products.add(product);
		return productId;
	}
	//decoding the authentication string, encoded using Base64 encoding
	private String isUserAuthenticated(String authString){
        //if auth is null, it will not go to this get methond unless it collect cookie
		if(authString==null){
			System.out.println("null auth string");
			return "null auth string";
		}
        String decodedAuth = "";
        // Header is in the format "Basic 5tyc0uiDat4"
        // We need to extract data before decoding it back to original string
        String[] authParts = authString.split("\\s+");
        String authInfo = authParts[1];
        // Decode the data back to original string
        byte[] bytes = null;
        try {
            bytes = new BASE64Decoder().decodeBuffer(authInfo);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        decodedAuth = new String(bytes);
        System.out.println(decodedAuth);
         
        /**
         * here you include your logic to validate user authentication.
         * it can be using ldap, or token exchange mechanism or your 
         * custom authentication mechanism.
         */
        // your validation code goes here....
         
        return decodedAuth;
    }
}
