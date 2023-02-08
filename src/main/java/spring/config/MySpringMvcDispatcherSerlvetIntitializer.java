package spring.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MySpringMvcDispatcherSerlvetIntitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() { //Just in these methods we will substitute small pieces of code that will make the configuration work
        return null; //This one is not used
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringConfig.class}; //Now knows where the spring configuration is
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"}; //All requests from the user are sent to the dispatcher servlet
    } //Inherit from abstract, where all methods are
}
