package pl.infoshareacademy.service;

import pl.infoshareacademy.model.Log;

import java.util.ArrayList;
import java.util.List;

public class LogDAOImpl implements LogDAO {
    List<Log> logList;

    public LogDAOImpl() {
        logList = new ArrayList<Log>();
        Log log1 = new Log(1, "First log!");
        Log log2 = new Log(2, "Second log!");
        logList.add(log1);
        logList.add(log2);
    }

    @Override
    public void deleteLog(Log log) {
        logList.remove(log.getId());
        System.out.println("Student: ID: " + log.getId() + "DELETED");
    }

    @Override
    public List<Log> getAllLog() {
        return logList;
    }

    @Override
    public Log getLog(int id) {
        return logList.get(id);
    }

    @Override
    public void updateLog(Log log){
        logList.get(log.getId()).setMessage(log.getMessage());
        System.out.println("Log ID: " + log.getId() + "Updated!");
    }

}
