package com.cosmos.cosmos.config;

import com.azure.spring.data.cosmos.repository.config.EnableCosmosRepositories;
import com.cosmos.cosmos.constant.ExternalConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.azure.cosmos.CosmosClientBuilder;
import com.azure.cosmos.DirectConnectionConfig;
import com.azure.spring.data.cosmos.config.AbstractCosmosConfiguration;
import com.azure.spring.data.cosmos.config.CosmosConfig;
import com.azure.spring.data.cosmos.core.ResponseDiagnostics;
import com.azure.spring.data.cosmos.core.ResponseDiagnosticsProcessor;

import io.micrometer.common.lang.Nullable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.PropertySource;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Configuration
@EnableCosmosRepositories(basePackages = "com.cosmos.cosmos.repository")
@Slf4j
public class CosmosCrudAppConfiguration extends AbstractCosmosConfiguration {

	private final ExternalConstant extConstant;

	public CosmosCrudAppConfiguration(ExternalConstant extConstant) {
		this.extConstant = extConstant;
    }

	@Bean
	public CosmosClientBuilder cosmosClientBuilder() {
		//2.-se llama aqui para que inmediatamente los jale, y no tenga probelmas la conexion
		getApplicationProperties();
		DirectConnectionConfig directConnectionConfig = DirectConnectionConfig.getDefaultConfig();
		return new CosmosClientBuilder().endpoint(extConstant.getUri()).key(extConstant.getKey())
				.directMode(directConnectionConfig);
	}

	@Override
	protected String getDatabaseName() {
		//3.-AQUI VA LA BASE DE DATOS COMO LA TENEMOS LLAMADA EN COSMOS emulator
		return "data";
	}

	//1.-metodo que nos ayuda a jalar la propiedad para el cert,
	// desde los que estan en windows instalados "javax.net.ssl.trustStoreType"
	private void getApplicationProperties(){
		Properties properties1 = new Properties();
		try (InputStream input = new FileInputStream("src/main/resources/application.properties")) {
			properties1.load(input);
			for (String key : properties1.stringPropertyNames()) {
				System.setProperty(key, properties1.getProperty(key));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
