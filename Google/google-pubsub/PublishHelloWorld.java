// camel-k: language=java
// camel-k: property=projectId=development-281118 property=destinationName=hello-topic

import org.apache.camel.builder.RouteBuilder;

public class PublishHelloWorld extends RouteBuilder {
  @Override
  public void configure() throws Exception {
    from("timer:hello?period=10000").routeId("hello").setBody().simple("Hello World")
        .log("Try to publish Hello World to {{destinationName}}")
        .to("google-pubsub://{{projectId}}:{{destinationName}}");

  }
}
