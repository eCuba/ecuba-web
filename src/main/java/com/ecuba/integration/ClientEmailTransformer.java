package com.ecuba.integration;

import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.compressors.CompressorOutputStream;
import org.apache.commons.compress.compressors.CompressorStreamFactory;
import org.apache.commons.compress.utils.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.messaging.Message;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rolando on 2014-08-24.
 */
public class ClientEmailTransformer {

	@Transformer
	public Object process(final Message<?> message) throws Exception {

		MimeMessage emailMessage = (MimeMessage) message.getPayload();
		InternetAddress address = (InternetAddress) emailMessage.getFrom()[0];

		Map<String, Object> newHeaders = new HashMap<>();
		newHeaders.put("mail_from", "rolo@ecuba.com");
		newHeaders.put("mail_to", address.getAddress());
		newHeaders.put("mail_subject", "ecuba-test-response");

		String exampleString = "hola baby here i am!!hola baby here i am!!hola baby here i am!!hola baby here i am!!hola baby here i am!!hola baby here i am!!hola baby here i am!!hola baby here i am!!hola baby here i am!!hola baby here i am!!hola baby here i am!!hola baby here i am!!hola baby here i am!!hola baby here i am!!";

		InputStream stream = new ByteArrayInputStream(exampleString.getBytes(StandardCharsets.UTF_8));

		ArchiveInputStream ais = new
				ArchiveStreamFactory().createArchiveInputStream(ArchiveStreamFactory.ZIP,
				stream);


		File zipfile = new File(System.getProperty("java.io.tmpdir"), "data.zip");

		final OutputStream os = new FileOutputStream(zipfile);
		ArchiveOutputStream aos = new
				ArchiveStreamFactory().createArchiveOutputStream(ArchiveStreamFactory.ZIP,
				os);

		aos.putArchiveEntry(new ZipArchiveEntry("data.json"));
		IOUtils.copy(stream, aos);
		aos.closeArchiveEntry();

		aos.close();
		//os.close();

		System.setProperty("mail.mime.multipart.allowempty","true");

		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(emailMessage,true);
		mimeMessageHelper.addAttachment("data.zip",zipfile);


		return MessageBuilder.withPayload(message.getPayload()).copyHeaders(message.getHeaders()).copyHeaders(newHeaders).build();

	}

	;
}
