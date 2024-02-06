package br.com.nautilus.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.nautilus.configuration.CustomerServiceConfiguration;
import br.com.nautilus.model.CustomerModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Customers Endpoint")
@RestController
@RequestMapping("/customer-service")
public class CustomerController {
	
	@Autowired
	private CustomerServiceConfiguration config;
	
	private final String template = "The customer id is: %s <br />Customer Service Version: %s";
	
	@Operation(summary = "Retorna dados básicos de um cliente")
	@GetMapping(value = "/customer/{id}")
	public String findCustomerById(
		@PathVariable("id") String id) {
		CustomerModel customer = new CustomerModel(
				id,
				"Wilian Fiabani",
				"83682112049",
				"fiabani.wilian@gmail.com"
		);
		ObjectMapper mapper = new ObjectMapper();
		
		try {			
			return mapper.writeValueAsString( customer );
		}catch(Exception e) {
			System.out.println(e);
			return "";
		}
	}
	
	@Operation(summary = "Retorna um valor parametrizado do server-config, apenas para fins de teste da funcionalidade")
	@GetMapping("/customer-service-version")
	public String getCustomerServiceVersion(){
		return String.format(template, config.getCustomerServiceVersion());
	}
	
	/*
	@GetMapping(value = "/jogo-do-bixo")
	public String jogoDoBixo() {
		try {
            
            URL url = new URL("https://www.ojogodobicho.com/deu_no_poste.htm");
             
            // read text returned by server
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
             
            String line;
            String all = "";
            while ((line = in.readLine()) != null) {
                all = all.concat(line);
            }
            in.close();
            
            org.jsoup.nodes.Document doc = Jsoup.parse(all);
            Elements tbody = doc.select("tbody");
            //System.out.println(tbody.first());
            
            // elements
            List<String> results = new ArrayList<String>();
            results.add(
            		"PPT;"
            		+tbody.first().child(0).child(1).text()+";"
            		+tbody.first().child(1).child(1).text()+";"
            		+tbody.first().child(2).child(1).text()+";"
            		+tbody.first().child(3).child(1).text()+";"
            		+tbody.first().child(4).child(1).text()+";"
            );
            results.add(
            		"PTM;"
            		+tbody.first().child(0).child(2).text()+";"
            		+tbody.first().child(1).child(2).text()+";"
            		+tbody.first().child(2).child(2).text()+";"
            		+tbody.first().child(3).child(2).text()+";"
            		+tbody.first().child(4).child(2).text()+";"
            );
            results.add(
            		"PT;"
            		+tbody.first().child(0).child(3).text()+";"
            		+tbody.first().child(1).child(3).text()+";"
            		+tbody.first().child(2).child(3).text()+";"
            		+tbody.first().child(3).child(3).text()+";"
            		+tbody.first().child(4).child(3).text()+";"
            );
            results.add(
            		"PTV;"
            		+tbody.first().child(0).child(4).text()+";"
            		+tbody.first().child(1).child(4).text()+";"
            		+tbody.first().child(2).child(4).text()+";"
            		+tbody.first().child(3).child(4).text()+";"
            		+tbody.first().child(4).child(4).text()+";"
            );
            results.add(
            		"PTN;"
            		+tbody.first().child(0).child(5).text()+";"
            		+tbody.first().child(1).child(5).text()+";"
            		+tbody.first().child(2).child(5).text()+";"
            		+tbody.first().child(3).child(5).text()+";"
            		+tbody.first().child(4).child(5).text()+";"
            );
            results.add(
            		"COR;"
            		+tbody.first().child(0).child(6).text()+";"
            		+tbody.first().child(1).child(6).text()+";"
            		+tbody.first().child(2).child(6).text()+";"
            		+tbody.first().child(3).child(6).text()+";"
            		+tbody.first().child(4).child(6).text()+";"
            );
            System.out.println(results);
            
            return all;
             
        }
        catch (MalformedURLException e) {
            System.out.println("Malformed URL: " + e.getMessage());
        }
        catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());
        }
        return "";
        
	}
	*/


}
