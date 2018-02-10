package libs;

public class HostData {

    private String driver;
    private String host;
    private String name;
    private String password;

    public void HostData() {
        //leer json
        

        setDriver(driver);
    }

    public String getDriver() {
        return driver;
    }

    private void setDriver(String driver) {
        this.driver = driver;
    }

    public String getHost() {
        return host;
    }

    private void setHost(String host) {
        this.host = host;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        this.password = password;
    }
}
