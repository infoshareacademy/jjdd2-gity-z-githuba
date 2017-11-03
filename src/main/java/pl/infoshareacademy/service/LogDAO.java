package pl.infoshareacademy.service;

import pl.infoshareacademy.model.Log;

import java.util.List;

public interface LogDAO {
    public Log getLogById(Integer id);
    public List<Log> getAllLogs();
    public List<Log> getLogsByIdRange(Integer min, Integer max);
    public List<Log> getLogsByLevel(String level);
    public Integer deleteLogById(Integer id);
    public void deleteAllLogs();
}
