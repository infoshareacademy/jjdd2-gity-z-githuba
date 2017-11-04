package pl.infoshareacademy.service;

import pl.infoshareacademy.model.Log;

import java.util.List;

public interface LogDAO {
    Log getLogById(Integer id);

    List<Log> getAllLogs();

    List<Log> getLogsByIdRange(Integer min, Integer max);

    List<Log> getLogsByLevel(String level);

    Integer deleteLogById(Integer id);

    void deleteAllLogs();
}
