package com.trademe.application.softwarearchitectecc2.application;

import com.trademe.application.softwarearchitectecc2.domain.model.CreditCard;
import com.trademe.application.softwarearchitectecc2.domain.model.Member;
import com.trademe.application.softwarearchitectecc2.domain.model.MemberId;
import com.trademe.application.softwarearchitectecc2.domain.repository.MemberRepository;
import com.trademe.application.softwarearchitectecc2.kernel.EventListener;


public class CreateMemberEventListener implements EventListener<CreateMemberEvent> {

    MemberRepository memberRepository;
    public CreateMemberEventListener(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void listenTo(CreateMemberEvent event) {
        System.out.println("waiting to make a verification card in order to valid the registration");
        Member member = (Member) memberRepository.findById(event.memberId);
        member.getCreditCardList().forEach(creditCard -> PaymentVerification.PaymentRequest(creditCard));
    }

}
