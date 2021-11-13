package de.zyfy.zypapi.dataStoring;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Config {
	File file;
	FileConfiguration fileConfiguration;

	public Config(String name, File path) {
		file = new File(path, name);

		if(!file.exists()) {
			if(path.mkdirs()) {
				try {
					if(file.createNewFile()) {
						fileConfiguration = new YamlConfiguration();

						try {
							fileConfiguration.load(file);
						} catch (IOException | InvalidConfigurationException exception) {
							exception.printStackTrace();
						}
					}
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			}
		}
	}

	public File getFile() {
		return file;
	}

	public FileConfiguration getFileConfiguration() {
		return fileConfiguration;
	}

	public void save() {
		try {
			fileConfiguration.save(file);
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}

	public void load() {
		try {
			fileConfiguration.load(file);
		} catch (IOException | InvalidConfigurationException exception) {
			exception.printStackTrace();
		}
	}
}
