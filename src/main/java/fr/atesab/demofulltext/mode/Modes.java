package fr.atesab.demofulltext.mode;

import fr.atesab.demofulltext.Config;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Modes {
	public static Mode jena(Config cfg) {
		return new JenaMode(cfg);
	}
	public static Mode rdf4J(Config cfg) {
		return new RDF4JMode(cfg);
	}
	public static Mode qendpoint(Config cfg) {
		return new QEndpointMode(cfg);
	}
}
