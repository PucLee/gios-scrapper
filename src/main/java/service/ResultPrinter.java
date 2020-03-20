package service;

import dto.StationSummaryDto;

import static java.lang.String.format;

public class ResultPrinter {

    public void printGiosData(final StationSummaryDto stationSummaryDto) {
        System.out.println(format("Station #%s (%s)", stationSummaryDto.getStationId(), stationSummaryDto.getStationName()));
        stationSummaryDto.getInstallationsResponses().forEach(
                installationResponse -> System.out.println(format("- installation #%s: ‘%s’", installationResponse.getId(), installationResponse.getParam().getParamFormula())));
    }
}
