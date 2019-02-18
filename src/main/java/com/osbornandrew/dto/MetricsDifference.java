package com.osbornandrew.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDate;

@JsonPropertyOrder({"teamId","teamName","conferenceName","date1","date2","net1","net2","netChange","sos1","sos2","sosChange",
"q1Wins1","q1Wins2","q1WinsChange","q2Wins1","q2Wins2","q2WinsChange","q3Losses1","q3Losses2","q3LossesChange",
"q4Losses1","q4Losses2","q4LossesChange"})
public interface MetricsDifference {
    Long getTeamId();
    String getTeamName();
    String getConferenceName();
    LocalDate getDate1();
    LocalDate getDate2();
    int getNet1();
    int getNet2();
    int getNetChange();
    int getSos1();
    int getSos2();
    int getSosChange();
    int getQ1Wins1();
    int getQ1Wins2();
    int getQ1WinsChange();
    int getQ2Wins1();
    int getQ2Wins2();
    int getQ2WinsChange();
    int getQ3Losses1();
    int getQ3Losses2();
    int getQ3LossesChange();
    int getQ4Losses1();
    int getQ4Losses2();
    int getQ4LossesChange();
}
