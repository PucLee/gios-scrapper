package client;

import config.GsonConfig;
import dto.StationSummaryDto;
import response.InstallationResponse;
import response.StationResponse;
import service.ResultPrinter;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Set;
import java.util.TimerTask;
import java.util.concurrent.CompletableFuture;

import static config.GsonConfig.installationSetType;
import static config.GsonConfig.stationSetType;
import static java.util.stream.Collectors.toList;

public class GiosClient extends TimerTask {

    private static HttpClient client = HttpClient.newHttpClient();

    private final ResultPrinter resultPrinter = new ResultPrinter();

    @Override
    public void run() {
        printOverallData();
    }

    void printOverallData() {
        List<CompletableFuture<StationSummaryDto>> futures = fetchAllStationsData().parallelStream()
                .map(stationResponse ->
                        fetchInstallationData(stationResponse.getId())
                                .thenApply(
                                        (Set<InstallationResponse> installationResponses) ->
                                                new StationSummaryDto(stationResponse.getId(),
                                                        stationResponse.getStationName(),
                                                        installationResponses)
                                )
                )
                .collect(toList());

        futures.stream()
                .map(CompletableFuture::join)
                .forEach(resultPrinter::printGiosData);
    }

    public Set<StationResponse> fetchAllStationsData() {
        var response = fetchData("http://api.gios.gov.pl/pjp-api/rest/station/findAll");

        return GsonConfig.gson.fromJson(response.body(), stationSetType);
    }

    public CompletableFuture<Set<InstallationResponse>> fetchInstallationData(final String stationId) {
        return CompletableFuture.supplyAsync(() -> fetchData("http://api.gios.gov.pl/pjp-api/rest/station/sensors/" + stationId))
                .thenApply((response) -> GsonConfig.gson.fromJson(response.body(), installationSetType));
    }

    private HttpResponse<String> fetchData(final String url) {
        var httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        try {
            return client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
