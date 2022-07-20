package fr.atesab.demofulltext;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * config file sync object
 */
@Data
public class Config {
	private static final ObjectMapper MAPPER = new ObjectMapper();
	/**
	 * read and save a config into a file
	 * @param p the file
	 * @param reset if the file should be reset
	 * @return config
	 * @throws IOException read/write exception
	 */
	public static Config syncConfig(Path p, boolean reset) throws IOException {
		Config cfg;
		if (!reset && Files.exists(p)) {
			try (InputStream is = Files.newInputStream(p)) {
				cfg = MAPPER.readValue(is, Config.class);
			}
		} else {
			cfg = new Config();
		}
		cfg.save(p);
		return cfg;
	}

	private String workDir = "demo-ft";
	private String datasetFile = "dataset.nt.gz";

	/**
	 * save the config to a file
	 * @param p the file
	 * @throws IOException write exception
	 */
	public void save(Path p) throws IOException {
		try (OutputStream os = Files.newOutputStream(p)) {
			MAPPER.writerWithDefaultPrettyPrinter().writeValue(os, this);
		}
	}
}
