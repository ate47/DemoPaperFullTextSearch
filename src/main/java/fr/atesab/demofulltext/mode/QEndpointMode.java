package fr.atesab.demofulltext.mode;

import fr.atesab.demofulltext.Config;
import fr.atesab.demofulltext.Triple;

import java.io.InputStream;
import java.util.Iterator;

public class QEndpointMode extends Mode {
	public QEndpointMode(Config config) {
		super(config, "qendpoint");
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
