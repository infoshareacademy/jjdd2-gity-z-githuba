package pl.infoshareacademy.service;

import pl.infoshareacademy.model.Log;

import java.util.List;

public interface LogDAO {
    public List<Log> getAllLog();
    public Log getLog(int logId);
    public void deleteLog(Log log);
    public void updateLog(Log log);
}
