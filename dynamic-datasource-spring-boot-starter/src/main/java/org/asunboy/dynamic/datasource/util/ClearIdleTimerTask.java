package org.asunboy.dynamic.datasource.util;


import org.asunboy.dynamic.datasource.common.CurrentDbSchemaHolder;

import java.util.TimerTask;

public class ClearIdleTimerTask extends TimerTask {
    @Override
    public void run() {
        CurrentDbSchemaHolder.instance().clearIdleDbSchema();
    }
}
