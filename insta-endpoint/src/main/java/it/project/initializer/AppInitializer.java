package it.project.initializer;
import org.springframework.stereotype.Component;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import javax.servlet.*;

@Component
public class AppInitializer implements WebApplicationInitializer
{
	@Override
	public void onStartup( ServletContext servletContext ) throws ServletException
	{

		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register( it.project.initializer.AppConfig.class );
		rootContext.setServletContext( servletContext );

		servletContext.addListener( new ContextLoaderListener( rootContext ) );

		ServletRegistration.Dynamic dispatcher = servletContext.addServlet( "dispatcher",
				new DispatcherServlet( rootContext ) );
		dispatcher.addMapping( "/" );
		dispatcher.setLoadOnStartup( 1 );


	}


}
