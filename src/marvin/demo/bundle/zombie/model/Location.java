package marvin.demo.bundle.zombie.model;

public class Location {
    
    private Long id;
    private String name;
    
    private long lat;
    private long lon;

    public Location() {
    }

    public Location(String name, long lat, long lon) {
        this.name = name;
        this.lat = lat;
        this.lon = lon;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getLat() {
        return lat;
    }

    public void setLat(long lat) {
        this.lat = lat;
    }

    public long getLon() {
        return lon;
    }

    public void setLon(long lon) {
        this.lon = lon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Location{" + "name=" + name + ", lat=" + lat + ", lon=" + lon + '}';
    }
}
