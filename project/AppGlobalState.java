package src.src.main.java.project;

public class AppGlobalState {

    private static AppGlobalState instanse;

    private String cityKey;

    public String getCityKey() {
        return cityKey;
    }

    public void setCityKey(String cityKey) {
        this.cityKey = cityKey;
    }

    public String getApiKey() {
        return "H6ldpZ8Uej2NF2cOGdMmZa5wo1wWr0vq";
    }
    /*public String getApiKey() {
        return System.getenv("ACCUWEATHER_API_KEY");
    }*/

    private AppGlobalState() {
    }

    public static AppGlobalState getInstance() {
        if (instanse == null) {
            instanse = new AppGlobalState();
        }
        return instanse;
    }



}
