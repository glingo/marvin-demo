package marvin.demo.bundle.zombie.model;

public class Location {
    
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
}
