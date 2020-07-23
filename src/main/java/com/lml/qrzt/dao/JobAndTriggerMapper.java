package com.lml.qrzt.dao;

import com.lml.qrzt.entity.JobAndTrigger;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Priority;
import java.util.List;

/**
 * creator：李茂林
 * date: 2020/7/22
 */
//查询所有定义任务相关信息的接口
    @Mapper
public interface JobAndTriggerMapper {
    @Select("SELECT " +
            "QRTZ_JOB_DETAILS.JOB_NAME, " +
            "QRTZ_JOB_DETAILS.JOB_GROUP, " +
            "QRTZ_JOB_DETAILS.JOB_CLASS_NAME, " +
            "QRTZ_TRIGGERS.TRIGGER_NAME, " +
            "QRTZ_TRIGGERS.TRIGGER_GROUP, " +
            "QRTZ_CRON_TRIGGERS.CRON_EXPRESSION, " +
            "QRTZ_CRON_TRIGGERS.TIME_ZONE_ID " +
            "FROM " +
            "QRTZ_JOB_DETAILS " +
            "JOIN QRTZ_TRIGGERS " +
            "JOIN QRTZ_CRON_TRIGGERS ON QRTZ_JOB_DETAILS.JOB_NAME = QRTZ_TRIGGERS.JOB_NAME " +
            "AND QRTZ_TRIGGERS.TRIGGER_NAME = QRTZ_CRON_TRIGGERS.TRIGGER_NAME " +
            "AND QRTZ_TRIGGERS.TRIGGER_GROUP = QRTZ_CRON_TRIGGERS.TRIGGER_GROUP")
    public List<JobAndTrigger> getJobAndTriggerDetails();
}
