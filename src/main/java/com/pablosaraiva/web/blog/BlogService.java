package com.pablosaraiva.web.blog;

import com.github.rjeschke.txtmark.Processor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BlogService {
    public List<BlogPost> getLastPostsSummaries(int numberOfPosts) {
        return generatePosts(5);
    }

    private List<BlogPost> generatePosts(int numberOfPosts) {
        final List<BlogPost> blogPosts = new ArrayList<>(numberOfPosts);
        for (int i = 0; i < numberOfPosts; i++) {
            blogPosts.add(buildFakePost(UUID.randomUUID().toString()));
        }

        return blogPosts;
    }

    public BlogPost findById(String id) {
        return buildFakePost(id);
    }

    private BlogPost buildFakePost(String id) {
        final String content = Processor.process(
                "## TLS Protocols\n" +
                "\n" +
                "Today I saw this post on [StackExchange Meta](https://meta.stackexchange.com/questions/343302/tls-1-0-and-tls-1-1-removal-for-stack-exchange-services?cb=1)\n" +
                "saying Stack Exchange services do not support TLS 1.0 and TLS 1.1 anymore.\n" +
                "It happens that major web browser are also removing the support to this protocols because \n" +
                "they have known vulnerabilities.\n" +
                "\n" +
                "So I decided to do some check on my side.\n" +
                 "![alt text](/images/pablo.jpg \"Logo Title Text 1\")\n" +
                "\n" +
                "First, I learned how to check it with nmap what protocols my server was accepting.\n" +
                "\n" +
                "<pre>\n" +
                "nmap --script ssl-enum-ciphers -p 443 pablosaraiva.com\n" +
                "</pre>\n" +
                "\n" +
                "The response looks like this.\n" +
                "\n" +
                "<pre>\n" +
                "Starting Nmap 7.80 ( https://nmap.org ) at 2020-02-17 20:41 CET\n" +
                "Nmap scan report for pablosaraiva.com (212.115.110.74)\n" +
                "Host is up (0.021s latency).\n" +
                "\n" +
                "PORT    STATE SERVICE\n" +
                "443/tcp open  https\n" +
                "| ssl-enum-ciphers: \n" +
                "|   TLSv1.0: \n" +
                "|     ciphers: \n" +
                "|       TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA (secp256r1) - A\n" +
                "|       TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA (secp256r1) - A\n" +
                "|       TLS_RSA_WITH_AES_128_CBC_SHA (rsa 2048) - A\n" +
                "|       TLS_RSA_WITH_AES_256_CBC_SHA (rsa 2048) - A\n" +
                "|       TLS_RSA_WITH_CAMELLIA_128_CBC_SHA (rsa 2048) - A\n" +
                "|       TLS_RSA_WITH_CAMELLIA_256_CBC_SHA (rsa 2048) - A\n" +
                "|     compressors: \n" +
                "|       NULL\n" +
                "|     cipher preference: client\n" +
                "|   TLSv1.1: \n" +
                "|     ciphers: \n" +
                "|       TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA (secp256r1) - A\n" +
                "|       TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA (secp256r1) - A\n" +
                "|       TLS_RSA_WITH_AES_128_CBC_SHA (rsa 2048) - A\n" +
                "|       TLS_RSA_WITH_AES_256_CBC_SHA (rsa 2048) - A\n" +
                "|       TLS_RSA_WITH_CAMELLIA_128_CBC_SHA (rsa 2048) - A\n" +
                "|       TLS_RSA_WITH_CAMELLIA_256_CBC_SHA (rsa 2048) - A\n" +
                "|     compressors: \n" +
                "|       NULL\n" +
                "|     cipher preference: client\n" +
                "|   TLSv1.2: \n" +
                "|     ciphers: \n" +
                "|       TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA (secp256r1) - A\n" +
                "|       TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256 (secp256r1) - A\n" +
                "|       TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256 (secp256r1) - A\n" +
                "|       TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA (secp256r1) - A\n" +
                "|       TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384 (secp256r1) - A\n" +
                "|       TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384 (secp256r1) - A\n" +
                "|       TLS_ECDHE_RSA_WITH_ARIA_128_GCM_SHA256 (secp256r1) - A\n" +
                "|       TLS_ECDHE_RSA_WITH_ARIA_256_GCM_SHA384 (secp256r1) - A\n" +
                "|       TLS_ECDHE_RSA_WITH_CAMELLIA_128_CBC_SHA256 (secp256r1) - A\n" +
                "|       TLS_ECDHE_RSA_WITH_CAMELLIA_256_CBC_SHA384 (secp256r1) - A\n" +
                "|       TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256 (secp256r1) - A\n" +
                "|       TLS_RSA_WITH_AES_128_CBC_SHA (rsa 2048) - A\n" +
                "|       TLS_RSA_WITH_AES_128_CBC_SHA256 (rsa 2048) - A\n" +
                "|       TLS_RSA_WITH_AES_128_CCM (rsa 2048) - A\n" +
                "|       TLS_RSA_WITH_AES_128_CCM_8 (rsa 2048) - A\n" +
                "|       TLS_RSA_WITH_AES_128_GCM_SHA256 (rsa 2048) - A\n" +
                "|       TLS_RSA_WITH_AES_256_CBC_SHA (rsa 2048) - A\n" +
                "|       TLS_RSA_WITH_AES_256_CBC_SHA256 (rsa 2048) - A\n" +
                "|       TLS_RSA_WITH_AES_256_CCM (rsa 2048) - A\n" +
                "|       TLS_RSA_WITH_AES_256_CCM_8 (rsa 2048) - A\n" +
                "|       TLS_RSA_WITH_AES_256_GCM_SHA384 (rsa 2048) - A\n" +
                "|       TLS_RSA_WITH_ARIA_128_GCM_SHA256 (rsa 2048) - A\n" +
                "|       TLS_RSA_WITH_ARIA_256_GCM_SHA384 (rsa 2048) - A\n" +
                "|       TLS_RSA_WITH_CAMELLIA_128_CBC_SHA (rsa 2048) - A\n" +
                "|       TLS_RSA_WITH_CAMELLIA_128_CBC_SHA256 (rsa 2048) - A\n" +
                "|       TLS_RSA_WITH_CAMELLIA_256_CBC_SHA (rsa 2048) - A\n" +
                "|       TLS_RSA_WITH_CAMELLIA_256_CBC_SHA256 (rsa 2048) - A\n" +
                "|     compressors: \n" +
                "|       NULL\n" +
                "|     cipher preference: client\n" +
                "|_  least strength: A\n" +
                "</pre>\n" +
                "\n" +
                "It lists all the accepted protocols and ciphers.\n" +
                "\n" +
                "As you can see, my server does support TLS 1.2 already. But it is also accepting TLS 1.0 and 1.1.\n" +
                "\n" +
                "I went to my nginx configuration file, nginx-prod.conf and added the following line \n" +
                "to the server block.\n" +
                "\n" +
                "<pre>\n" +
                "      ssl_protocols TLSv1.2;\n" +
                "</pre>\n" +
                "\n" +
                "After restarting nginx with the new configuration, this is what I get from nmap.\n" +
                "\n" +
                "<pre>\n" +
                "Starting Nmap 7.80 ( https://nmap.org ) at 2020-02-17 20:55 CET\n" +
                "Nmap scan report for pablosaraiva.com (212.115.110.74)\n" +
                "Host is up (0.024s latency).\n" +
                "\n" +
                "PORT    STATE SERVICE\n" +
                "443/tcp open  https\n" +
                "| ssl-enum-ciphers: \n" +
                "|   TLSv1.2: \n" +
                "|     ciphers: \n" +
                "|       TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA (secp256r1) - A\n" +
                "|       TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256 (secp256r1) - A\n" +
                "|       TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256 (secp256r1) - A\n" +
                "|       TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA (secp256r1) - A\n" +
                "|       TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384 (secp256r1) - A\n" +
                "|       TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384 (secp256r1) - A\n" +
                "|       TLS_ECDHE_RSA_WITH_ARIA_128_GCM_SHA256 (secp256r1) - A\n" +
                "|       TLS_ECDHE_RSA_WITH_ARIA_256_GCM_SHA384 (secp256r1) - A\n" +
                "|       TLS_ECDHE_RSA_WITH_CAMELLIA_128_CBC_SHA256 (secp256r1) - A\n" +
                "|       TLS_ECDHE_RSA_WITH_CAMELLIA_256_CBC_SHA384 (secp256r1) - A\n" +
                "|       TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256 (secp256r1) - A\n" +
                "|       TLS_RSA_WITH_AES_128_CBC_SHA (rsa 2048) - A\n" +
                "|       TLS_RSA_WITH_AES_128_CBC_SHA256 (rsa 2048) - A\n" +
                "|       TLS_RSA_WITH_AES_128_CCM (rsa 2048) - A\n" +
                "|       TLS_RSA_WITH_AES_128_CCM_8 (rsa 2048) - A\n" +
                "|       TLS_RSA_WITH_AES_128_GCM_SHA256 (rsa 2048) - A\n" +
                "|       TLS_RSA_WITH_AES_256_CBC_SHA (rsa 2048) - A\n" +
                "|       TLS_RSA_WITH_AES_256_CBC_SHA256 (rsa 2048) - A\n" +
                "|       TLS_RSA_WITH_AES_256_CCM (rsa 2048) - A\n" +
                "|       TLS_RSA_WITH_AES_256_CCM_8 (rsa 2048) - A\n" +
                "|       TLS_RSA_WITH_AES_256_GCM_SHA384 (rsa 2048) - A\n" +
                "|       TLS_RSA_WITH_ARIA_128_GCM_SHA256 (rsa 2048) - A\n" +
                "|       TLS_RSA_WITH_ARIA_256_GCM_SHA384 (rsa 2048) - A\n" +
                "|       TLS_RSA_WITH_CAMELLIA_128_CBC_SHA (rsa 2048) - A\n" +
                "|       TLS_RSA_WITH_CAMELLIA_128_CBC_SHA256 (rsa 2048) - A\n" +
                "|       TLS_RSA_WITH_CAMELLIA_256_CBC_SHA (rsa 2048) - A\n" +
                "|       TLS_RSA_WITH_CAMELLIA_256_CBC_SHA256 (rsa 2048) - A\n" +
                "|     compressors: \n" +
                "|       NULL\n" +
                "|     cipher preference: client\n" +
                "|_  least strength: A\n" +
                "\n" +
                "Nmap done: 1 IP address (1 host up) scanned in 2.28 seconds\n" +
                "</pre>\n" +
                "\n" +
                "Much better! TLS 1.0 and 1.1 are not accepted anymore!\n" +
                "\n" +
                "The [ssl labs](https://www.ssllabs.com/ssltest) ssl test make a very nice report about the\n" +
                "ssl configuration of your web server. I checked the result and made three more improvements.\n" +
                "\n" +
                "## Cipher Suites\n" +
                "\n" +
                "For all those ciphers accepted by my server, only five are listed as secure from the ssl test.\n" +
                "The others are considered weak.\n" +
                "\n" +
                "So now, I will set my server to prefer those secure ciphers. Also, to use server preference instead\n" +
                "of client preference during handshake. \n" +
                "\n" +
                "Added the following two lines to my nginx configuration.\n" +
                "\n" +
                "      ssl_prefer_server_ciphers on;\n" +
                "      ssl_ciphers 'ECDHE-ECDSA-AES128-GCM-SHA256:ECDHE-ECDSA-CHACHA20-POLY1305:ECDHE-RSA-AES128-GCM-SHA256:ECDHE-RSA-CHACHA20-POLY1305:ECDHE+AES128:RSA+AES128:ECDHE+AES256:RSA+AES256:ECDHE+3DES:RSA+3DES';\n" +
                "\n" +
                "## DNS CAA Entry\n" +
                "\n" +
                "My DNS now have a CAA entry in place.\n" +
                "<pre>\n" +
                "| Type   | Domain Name      | Value           | TTL  | Tag   |\n" +
                "|--------|------------------|-----------------|------|-------|\n" +
                "| CAA    | pablosaraiva.com | letsencrypt.org | 3599 | issue |\n" +
                "</pre>\n" +
                "## HSTS\n" +
                "\n" +
                "I only serve my web app via https.\n" +
                "\n" +
                "If you try to access it via http, you will be redirected to the https version.\n" +
                "\n" +
                "Today I have also learned that I can add a header that will inform the browser that this\n" +
                "site is only served via https, the HSTS header.\n" +
                "\n" +
                "So if you try to access it via http again, the browser will do an internal redirect and will\n" +
                "call the https version, without having to make the http call to be redirected by my server.\n" +
                "\n" +
                "To set up the HSTS header, all I needed to do was to add this to my nginx configuration.\n" +
                "\n" +
                "<pre>\n" +
                "      add_header Strict-Transport-Security \"max-age=31536000; includeSubDomains\" always;\n" +
                "</pre>\n" +
                "\n" +
                "\uD83C\uDF89");

        return new BlogPost(
                "Improving security",
                content,
                "This is the summary", LocalDateTime.of(2020, 8, 22, 8, 18));
    }
}
