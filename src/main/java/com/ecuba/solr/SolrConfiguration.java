package com.ecuba.solr;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrOperations;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;
import org.springframework.data.solr.server.support.EmbeddedSolrServerFactory;

/**
 * Created by rolando on 2014-08-26.
 */

@Configuration
@EnableSolrRepositories(basePackages = "com.ecuba.solr.repository,com.ecuba.domain")
public class SolrConfiguration {

	@Value("${solr.url}")
	private String solrUrl;

	public void setSolrUrl(String solrUrl) {
		this.solrUrl = solrUrl;
	}

	@Bean(name="sorlServer")
	public SolrServer solrServer() {
		return new HttpSolrServer(solrUrl);
	}

	@Bean(name = "solrTemplate")
	public SolrOperations solrTemplate() {
		return new SolrTemplate(solrServer());
	}
}
