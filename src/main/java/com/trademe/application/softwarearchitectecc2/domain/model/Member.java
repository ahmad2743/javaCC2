package com.trademe.application.softwarearchitectecc2.domain.model;



import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Member{
    protected final MemberId memberId;
    protected final String firstName;
    protected final String lastName;
    protected MemberInformation memberInformation;
    protected List<CreditCard> creditCardList = new ArrayList<>();

    Member(MemberId memberId, String firstName, String lastName, MemberInformation memberInformation){
        this.memberId = Objects.requireNonNull(memberId);
        this.firstName = Objects.requireNonNull(firstName);
        this.lastName = Objects.requireNonNull(lastName);
        this.memberInformation = Objects.requireNonNull(memberInformation);
    }

    public void setCreditCard( CreditCard card) {
        this.creditCardList.add(card);
    }

    public MemberId getId(){return memberId;
    }
    public List<CreditCard> getCreditCardList() {
        return creditCardList;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", memberInformation=" + memberInformation +
                ", creditCardList=" + creditCardList +
                '}';
    }
}