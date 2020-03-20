package response;

import java.util.List;

public class StationResponse {
    private String id;
    private String stationName;
    private List<InstallationResponse> installations;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }
}
