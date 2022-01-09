package com.trademe.application.softwarearchitectecc2.application;

import com.trademe.application.softwarearchitectecc2.domain.model.CreditCard;
import com.trademe.application.softwarearchitectecc2.domain.model.MemberId;
import com.trademe.application.softwarearchitectecc2.domain.model.MemberInformation;
import com.trademe.application.softwarearchitectecc2.kernel.Command;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CreateMember implements Command {
    protected final String firstName;
    protected final String lastName;
    protected MemberInformation memberInformation;
    protected List<CreditCard> creditCardList = new ArrayList<>();

    public CreateMember(String firstName, String lastName, MemberInformation memberInformation){
        this.firstName = Objects.requireNonNull(firstName);
        this.lastName = Objects.requireNonNull(lastName);
        this.memberInformation = Objects.requireNonNull(memberInformation);
    }
    public void setCreditCard( CreditCard card) {
        this.creditCardList.add(card);
    }



}
