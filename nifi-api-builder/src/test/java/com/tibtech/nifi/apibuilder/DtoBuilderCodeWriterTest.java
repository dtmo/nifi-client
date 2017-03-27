package com.tibtech.nifi.apibuilder;

import static org.junit.Assert.*;

import org.apache.nifi.web.api.dto.SnippetDTO;
import org.junit.Test;

import com.squareup.javapoet.TypeSpec;

public class DtoBuilderCodeWriterTest extends DtoBuilderCodeWriter
{

	@Test
	public void testCreateDtoBuilderTypeSpec() throws Exception
	{
		TypeSpec snippetDtoBuilderSpec = DtoBuilderCodeWriter.createDtoBuilderTypeSpec(SnippetDTO.class, null);
	}

}
