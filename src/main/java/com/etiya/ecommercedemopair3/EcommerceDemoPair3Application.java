package com.etiya.ecommercedemopair3;

import com.etiya.ecommercedemopair3.core.util.exceptions.BusinessException;
import com.etiya.ecommercedemopair3.core.util.results.ErrorDataResult;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@SpringBootApplication
@Configuration
@EnableJpaRepositories(basePackages = {"com.etiya.ecommercedemopair3.repository.abstracts"})
@RestControllerAdvice
public class EcommerceDemoPair3Application {

	public static void main(String[] args) {

		SpringApplication.run(EcommerceDemoPair3Application.class, args);

	}
	@Bean
	public ModelMapper getModelMapper(){

		return new ModelMapper();
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exception)
	{
		//Validation exception handle edildi.
		//TODA:ErrorDataResult olarak hataları döndür.
		Map<String,String> errors=new HashMap<>();
		//ErrorDataResult<String> hata=new ErrorDataResult<String>();

		for(FieldError fieldError : exception.getBindingResult().getFieldErrors())
		{
			errors.put(fieldError.getField(),fieldError.getDefaultMessage());

		}
		return new ErrorDataResult<>(errors,"Not valid exception") ;
	}
	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	//BusinessException Handle edildi

	public  ErrorDataResult<Object> handleBusinessException(BusinessException businessException) {
		ErrorDataResult<Object> errorDataResult = new ErrorDataResult<Object>(businessException.getMessage(), "BUSINESS.EXCEPTION");
		return errorDataResult;

	}
	@Bean
	public ResourceBundleMessageSource bundleMessageSource(){
		// Veritabanı bağlantısı..
		// Dosyadan çekme işlemi..
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		// Konfigurasyonlar
		// Veritabanına git
		// Select * from Languages Where code='tr' and key='greetings'
		// isteğinden dönen cevap senin çevirindir.
		messageSource.setBasename("messages");
		//
		return messageSource;
	}

	// Kullanıcıdan dil tercihini header alanından al..
	// Accept-Language
	@Bean
	public LocaleResolver localeResolver(){
		//Session,Cookie
		// Header => Her istekte headerda bir değer varsa bunu baz al.
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		// Accept-Language alanı boş ise default olarak 'US' alanı olarak değerlendir.
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}
}
