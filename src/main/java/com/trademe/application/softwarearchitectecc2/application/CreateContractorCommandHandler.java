package com.trademe.application.softwarearchitectecc2.application;

import com.trademe.application.softwarearchitectecc2.domain.model.Contractor;
import com.trademe.application.softwarearchitectecc2.domain.model.Member;
import com.trademe.application.softwarearchitectecc2.domain.model.MemberId;
import com.trademe.application.softwarearchitectecc2.domain.repository.MemberRepository;
import com.trademe.application.softwarearchitectecc2.kernel.CommandHandler;
import com.trademe.application.softwarearchitectecc2.kernel.Event;
import com.trademe.application.softwarearchitectecc2.kernel.EventBus;

public class CreateContractorCommandHandler implements CommandHandler<CreateMember, MemberId> {

    private final MemberRepository memberRepository;
    private final EventBus<Event> eventBus;

    public CreateContractorCommandHandler(MemberRepository memberRepository, EventBus<Event> eventBus) {
        this.memberRepository = memberRepository;
        this.eventBus = eventBus;
    }


    @Override
    public MemberId handle(CreateMember createMember) {
        final MemberId memberId = (MemberId) memberRepository.nextIdentity();
        Member member = new Contractor(memberId, createMember.firstName, createMember.lastName, createMember.memberInformation);
        memberRepository.add(member);
        eventBus.publish(new CreateMemberEvent(memberId));
        return memberId;
    }

}
