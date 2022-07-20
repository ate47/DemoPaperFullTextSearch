package fr.atesab.demofulltext;

import fr.atesab.demofulltext.mode.Mode;
import fr.atesab.demofulltext.mode.Modes;
import fr.atesab.demofulltext.mode.RunModeException;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.rdfhdt.hdt.util.io.IOUtil;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Start {
	public static void main(String[] args) throws ParseException, RunModeException, IOException {
		Option jenaOpt = new Option("j", "jena", false, "use Apache Jena");
		Option rdf4jOpt = new Option("r", "rdf4j", false, "use RDF4J");
		Option qendpointOpt = new Option("q", "qendpoint", false, "use qEndpoint");
		Option allOpt = new Option("a", "all", false, "use all endpoint");
		Option resetConfigOpt = new Option("R", "reset", false, "reset config");
		Option helpOpt = new Option("h", "help", false, "print help");
		Options options = new Options()
				.addOption(jenaOpt)
				.addOption(rdf4jOpt)
				.addOption(qendpointOpt)
				.addOption(helpOpt)
				.addOption(resetConfigOpt)
				.addOption(allOpt);

		CommandLineParser parser = new DefaultParser();
		CommandLine cl = parser.parse(options, args);

		List<Mode> modes = new ArrayList<>();

		boolean all = cl.hasOption(allOpt);

		Config cfg = Config.syncConfig(Path.of("config.json"), cl.hasOption(resetConfigOpt));

		if (all || cl.hasOption(jenaOpt)) {
			modes.add(Modes.jena(cfg));
		}

		if (all || cl.hasOption(rdf4jOpt)) {
			modes.add(Modes.rdf4J(cfg));
		}

		if (all || cl.hasOption(qendpointOpt)) {
			modes.add(Modes.qendpoint(cfg));
		}

		if (modes.isEmpty() || cl.hasOption(helpOpt)) {
			HelpFormatter formatter = new HelpFormatter();
			formatter.printHelp("Demo full text", options, true);
			return;
		}

		for (Mode mode: modes) {
			System.out.println("run mode " + mode.getName());
			mode.init();
			try (InputStream stream = IOUtil.getFileInputStream(cfg.getDatasetFile())) {
				mode.start(stream);
			}
			Iterator<Triple> query = mode.query("my query");

			query.forEachRemaining(s -> System.out.println(s.toNt()));
		}
	}
}
