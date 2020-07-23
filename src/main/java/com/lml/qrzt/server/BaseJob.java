package com.lml.qrzt.server;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * creator：李茂林
 * date: 2020/7/22
 */
public interface BaseJob extends Job {
    public void execute(JobExecutionContext context) throws JobExecutionException;
}