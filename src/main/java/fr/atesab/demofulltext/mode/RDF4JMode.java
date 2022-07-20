package fr.atesab.demofulltext.mode;

import fr.atesab.demofulltext.Config;
import fr.atesab.demofulltext.Triple;

import java.io.InputStream;
import java.util.Iterator;

public class RDF4JMode extends Mode {
	public RDF4JMode(Config config) {
		super(config, "rdf4j");
	}

	@Override
	public void init() throws RunModeException {
		throw new RunModeException("not implemented yet");
	}

	@Override
	public void start(InputStream dataset) throws RunModeException {
		throw new RunModeException("not implemented yet");
	}

	@Override
	public Iterator<Triple> query(String textQuery) throws RunModeException {
		throw new RunModeException("not implemented yet");
	}
}
