package com.example;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.Processor;
import org.apache.camel.Exchange;

/**
 * A simple Camel route that triggers from a timer and calls a bean and prints to system out.
 * <p/>
 * Use <tt>@Component</tt> to make Camel auto detect this route when starting.
 */
@Component
public class MySpringBootRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        restConfiguration()
        	.component("servlet")
        	.bindingMode(RestBindingMode.auto);

        rest("/api")
        	.post("/customer")
        	//.type()
        	.route()
        	.log("The body is ${body}!!")
        	.transform().simple("The name in body is ${body}")
        	.endRest()
        	
        	.put("/customer")
        	//.type()
        	.route()
        	.log("The body is ${body}!!")
//        	.process(new Processor() {
//	            @Override
//	            public void process(Exchange exchange) throws Exception {
//	                BeanDatos beanDatos = exchange.getMessage().getBody(BeanDatos.class);
//	                beanDatos.setEdad("15");
//	                exchange.getMessage().setBody(beanDatos);
//	            }
//        	})
        	.to("https://run.mocky.io/v3/3334df41-5550-4527-8a2a-fb682dae4f8f?bridgeEndpoint=true&throwExceptionOnFailure=false")
        	.to("stream:out")
        	//.log("${body}")
        	.endRest();

//        from("timer:hello?period={{timer.period}}").routeId("hello")
//            .transform().method("myBean", "saySomething")
//            .filter(simple("${body} contains 'foo'"))
//                .to("log:foo")
//            .end()
//            .to("stream:out")
            
         //  .to("https://run.mocky.io/v3/4e1f861e-6a7f-4ca1-85e7-e35bceee5b51")
           //.to("stream:header")
//	        .choice()
//	        .when(simple("${header.CamelHttpResponseCode} == '200'"))
//	        	.to("stream:out")
//	        .otherwise()
//	            .log("No tenia datos la respuesta");
       // http://10.1.99.27:8080/integrator/receipt-simple-confirm?between={"start": "2018-05-01", "end": "2018-06-12"}
    }

}
