package com.tibtech.nifi.apibuilder;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import com.squareup.javapoet.JavaFile;

public class ConfigurableComponentPropertiesBuilderWriter
{
	public static void main(final String[] args) throws Exception
	{
		final Options options = new Options();

		try
		{
			final CommandLine commandLine = new DefaultParser().parse(options, args);

			final String[] commandArgs = commandLine.getArgs();

			if (commandArgs.length == 1)
			{
				final Path outputPath = Paths.get(commandArgs[0]);

				for (PackagedTypeSpec packagedTypeSpec : ConfigurableComponentPropertiesBuilderTypeSpecBuilderFactory
						.createConfigurableComponentPropertiesBuilderTypeSpecs("org.apache.nifi",
								s -> s.replaceFirst("org\\.apache", "com.tibtech")))
				{
					final JavaFile javaFile = JavaFile
							.builder(packagedTypeSpec.getPackageName(), packagedTypeSpec.getTypeSpec()).build();

					javaFile.writeTo(outputPath);
				}
			}
			else
			{
				throw new ParseException("Expected 1 command argument but found " + commandArgs.length);
			}
		}
		catch (final ParseException e)
		{
			new HelpFormatter().printHelp("output-path", options);
		}
	}
}
