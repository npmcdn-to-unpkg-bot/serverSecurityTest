package com.sebhero.domain;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.security.core.GrantedAuthority;

import java.io.IOException;

/**
 * Created by seb on 2016-04-19.
 */
public class GrantedAuthoritySerializer extends JsonSerializer<GrantedAuthority> {

	@Override
	public void serialize(GrantedAuthority value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
		jgen.writeString(value.getAuthority());
	}
}
