package foodtruckhabit.config;

import foodtruckhabit.loader.CSVLoader;
import foodtruckhabit.loader.Columns;
import foodtruckhabit.loader.Filenames;
import foodtruckhabit.model.MobileFoodFacilityPermit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "foodtruckhabit")
public class AppConfig {

	@Bean
	CSVLoader<MobileFoodFacilityPermit> permitsLoader() {

		return new CSVLoader<>(
				MobileFoodFacilityPermit.class,
				Filenames.SF_FOOD_TRUCKS,
				Columns.PERMITS);
	}
}