package marvin.demo.bundle.game.model;

public class Game {
    
    private Long id;
    private String title;
    private String description;
    
    private int width = 100;
    private int height = 20;
    private int tick;
    private boolean running;
    
    private int lon = 10;
    private int lat = 10;
    private int v = 1;
    private int dir = 1;
    private int vdir = 1;
    private boolean red;

    public Game(String title, String description) {
        this.title = title;
        this.description = description;
    }
    
    public void update() {
        if (Math.random() % 2 == 0) {
            dir = getLat() >= getHeight() - 1 ? -dir : getLat() <= 1 ? -dir : dir;
            setLat(getLat() + (v * dir));
        } else {
            vdir = getLon() >= getWidth() - 1 ? -vdir : getLon() <= 1 ? -vdir : vdir;
            setLon(getLon() + (v * vdir));
        }

        this.tick++;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLat(int lat) {
        if (this.width < lat) {
            return;
        }
        this.lat = lat;
    }

    public int getLon() {
        return lon;
    }

    public int getLat() {
        return lat;
    }

    public boolean isRed() {
        return red;
    }

    public void setLon(int lon) {
        if (this.height < lat) {
            return;
        }
        this.lon = lon;
    }

    public void setRed(boolean red) {
        this.red = red;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getTick() {
        return tick;
    }

    public void setTick(int tick) {
        this.tick = tick;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
    
    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
