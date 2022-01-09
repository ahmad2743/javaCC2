package com.trademe.application.softwarearchitectecc2.application;

import com.trademe.application.softwarearchitectecc2.domain.model.Member;
import com.trademe.application.softwarearchitectecc2.domain.model.MemberId;
import com.trademe.application.softwarearchitectecc2.domain.model.Tradesman;
import com.trademe.application.softwarearchitectecc2.domain.repository.MemberRepository;
import com.trademe.application.softwarearchitectecc2.kernel.CommandHandler;
import com.trademe.application.softwarearchitectecc2.kernel.Event;
import com.trademe.application.softwarearchitectecc2.kernel.EventBus;

public class CreateTradesmanCommandHandler implements CommandHandler<CreateMember, MemberId> {

    private final MemberRepository memberRepository;
    private final EventBus<Event> eventBus;

    public CreateTradesmanCommandHandler(MemberRepository memberRepository, EventBus<Event> eventBus) {
        this.memberRepository = memberRepository;
        this.eventBus = eventBus;
    }

    @Override
    public MemberId handle(CreateMember createMember) {
        final MemberId memberId = (MemberId) memberRepository.nextIdentity();
        Member member = new Tradesman(memberId, createMember.firstName, createMember.lastName, createMember.memberInformation);
        memberRepository.add(member);
        eventBus.publish(new CreateMemberEvent(memberId));
        return memberId;
    }
}
