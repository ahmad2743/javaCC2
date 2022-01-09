package com.trademe.application.softwarearchitectecc2.application;

import com.trademe.application.softwarearchitectecc2.kernel.Command;
import com.trademe.application.softwarearchitectecc2.kernel.Query;

public class RetrieveMemberById implements Query {
    public final int id;

    public RetrieveMemberById(int id) {
        this.id = id;
    }
}
