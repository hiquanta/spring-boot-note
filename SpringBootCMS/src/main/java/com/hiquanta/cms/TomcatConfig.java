//package com.hiquanta.cms;
//
//import org.apache.catalina.Context;
//import org.apache.catalina.connector.Connector;
//import org.apache.tomcat.util.descriptor.web.SecurityCollection;
//import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
//import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
//import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
//import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
//import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.Resource;
//
//import java.io.IOException;
//
///**
// * Created by hiquanta on 2016/10/26.
// */
//@Configuration
//public class TomcatConfig {
//    private static final Logger logger = LoggerFactory.getLogger(TomcatConfig.class);
//
//    @Bean
//    public EmbeddedServletContainerFactory servletContainer() {
//
//        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory() {
//
//            @Override
//            protected void postProcessContext(Context context) {
//
//                SecurityConstraint securityConstraint = new SecurityConstraint();
//                securityConstraint.setUserConstraint("CONFIDENTIAL");
//                SecurityCollection collection = new SecurityCollection();
//                collection.addPattern("/*");
//                securityConstraint.addCollection(collection);
//                context.addConstraint(securityConstraint);
//            }
//        };
//        tomcat.addAdditionalTomcatConnectors(initiateHttpConnector());
//        return tomcat;
//    }
//    @Bean(name = "tomcatCustomizer")
//    public EmbeddedServletContainerCustomizer containerCustomizer() {
//        return new EmbeddedServletContainerCustomizer() {
//            @Override public void customize(ConfigurableEmbeddedServletContainer container) {
//                if (container instanceof TomcatEmbeddedServletContainerFactory) {
//                    TomcatEmbeddedServletContainerFactory tomcatFactory =
//                            (TomcatEmbeddedServletContainerFactory) container;
//                    tomcatFactory.addConnectorCustomizers(sslConnectorCustomizer());
//                }
//            }
//        };
//    }
//    @Value("${connector.https.enabled}")
//    private Boolean httpsEnabled;
//    @Value("${connector.https.keystoreFile}")
//    private String keystoreFile;
//    @Value("${connector.https.keystorePass}")
//    private String keystorePass;
//    @Value("${connector.https.keyAlias}")
//    private String keyAlias;
//
//    @Bean(name = "tomcatSslConnectorCustomizer")
//    public TomcatConnectorCustomizer sslConnectorCustomizer() {
//
//        if (!httpsEnabled) {
//            return new TomcatConnectorCustomizer() {
//                @Override public void customize(Connector connector) {
//                }
//            };
//        }
//
//        return new TomcatConnectorCustomizer() {
//            @Override public void customize(Connector connector) {
//                connector.setSecure(true);
//                connector.setScheme("https");
//                connector.setAttribute("keyAlias", keyAlias);
//                connector.setAttribute("keystorePass", keystorePass);
//                try {
//                    connector.setAttribute("keystoreFile", keystoreFile);
//                } catch (Exception e) {
//                    logger.error("cannot load keystore", e);
//                    throw new IllegalStateException("Cannot load keystore", e);
//                }
//                connector.setAttribute("clientAuth", "false");
//                connector.setAttribute("sslProtocol", "TLS");
//                connector.setAttribute("SSLEnabled", true);
//            }
//        };
//    }
//    private Connector initiateHttpConnector() {
//
//        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
//        connector.setScheme("http");
//        connector.setPort(8081);
//        connector.setSecure(false);
//        connector.setRedirectPort(8443);
//        return connector;
//    }
//}
