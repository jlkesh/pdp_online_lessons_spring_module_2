package objectmapper;

public class Settings {
    private Datasource datasource;

    public Datasource getDatasource() {
        return datasource;
    }

    public void setDatasource(Datasource datasource) {
        this.datasource = datasource;
    }

    @Override
    public String toString() {
        return "Settings{" +
                "datasource=" + datasource +
                '}';
    }
}
