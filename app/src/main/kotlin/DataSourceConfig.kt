import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.boot.jdbc.DataSourceBuilder
import javax.sql.DataSource


//@Configuration(proxyBeanMethods = false)
//class DataSourceConfig {
//
//    @Bean
//    @ConfigurationProperties("spring.datasource")
//    fun dataSource(): DataSource {
//        return DataSourceBuilder.create().build()
//    }
//}