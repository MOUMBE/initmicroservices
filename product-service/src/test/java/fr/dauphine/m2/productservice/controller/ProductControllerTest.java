package fr.dauphine.m2.productservice.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import fr.dauphine.m2.productservice.metier.ProductService;
import fr.dauphine.m2.productservice.models.Product;
import fr.dauphine.m2.productservice.rest.ProductController;

@ExtendWith(SpringExtension.class)
@AutoConfigureJsonTesters
@WebMvcTest(ProductController.class)
public class ProductControllerTest {

	@MockBean
	private ProductService productService;
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private JacksonTester<List<Product>> json;
	
	@Test
	public void testGetAll() throws Exception {
		// Given
		Product p = new Product();
		p.setId(1L);
		p.setDescription("Desc");
		List<Product> products = new ArrayList<>();
		Collections.addAll(products, p);
		BDDMockito.given(productService.getAll()).willReturn(products);
		
		// when
        MockHttpServletResponse response = mvc.perform(
        		MockMvcRequestBuilders
                        .get("/api/v1/products")
                                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();
        
        // then
        BDDAssertions.then(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        BDDAssertions.then(response.getContentAsString())
                .isEqualTo(json.write(products).getJson());
	}
}
