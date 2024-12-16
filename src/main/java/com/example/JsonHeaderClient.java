package com.example;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.ByteArrayOutputStream;
import java.util.Base64;
import java.util.zip.GZIPOutputStream;

public class JsonHeaderClient {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

    // Example 10 KB JSON
    String json =
        "[{\"id\":1,\"first_name\":\"Susann\",\"last_name\":\"Leare\",\"email\":\"sleare0@t-online.de\",\"gender\":\"Female\",\"ip_address\":\"77.157.111.44\"},\n"
            + "{\"id\":2,\"first_name\":\"Fay\",\"last_name\":\"Whitley\",\"email\":\"fwhitley1@artisteer.com\",\"gender\":\"Female\",\"ip_address\":\"48.77.188.20\"},\n"
            + "{\"id\":3,\"first_name\":\"Nora\",\"last_name\":\"Tolcharde\",\"email\":\"ntolcharde2@e-recht24.de\",\"gender\":\"Female\",\"ip_address\":\"134.122.91.139\"},\n"
            + "{\"id\":4,\"first_name\":\"Gareth\",\"last_name\":\"Stenning\",\"email\":\"gstenning3@goodreads.com\",\"gender\":\"Male\",\"ip_address\":\"87.0.120.244\"},\n"
            + "{\"id\":5,\"first_name\":\"June\",\"last_name\":\"Pull\",\"email\":\"jpull4@topsy.com\",\"gender\":\"Genderfluid\",\"ip_address\":\"215.155.226.100\"},\n"
            + "{\"id\":6,\"first_name\":\"Dyanne\",\"last_name\":\"Scotcher\",\"email\":\"dscotcher5@nba.com\",\"gender\":\"Female\",\"ip_address\":\"10.208.98.132\"},\n"
            + "{\"id\":7,\"first_name\":\"Leonore\",\"last_name\":\"Sacaze\",\"email\":\"lsacaze6@sogou.com\",\"gender\":\"Female\",\"ip_address\":\"3.3.104.202\"},\n"
            + "{\"id\":8,\"first_name\":\"Marris\",\"last_name\":\"Gaveltone\",\"email\":\"mgaveltone7@myspace.com\",\"gender\":\"Female\",\"ip_address\":\"229.17.139.81\"},\n"
            + "{\"id\":9,\"first_name\":\"Latashia\",\"last_name\":\"Cullerne\",\"email\":\"lcullerne8@com.com\",\"gender\":\"Female\",\"ip_address\":\"145.202.246.194\"},\n"
            + "{\"id\":10,\"first_name\":\"Brod\",\"last_name\":\"Hazeltine\",\"email\":\"bhazeltine9@apache.org\",\"gender\":\"Male\",\"ip_address\":\"173.33.65.33\"},\n"
            + "{\"id\":11,\"first_name\":\"Reider\",\"last_name\":\"Pallesen\",\"email\":\"rpallesena@nsw.gov.au\",\"gender\":\"Male\",\"ip_address\":\"255.154.141.203\"},\n"
            + "{\"id\":12,\"first_name\":\"Rhona\",\"last_name\":\"Van Der Weedenburg\",\"email\":\"rvanderweedenburgb@studiopress.com\",\"gender\":\"Female\",\"ip_address\":\"204.163.130.162\"},\n"
            + "{\"id\":13,\"first_name\":\"Joann\",\"last_name\":\"Alexis\",\"email\":\"jalexisc@cloudflare.com\",\"gender\":\"Female\",\"ip_address\":\"152.143.233.243\"},\n"
            + "{\"id\":14,\"first_name\":\"Ainslee\",\"last_name\":\"Vallack\",\"email\":\"avallackd@ucoz.ru\",\"gender\":\"Female\",\"ip_address\":\"172.29.14.172\"},\n"
            + "{\"id\":15,\"first_name\":\"Gipsy\",\"last_name\":\"Lain\",\"email\":\"glaine@whitehouse.gov\",\"gender\":\"Female\",\"ip_address\":\"91.72.178.116\"},\n"
            + "{\"id\":16,\"first_name\":\"Wilden\",\"last_name\":\"Roels\",\"email\":\"wroelsf@google.com.au\",\"gender\":\"Male\",\"ip_address\":\"159.74.204.24\"},\n"
            + "{\"id\":17,\"first_name\":\"Mendel\",\"last_name\":\"Benneton\",\"email\":\"mbennetong@example.com\",\"gender\":\"Male\",\"ip_address\":\"61.249.182.10\"},\n"
            + "{\"id\":18,\"first_name\":\"Elbertine\",\"last_name\":\"Garrelts\",\"email\":\"egarreltsh@dot.gov\",\"gender\":\"Female\",\"ip_address\":\"232.148.132.80\"},\n"
            + "{\"id\":19,\"first_name\":\"Sayres\",\"last_name\":\"MacDonough\",\"email\":\"smacdonoughi@opensource.org\",\"gender\":\"Male\",\"ip_address\":\"16.111.138.167\"},\n"
            + "{\"id\":20,\"first_name\":\"Lorain\",\"last_name\":\"Jakubczyk\",\"email\":\"ljakubczykj@auda.org.au\",\"gender\":\"Female\",\"ip_address\":\"249.150.164.110\"},\n"
            + "{\"id\":21,\"first_name\":\"Rafe\",\"last_name\":\"Bratty\",\"email\":\"rbrattyk@wisc.edu\",\"gender\":\"Male\",\"ip_address\":\"237.174.226.215\"},\n"
            + "{\"id\":22,\"first_name\":\"Ernesta\",\"last_name\":\"Leat\",\"email\":\"eleatl@issuu.com\",\"gender\":\"Female\",\"ip_address\":\"193.11.177.92\"},\n"
            + "{\"id\":23,\"first_name\":\"Lind\",\"last_name\":\"Spencers\",\"email\":\"lspencersm@tiny.cc\",\"gender\":\"Genderfluid\",\"ip_address\":\"249.102.91.19\"},\n"
            + "{\"id\":24,\"first_name\":\"Bailie\",\"last_name\":\"Shrieve\",\"email\":\"bshrieven@youtube.com\",\"gender\":\"Male\",\"ip_address\":\"181.30.64.207\"},\n"
            + "{\"id\":25,\"first_name\":\"Almeta\",\"last_name\":\"Falkous\",\"email\":\"afalkouso@alibaba.com\",\"gender\":\"Female\",\"ip_address\":\"54.34.213.24\"},\n"
            + "{\"id\":26,\"first_name\":\"Krisha\",\"last_name\":\"Glencross\",\"email\":\"kglencrossp@weather.com\",\"gender\":\"Male\",\"ip_address\":\"153.96.59.81\"},\n"
            + "{\"id\":27,\"first_name\":\"Edd\",\"last_name\":\"Vickar\",\"email\":\"evickarq@ibm.com\",\"gender\":\"Male\",\"ip_address\":\"47.19.58.86\"},\n"
            + "{\"id\":28,\"first_name\":\"Jason\",\"last_name\":\"Warrick\",\"email\":\"jwarrickr@yellowbook.com\",\"gender\":\"Polygender\",\"ip_address\":\"129.203.154.180\"},\n"
            + "{\"id\":29,\"first_name\":\"Sophronia\",\"last_name\":\"Yanne\",\"email\":\"syannes@networkadvertising.org\",\"gender\":\"Female\",\"ip_address\":\"10.22.131.59\"},\n"
            + "{\"id\":30,\"first_name\":\"Hilarius\",\"last_name\":\"Checcuzzi\",\"email\":\"hcheccuzzit@storify.com\",\"gender\":\"Male\",\"ip_address\":\"60.3.205.94\"},\n"
            + "{\"id\":31,\"first_name\":\"Suzie\",\"last_name\":\"Parsley\",\"email\":\"sparsleyu@blinklist.com\",\"gender\":\"Female\",\"ip_address\":\"213.251.88.115\"},\n"
            + "{\"id\":32,\"first_name\":\"Faulkner\",\"last_name\":\"Ilyuchyov\",\"email\":\"filyuchyovv@shinystat.com\",\"gender\":\"Male\",\"ip_address\":\"188.223.71.249\"},\n"
            + "{\"id\":33,\"first_name\":\"Alene\",\"last_name\":\"Biffin\",\"email\":\"abiffinw@amazon.co.jp\",\"gender\":\"Female\",\"ip_address\":\"212.162.111.13\"},\n"
            + "{\"id\":34,\"first_name\":\"Bobbette\",\"last_name\":\"Fisby\",\"email\":\"bfisbyx@chicagotribune.com\",\"gender\":\"Female\",\"ip_address\":\"50.4.29.132\"},\n"
            + "{\"id\":35,\"first_name\":\"Anni\",\"last_name\":\"Scutt\",\"email\":\"ascutty@wordpress.org\",\"gender\":\"Female\",\"ip_address\":\"55.173.6.167\"},\n"
            + "{\"id\":36,\"first_name\":\"Jerrylee\",\"last_name\":\"Baigrie\",\"email\":\"jbaigriez@oracle.com\",\"gender\":\"Agender\",\"ip_address\":\"150.73.236.7\"},\n"
            + "{\"id\":37,\"first_name\":\"Neron\",\"last_name\":\"Nuzzetti\",\"email\":\"nnuzzetti10@japanpost.jp\",\"gender\":\"Male\",\"ip_address\":\"95.85.205.13\"},\n"
            + "{\"id\":38,\"first_name\":\"Alberto\",\"last_name\":\"Yitshak\",\"email\":\"ayitshak11@harvard.edu\",\"gender\":\"Genderqueer\",\"ip_address\":\"168.55.117.94\"},\n"
            + "{\"id\":39,\"first_name\":\"Carmelina\",\"last_name\":\"Duesbury\",\"email\":\"cduesbury12@flickr.com\",\"gender\":\"Genderqueer\",\"ip_address\":\"139.47.246.183\"},\n"
            + "{\"id\":40,\"first_name\":\"Sanson\",\"last_name\":\"Woodroofe\",\"email\":\"swoodroofe13@bizjournals.com\",\"gender\":\"Male\",\"ip_address\":\"108.160.99.247\"},\n"
            + "{\"id\":41,\"first_name\":\"Livy\",\"last_name\":\"Foster-Smith\",\"email\":\"lfostersmith14@furl.net\",\"gender\":\"Female\",\"ip_address\":\"45.158.211.81\"},\n"
            + "{\"id\":42,\"first_name\":\"Royce\",\"last_name\":\"Risson\",\"email\":\"rrisson15@fda.gov\",\"gender\":\"Male\",\"ip_address\":\"165.0.180.27\"},\n"
            + "{\"id\":43,\"first_name\":\"Ailbert\",\"last_name\":\"Seeks\",\"email\":\"aseeks16@github.com\",\"gender\":\"Male\",\"ip_address\":\"152.20.84.144\"},\n"
            + "{\"id\":44,\"first_name\":\"Rudolfo\",\"last_name\":\"Tebbitt\",\"email\":\"rtebbitt17@alibaba.com\",\"gender\":\"Male\",\"ip_address\":\"92.240.80.12\"},\n"
            + "{\"id\":45,\"first_name\":\"Jeannette\",\"last_name\":\"Camellini\",\"email\":\"jcamellini18@phoca.cz\",\"gender\":\"Female\",\"ip_address\":\"240.220.22.59\"},\n"
            + "{\"id\":46,\"first_name\":\"Thomasine\",\"last_name\":\"Drohan\",\"email\":\"tdrohan19@tmall.com\",\"gender\":\"Polygender\",\"ip_address\":\"203.128.184.187\"},\n"
            + "{\"id\":47,\"first_name\":\"Paddy\",\"last_name\":\"MacGiany\",\"email\":\"pmacgiany1a@toplist.cz\",\"gender\":\"Male\",\"ip_address\":\"83.46.9.1\"},\n"
            + "{\"id\":48,\"first_name\":\"Zaneta\",\"last_name\":\"O' Molan\",\"email\":\"zomolan1b@omniture.com\",\"gender\":\"Female\",\"ip_address\":\"3.135.159.194\"},\n"
            + "{\"id\":49,\"first_name\":\"Michal\",\"last_name\":\"Shoard\",\"email\":\"mshoard1c@miitbeian.gov.cn\",\"gender\":\"Female\",\"ip_address\":\"108.103.127.160\"},\n"
            + "{\"id\":50,\"first_name\":\"Harp\",\"last_name\":\"Yong\",\"email\":\"hyong1d@themeforest.net\",\"gender\":\"Male\",\"ip_address\":\"108.177.57.76\"},\n"
            + "{\"id\":51,\"first_name\":\"Ossie\",\"last_name\":\"Garment\",\"email\":\"ogarment1e@microsoft.com\",\"gender\":\"Male\",\"ip_address\":\"59.157.133.33\"},\n"
            + "{\"id\":52,\"first_name\":\"Abram\",\"last_name\":\"Harrell\",\"email\":\"aharrell1f@ehow.com\",\"gender\":\"Male\",\"ip_address\":\"177.4.236.51\"},\n"
            + "{\"id\":53,\"first_name\":\"Eb\",\"last_name\":\"Musla\",\"email\":\"emusla1g@diigo.com\",\"gender\":\"Male\",\"ip_address\":\"236.134.149.235\"},\n"
            + "{\"id\":54,\"first_name\":\"Arden\",\"last_name\":\"Fishpool\",\"email\":\"afishpool1h@washington.edu\",\"gender\":\"Female\",\"ip_address\":\"123.32.219.45\"},\n"
            + "{\"id\":55,\"first_name\":\"Adham\",\"last_name\":\"Sommerlin\",\"email\":\"asommerlin1i@cnbc.com\",\"gender\":\"Male\",\"ip_address\":\"249.91.20.190\"},\n"
            + "{\"id\":56,\"first_name\":\"Yancy\",\"last_name\":\"Redgewell\",\"email\":\"yredgewell1j@sciencedaily.com\",\"gender\":\"Male\",\"ip_address\":\"24.29.144.170\"},\n"
            + "{\"id\":57,\"first_name\":\"Mycah\",\"last_name\":\"McIlvoray\",\"email\":\"mmcilvoray1k@umn.edu\",\"gender\":\"Male\",\"ip_address\":\"102.53.56.164\"},\n"
            + "{\"id\":58,\"first_name\":\"Tracie\",\"last_name\":\"Bernhardt\",\"email\":\"tbernhardt1l@nps.gov\",\"gender\":\"Male\",\"ip_address\":\"19.160.67.204\"},\n"
            + "{\"id\":59,\"first_name\":\"Marcelo\",\"last_name\":\"Rennock\",\"email\":\"mrennock1m@prnewswire.com\",\"gender\":\"Male\",\"ip_address\":\"82.86.69.89\"},\n"
            + "{\"id\":60,\"first_name\":\"Cass\",\"last_name\":\"Chene\",\"email\":\"cchene1n@skype.com\",\"gender\":\"Male\",\"ip_address\":\"27.26.188.47\"},\n"
            + "{\"id\":61,\"first_name\":\"Maribelle\",\"last_name\":\"Appleford\",\"email\":\"mappleford1o@nhs.uk\",\"gender\":\"Female\",\"ip_address\":\"50.15.19.99\"},\n"
            + "{\"id\":62,\"first_name\":\"Mia\",\"last_name\":\"Naton\",\"email\":\"mnaton1p@msn.com\",\"gender\":\"Female\",\"ip_address\":\"171.22.130.241\"},\n"
            + "{\"id\":63,\"first_name\":\"Laney\",\"last_name\":\"Jaquest\",\"email\":\"ljaquest1q@ucsd.edu\",\"gender\":\"Female\",\"ip_address\":\"219.166.228.253\"},\n"
            + "{\"id\":64,\"first_name\":\"Marcus\",\"last_name\":\"Savill\",\"email\":\"msavill1r@illinois.edu\",\"gender\":\"Male\",\"ip_address\":\"54.47.48.165\"},\n"
            + "{\"id\":65,\"first_name\":\"William\",\"last_name\":\"O'Kelly\",\"email\":\"wokelly1s@army.mil\",\"gender\":\"Male\",\"ip_address\":\"34.249.255.86\"},\n"
            + "{\"id\":66,\"first_name\":\"Colver\",\"last_name\":\"Kembley\",\"email\":\"ckembley1t@imgur.com\",\"gender\":\"Male\",\"ip_address\":\"171.154.82.30\"},\n"
            + "{\"id\":67,\"first_name\":\"Enrique\",\"last_name\":\"Kulic\",\"email\":\"ekulic1u@typepad.com\",\"gender\":\"Male\",\"ip_address\":\"159.101.43.153\"},\n"
            + "{\"id\":68,\"first_name\":\"Jermaine\",\"last_name\":\"Fawltey\",\"email\":\"jfawltey1v@oakley.com\",\"gender\":\"Male\",\"ip_address\":\"244.164.13.225\"},\n"
            + "{\"id\":69,\"first_name\":\"Robinson\",\"last_name\":\"Byllam\",\"email\":\"rbyllam1w@msn.com\",\"gender\":\"Male\",\"ip_address\":\"218.254.49.255\"},\n"
            + "{\"id\":70,\"first_name\":\"Gerhardt\",\"last_name\":\"Dalgleish\",\"email\":\"gdalgleish1x@washington.edu\",\"gender\":\"Male\",\"ip_address\":\"118.17.148.186\"}]"; // Generate ~10 KB JSON

        // Encode JSON to Base64
        //String encodedJson = Base64.getEncoder().encodeToString(json.getBytes());

        String encodedJson = compressAndEncode(json);

                // Set the JSON as a header
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Large-Json", encodedJson);

        // Send request
        HttpEntity<String> request = new HttpEntity<>(null, headers);
        String url = "http://localhost:8081/restapi/receive-json";

        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

        System.out.println("Response: " + response.getBody());
    }

    public static String compressAndEncode(String data) {
        ByteArrayOutputStream byteStream = null;
        GZIPOutputStream gzipStream = null;
        try {
            byteStream = new ByteArrayOutputStream();
            gzipStream = new GZIPOutputStream(byteStream);
            gzipStream.write(data.getBytes());
            gzipStream.finish();
            byte[] compressedBytes = byteStream.toByteArray();
            return Base64.getEncoder().encodeToString(compressedBytes);
        } catch (Exception e) {
            throw new RuntimeException("Failed to compress data", e);
        } finally {
            try {
                if (gzipStream != null) {
                    gzipStream.close();
                }
                if (byteStream != null) {
                    byteStream.close();
                }
            } catch (Exception ignored) {
                // Ignore closing exceptions
            }
        }
    }
}

