package com.tibtech.nifi.apibuilder;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.apache.nifi.update.attributes.dto.RuleDTO;
import org.apache.nifi.update.attributes.entity.RuleEntity;
import org.apache.nifi.web.api.dto.AboutDTO;
import org.apache.nifi.web.api.entity.Entity;

import com.squareup.javapoet.JavaFile;

public class JavaBeanBuilderCodeWriter
{
	public static void main(final String[] args) throws Exception
	{
		final List<PackagedTypeSpec> packagedTypeSpecs = new ArrayList<>();
		final Function<String, String> packageNameMapper = (s) -> s.replaceFirst("org\\.apache", "com.tibtech");

		packagedTypeSpecs.addAll(JavaBeanBuilderFactory.getPackagesAndTypeSpecs(AboutDTO.class.getPackage().getName(),
				s -> s.endsWith("DTO"), packageNameMapper));
		packagedTypeSpecs.addAll(JavaBeanBuilderFactory.getPackagesAndTypeSpecs(Entity.class.getPackage().getName(),
				s -> s.endsWith("Entity"), packageNameMapper));

		packagedTypeSpecs.addAll(JavaBeanBuilderFactory.getPackagesAndTypeSpecs(RuleDTO.class.getPackage().getName(),
				s -> s.endsWith("DTO"), packageNameMapper));
		packagedTypeSpecs.addAll(JavaBeanBuilderFactory.getPackagesAndTypeSpecs(RuleEntity.class.getPackage().getName(),
				s -> s.endsWith("Entity"), packageNameMapper));

		final Path generatedJavaPath = Paths
				.get("../../nifi-1-client-parent/nifi-1.7.0-bean-builders/src/main/java");

		for (final PackagedTypeSpec packagedTypeSpec : packagedTypeSpecs)
		{
			final JavaFile javaFile = JavaFile
					.builder(packagedTypeSpec.getPackageName(), packagedTypeSpec.getTypeSpec()).build();

			javaFile.writeTo(generatedJavaPath);
		}
	}
}
