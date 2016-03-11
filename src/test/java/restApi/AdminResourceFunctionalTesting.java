package restApi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.net.URI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestsApiConfig.class})
public class AdminResourceFunctionalTesting {

    private static final String URL_API = "http://localhost:8080/Proyecto1.0.0.1-SNAPSHOT" + Uris.SERVLET_MAP;

    @Test
    public void testCalculadora() {

        // Params
        MultiValueMap<String, String> params = new HttpHeaders();
        params.add("dividendo", "4");
        params.add("divisor", "2");

        // Uri
        URI uri = UriComponentsBuilder.fromHttpUrl(URL_API).path(Uris.ADMINS).path(Uris.CALCULADORA).queryParams(params)
                .buildAndExpand(666).encode().toUri();
        System.out.println("URI: " + uri);

        RequestEntity<Object> requestEntity = new RequestEntity<>(HttpMethod.GET, uri);
        String response = new RestTemplate().exchange(requestEntity, String.class).getBody();
        System.out.println("Response: " + response);
        assertEquals("{división:2}", response);
    }
    
    @Test
    public void testCalculadora2() {

	    // Wrapper
	    Wrapper wrapper = new Wrapper(4,2);
	
	    // Uri
	    URI uri = UriComponentsBuilder.fromHttpUrl(URL_API).path(Uris.ADMINS).path(Uris.CALCULADORA2).build().encode().toUri();
	    System.out.println("URI: " + uri);
	    
	    RequestEntity<Wrapper> requestEntity = new RequestEntity<>(wrapper, HttpMethod.POST, uri);
	
	    String json = new RestTemplate().exchange(requestEntity, String.class).getBody();
	    System.out.println(json);
	    assertEquals("{división:2}", json);
    }
    @Test
    public void testCalculadora2Exception() {

	    try{
	    	Wrapper wrapper = new Wrapper(4,0);
	    	URI uri = UriComponentsBuilder.fromHttpUrl(URL_API).path(Uris.ADMINS).path(Uris.CALCULADORA2).build().encode().toUri();
		    System.out.println("URI: " + uri);
		    
		    RequestEntity<Wrapper> requestEntity = new RequestEntity<>(wrapper, HttpMethod.POST, uri);
		    String json = new RestTemplate().exchange(requestEntity, String.class).getBody();
		    System.out.println(json);
	    fail();
    } catch (HttpClientErrorException httpError) {
        assertEquals(HttpStatus.BAD_REQUEST, httpError.getStatusCode());
        System.out.println("ERROR >>>>> " + httpError.getMessage());
        System.out.println("ERROR >>>>> " + httpError.getResponseBodyAsString());
    }
    }
}
