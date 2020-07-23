package com.lml.qrzt.server;

import com.github.pagehelper.PageInfo;
import com.lml.qrzt.entity.JobAndTrigger;
import org.springframework.stereotype.Service;

/**
 * creator：李茂林
 * date: 2020/7/22
 */
@Service("IJobAndTriggerService")
public interface IJobAndTriggerService {
    public PageInfo<JobAndTrigger> getJobAndTriggerDetails(int pageNum, int pageSize);
}