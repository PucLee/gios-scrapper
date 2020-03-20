package response;

public class InstallationResponse {
    private String id;
    private String stationId;
    private ParamResponse param;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public ParamResponse getParam() {
        return param;
    }

    public void setParam(ParamResponse param) {
        this.param = param;
    }
}
