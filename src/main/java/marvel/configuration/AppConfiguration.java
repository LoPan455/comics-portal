package marvel.configuration;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories({"marvel.repository"})
public class AppConfiguration extends AbstractMongoConfiguration
{
	@Value("${public-api-key}")
	private String publicApiKey;

	@Value("${private-api-key}")
	private String privateApiKey;

	@Override
	public MongoClient mongoClient() {
		return new MongoClient();
	}

	@Override
	protected String getDatabaseName() {
		return "marvel";
	}
}
