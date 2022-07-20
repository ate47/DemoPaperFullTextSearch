package fr.atesab.demofulltext.mode;

import fr.atesab.demofulltext.Config;
import fr.atesab.demofulltext.Triple;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.InputStream;
import java.util.Iterator;

/**
 * abstraction of an endpoint for Full text search
 */
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class Mode {
	@Getter
	protected final Config config;
	@Getter
	private final String name;

	/**
	 * init the endpoint
	 * @throws RunModeException init exception
	 */
	public abstract void init() throws RunModeException;
	/**
	 * start the endpoint to use it
	 * @param dataset the dataset, nt file format
	 * @throws RunModeException start exception
	 */
	public abstract void start(InputStream dataset) throws RunModeException;
	/**
	 * query a text query
	 * @param textQuery the text query
	 * @throws RunModeException query exception
	 */
	public abstract Iterator<Triple> query(String textQuery) throws RunModeException;
}
