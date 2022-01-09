package com.trademe.application.softwarearchitectecc2.application;

import com.trademe.application.softwarearchitectecc2.domain.model.Member;
import com.trademe.application.softwarearchitectecc2.domain.repository.MemberRepository;
import com.trademe.application.softwarearchitectecc2.kernel.EventListener;

import java.util.List;

public class BillPaymentMonthlyEventListener implements EventListener<BillPaymentEvent> {
    private MemberRepository memberRepository;

    public BillPaymentMonthlyEventListener(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void listenTo(BillPaymentEvent event) {
        System.out.println("monthly payment process for all usres");
        final List<Member> members = memberRepository.All();

        for (Member member : members){
            member.getCreditCardList().forEach(creditCard -> {PaymentVerification.PaymentRequest(creditCard);});
        }

        System.out.println("Payment successful");


    }
}
