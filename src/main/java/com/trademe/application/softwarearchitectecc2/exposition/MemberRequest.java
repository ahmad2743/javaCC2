package com.trademe.application.softwarearchitectecc2.exposition;

import com.sun.istack.NotNull;
import com.trademe.application.softwarearchitectecc2.domain.model.Address;

public class MemberRequest {
    @NotNull
    public String firstName;

    @NotNull
    public String lastName;

    @NotNull
    public MemberInformationsrequest information;



}
