package org.gs;

import io.smallrye.config.ConfigMapping;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.net.URL;

@ConfigMapping(prefix = "tvSeries")
public class TvSeries {

    @ConfigProperty(name = "name", defaultValue = "Lupin")
    private String name;

    @ConfigProperty(name = "summary", defaultValue = "Lupin is the best tv series in France")
    private String summary;

    @ConfigProperty(name = "language", defaultValue = "FR")
    private String language;

    @ConfigProperty(name = "officialSite", defaultValue = "https://www.netflix.com/lupin")
    private URL officialSite;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public URL getOfficialSite() {
        return officialSite;
    }

    public void setOfficialSite(URL officialSite) {
        this.officialSite = officialSite;
    }
}
