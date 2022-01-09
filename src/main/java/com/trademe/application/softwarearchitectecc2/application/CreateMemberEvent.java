package com.trademe.application.softwarearchitectecc2.application;

import com.trademe.application.softwarearchitectecc2.domain.model.MemberId;
import com.trademe.application.softwarearchitectecc2.kernel.ApplicationEvent;

public class CreateMemberEvent implements ApplicationEvent {
    public final MemberId memberId;

    public CreateMemberEvent(MemberId memberId) {
        this.memberId = memberId;
    }
}
