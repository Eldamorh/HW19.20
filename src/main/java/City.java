import java.util.UUID;

public final class City {
    private final String name;
    private final UUID id;

    public City(String name) {
        this.name = name;
        id = UUID.randomUUID();
    }

    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }
}
