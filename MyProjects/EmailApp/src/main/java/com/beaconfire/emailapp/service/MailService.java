package com.beaconfire.emailapp.service;

import com.beaconfire.emailapp.QuizHistoryMessage;
import com.beaconfire.emailapp.SimpleMessage;

public interface MailService {
    void sendEmail(QuizHistoryMessage msg);
}
