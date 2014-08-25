package com.ecuba.integration;

import org.apache.log4j.Logger;
import org.springframework.integration.annotation.Transformer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rolando on 2014-08-23.
 */
public class EmailTransformer {

	private static final Logger LOGGER = Logger.getLogger(EmailTransformer.class);

	@Transformer
	public List<EmailFragment> transformit(javax.mail.Message mailMessage) {

		final List<EmailFragment> emailFragments = new ArrayList<>();

		EmailParserUtils.handleMessage(null, mailMessage, emailFragments);

		if (LOGGER.isInfoEnabled()) {
			LOGGER.info(String.format("Email contains %s fragments.", emailFragments.size()));
		}

		return emailFragments;
	}

}
