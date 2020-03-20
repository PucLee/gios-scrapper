package dto;

import response.InstallationResponse;

import java.util.Set;

public class StationSummaryDto {
    private String stationId;
    private String stationName;
    private Set<InstallationResponse> installationsResponses;

    public StationSummaryDto(String stationId, String stationName, Set<InstallationResponse> installationsResponses) {
        this.stationId = stationId;
        this.stationName = stationName;
        this.installationsResponses = installationsResponses;
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public Set<InstallationResponse> getInstallationsResponses() {
        return installationsResponses;
    }

    public void setInstallationsResponses(Set<InstallationResponse> installationsResponses) {
        this.installationsResponses = installationsResponses;
    }
}
