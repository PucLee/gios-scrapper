package config;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import response.InstallationResponse;
import response.StationResponse;

import java.lang.reflect.Type;
import java.util.HashSet;

public class GsonConfig {
    public static final Gson gson = new Gson();
    public static final Type stationSetType = new TypeToken<HashSet<StationResponse>>() {
    }.getType();
    public static final Type installationSetType = new TypeToken<HashSet<InstallationResponse>>() {
    }.getType();
}
