package com.trademe.application.softwarearchitectecc2.application;

import com.trademe.application.softwarearchitectecc2.domain.model.Member;
import com.trademe.application.softwarearchitectecc2.domain.model.MemberId;
import com.trademe.application.softwarearchitectecc2.domain.repository.MemberRepository;
import com.trademe.application.softwarearchitectecc2.kernel.QueryHandler;

public class RetrieveMemberByIdHandler implements QueryHandler<RetrieveMemberById, Member> {
    private MemberRepository memberRepository;

    public RetrieveMemberByIdHandler(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Member handle(RetrieveMemberById id) {
        MemberId memberId = new MemberId(id.id);
        return (Member) memberRepository.findById(memberId);
    }
}
