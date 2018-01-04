package net.blover.website;

import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import net.blover.website.framework.AccessIntercept;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.Filter;
import java.util.Date;
import java.util.List;

/**
 * Created by JackS on 2017/9/28.
 */
@SpringBootApplication
public class ApplicationWebsite {

    private static Logger log = LoggerFactory.getLogger(ApplicationWebsite.class);

    public static void main(String[] args) {
        SpringApplication.run(ApplicationWebsite.class, args);
    }

    /**
     * 添加处理编码过滤器
     * @return
     */
    @Bean
    public Filter characterFilter() {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceEncoding(true);
        return encodingFilter;
    }


    @Configuration
    public class MyWebConfig extends WebMvcConfigurerAdapter {
        /**
         * 添加拦截器
         * @param registry
         */
        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(new AccessIntercept()).addPathPatterns("/**");
            super.addInterceptors(registry);
        }

        @Override
        public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
            converters.add(new FormHttpMessageConverter());
            super.configureMessageConverters(converters);
            FastJsonHttpMessageConverter fastJsonConverter = new FastJsonHttpMessageConverter();
            FastJsonConfig fastConf = new FastJsonConfig();
            SerializeConfig config = new SerializeConfig();
            //配置日期格式
            config.put(Date.class, new SimpleDateFormatSerializer("yyyy-MM-dd HH:mm:ss"));
            fastConf.setSerializeConfig(config);
            fastConf.setSerializerFeatures(SerializerFeature.PrettyFormat);
            fastJsonConverter.setFastJsonConfig(fastConf);
            converters.add(fastJsonConverter);
        }
    }
}
