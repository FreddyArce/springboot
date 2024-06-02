package bo.emi.configuration;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean(name = "obtenerEstudiantes")
    public DefaultWsdl11Definition obtenerEstudiantesDefinition(XsdSchema estudiantesSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("ObtenerEstudiantesPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://emi.bo/estudiantes");
        wsdl11Definition.setSchema(estudiantesSchema);
        return wsdl11Definition;
    }

    @Bean(name = "registrarEstudiante")
    public DefaultWsdl11Definition registrarEstudianteDefinition(XsdSchema estudiantesSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("RegistrarEstudiantePort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://emi.bo/app");
        wsdl11Definition.setSchema(estudiantesSchema);
        return wsdl11Definition;
    }

    @Bean(name = "actualizarEstudiante")
    public DefaultWsdl11Definition actualizarEstudianteDefinition(XsdSchema estudiantesSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("ActualizarEstudiantePort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://emi.bo/app");
        wsdl11Definition.setSchema(estudiantesSchema);
        return wsdl11Definition;
    }

    /*@Bean(name = "obtenerDocentes")
    public DefaultWsdl11Definition obtenerDocentesDefinition(XsdSchema docentesSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("ObtenerDocentesPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://emi.bo/app");
        wsdl11Definition.setSchema(docentesSchema);
        return wsdl11Definition;
    }*/

    @Bean
    public XsdSchema estudiantesSchema() {
        return new SimpleXsdSchema(new ClassPathResource("estudiantes.xsd"));
    }

    /*@Bean
    public XsdSchema docentesSchema() {
        return new SimpleXsdSchema(new ClassPathResource("docentes.xsd"));
    }*/

}
