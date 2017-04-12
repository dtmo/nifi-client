package com.tibtech.nifi.apibuilder;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class RestApiWriter
{
	public static void main(final String[] args)
	{
		final Options options = new Options();

		options.addOption(Option.builder().longOpt("package-prefix").desc("The package prefix for class builders")
				.numberOfArgs(1).argName("prefix").required().build());

		options.addOption(
				Option.builder().longOpt("output-path").desc("The path to which the generated code will be written")
						.numberOfArgs(1).argName("path").required().build());

		try
		{
			final CommandLine commandLine = new DefaultParser().parse(options, args);

			String outputPath = commandLine.getOptionValue("output-path");
			String packagePrefix = commandLine.getOptionValue("package-prefix");

			
		}
		catch (final ParseException e)
		{
			new HelpFormatter().printHelp("h", options);
		}
	}
}
