package start.config;

import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class ServletConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    // этот метод не используем
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    // Сюда поставляем наш класс Конфигурацию (с настройками бинов)
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {SpringConfig.class};
    }

    // Перенаправляем все запросы на Диспетчер Сервлет ()
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

    //!  Данный фильтр для обработки запросов (PATCH and DELETE) через форму например
    @Override
    public void onStartup(ServletContext aServletContext) throws ServletException {
        super.onStartup(aServletContext);
        registerHiddenFieldFilter(aServletContext);
    }

    private void registerHiddenFieldFilter(ServletContext aContext) {
        aContext.addFilter("hiddenHttpMethodFilter",
                new HiddenHttpMethodFilter()).addMappingForUrlPatterns(null ,true, "/*");
    }


}
